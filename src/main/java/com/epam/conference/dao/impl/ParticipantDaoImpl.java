package com.epam.conference.dao.impl;

import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.entity.Role;
import com.epam.conference.exception.DaoException;
import com.epam.conference.pool.ConnectionPool;
import com.epam.conference.pool.ProxyConnection;
import lombok.extern.log4j.Log4j2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ParticipantDaoImpl implements com.epam.conference.dao.ParticipantDao {
    private static final String SQL_ADD_PARTICIPANT = "INSERT INTO persons(login, password, email, roleId) VALUES (?,?,?,?);";
    private static final String SQL_ADD_PARTICIPANT_DATA = "INSERT INTO participant_data(personId, name, surname) VALUES (LAST_INSERT_ID(),?,?);";
    private static final String SQL_GET_ALL_PARTICIPANTS = "SELECT personId, login, password, email FROM persons;";
    private static final String SQL_FIND_PARTICIPANT_BY_LOGIN_PASSWORD = "SELECT P.personId, P.login, P.email, P.password, P.roleId, R.roleName FROM persons P JOIN roles R ON P.roleId = R.roleId WHERE P.login = ? AND P.password = ?;";
    private static final String SQL_FIND_PARTICIPANT_BY_ID = "SELECT P.personId, P.login, P.email, P.roleId, P.password, R.roleName FROM persons P INNER JOIN roles R ON P.roleId = R.roleId WHERE P.personId=?;";
    private static final String SQL_FIND_PARTICIPANT_DATA_BY_ID = "SELECT pd.participantDataId, pd.personId, pd.name, pd.surname FROM participant_data pd WHERE personId = ?;";
    private static ParticipantDaoImpl instance = new ParticipantDaoImpl();

    private ParticipantDaoImpl() {
    }

    public static ParticipantDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void add(Person person) throws DaoException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement psUser = connection.prepareStatement(SQL_ADD_PARTICIPANT)) {
            psUser.setString(1, person.getLogin());
            psUser.setString(2, person.getPassword());
            psUser.setString(3, person.getEmail());
            psUser.setInt(4, person.getRole().getRoleId());

            psUser.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void remove(Person entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Person entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerParticipant(Person person, ParticipantData data) throws DaoException {
        ProxyConnection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement psUser = connection.prepareStatement(SQL_ADD_PARTICIPANT);
             PreparedStatement psData = connection.prepareStatement(SQL_ADD_PARTICIPANT_DATA)) {

            connection.setAutoCommit(false);

            psUser.setString(1, person.getLogin());
            psUser.setString(2, person.getPassword());
            psUser.setString(3, person.getEmail());
            psUser.setInt(4, person.getRole().getRoleId());
            psUser.executeUpdate();

            psData.setString(1, data.getName());
            psData.setString(2, data.getSurname());
            psData.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new DaoException(e1);
            }
            throw new DaoException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error(e);
                }
            }
        }
    }

    @Override
    public List<Person> findAll() throws DaoException {
        List<Person> participants;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_PARTICIPANTS)) {
            ResultSet resultSet = statement.executeQuery();
            participants = this.createParticipants(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e); // TODO: Add meaningful message
        }

        return participants;
    }

    @Override
    public Person findParticipantByLoginPassword(String login, String password) throws DaoException {
        List<Person> participants;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PARTICIPANT_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            participants = this.createParticipants(result);
        } catch (SQLException e) {
            throw new DaoException("An error occurred when tried to find a user by login and password.", e);
        }

        return participants.get(0);
    }

    public Person findParticipantById(int participantId) throws DaoException {
        List<Person> participants;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PARTICIPANT_BY_ID)) {

            statement.setInt(1, participantId);
            ResultSet result = statement.executeQuery();
            participants = this.createParticipants(result);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return participants.get(0);
    }

    public ParticipantData findParticipantDataById(int participantId) throws DaoException {
        ParticipantData participantData;
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PARTICIPANT_DATA_BY_ID)) {

            statement.setInt(1, participantId);
            ResultSet result = statement.executeQuery();
            participantData = this.createParticipantData(result);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return participantData;
    }

    private ParticipantData createParticipantData(ResultSet resultSet) throws DaoException {
        ParticipantData participantData = null;
        try {
            while (resultSet.next()) {
                int participantDataId = resultSet.getInt("participantDataId");
                int personId = resultSet.getInt("personId");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");

                participantData = new ParticipantData(participantDataId, personId, name, surname);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return participantData;
    }

    private List<Person> createParticipants(ResultSet resultSet) throws DaoException {
        List<Person> personList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int personId = resultSet.getInt("personId");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("roleId");
                String roleName = resultSet.getString("roleName");

                Person person = new Person(personId, login, email, password, new Role(roleId, roleName));
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new DaoException("Could not find a user.");
        }

        return personList;
    }
}
