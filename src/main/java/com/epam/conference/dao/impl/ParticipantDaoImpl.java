package com.epam.conference.dao.impl;

import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
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
    private static final String SQL_FIND_BY_LOGIN_PASSWORD = "SELECT * FROM persons WHERE persons.login = ? AND persons.password = ?;";
    private static final String SQL_ADD_PARTICIPANT = "INSERT INTO persons(login, password, email) VALUES (?,?,?);";
    //    private static final String SQL_ADD_PARTICIPANT_DATA = "INSERT INTO participant_data(personId, name, surname) VALUES (?,?,?);";
    private static final String SQL_ADD_PARTICIPANT_TRANSACTION_USER = "INSERT INTO persons(login, password, email, roleId) VALUES (?,?,?,?);";
    private static final String SQL_ADD_PARTICIPANT_TRANSACTION_DATA = "INSERT INTO participant_data(personId, name, surname) VALUES (LAST_INSERT_ID(),?,?);";
    private static final String SQL_GET_ALL_PARTICIPANTS = "SELECT personId, login, password, email FROM persons;";

    private static ParticipantDaoImpl instance = new ParticipantDaoImpl();

    private ParticipantDaoImpl() {
    }

    public static ParticipantDaoImpl getInstance() {
        return instance;
    }

    // TODO: Refactor to create admins
    //  - create supplementary function 'createAdmins' as like 'createParticipants'
    @Override
    public void add(Person person) throws DaoException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement psUser = connection.prepareStatement(SQL_ADD_PARTICIPANT)) {
            psUser.setString(1, person.getLogin());
            psUser.setString(2, person.getPassword());
            psUser.setString(3, person.getEmail());
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
        try (PreparedStatement psUser = connection.prepareStatement(SQL_ADD_PARTICIPANT_TRANSACTION_USER);
             PreparedStatement psData = connection.prepareStatement(SQL_ADD_PARTICIPANT_TRANSACTION_DATA)) {

            connection.setAutoCommit(false);

            psUser.setString(1, person.getLogin());
            psUser.setString(2, person.getPassword());
            psUser.setString(3, person.getEmail());
            psUser.setInt(4, person.getRole().getRoleNameId());
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
                    // TODO: Really throw exception from 'finally'?
                    //  - or just logging it?
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
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            participants = this.createParticipants(result);
        } catch (SQLException e) {
            throw new DaoException("An error occurred when tried to find a user by login and password.", e);
        }

        return participants.get(0);
    }

    private List<Person> createParticipants(ResultSet resultSet) throws DaoException {
        List<Person> personList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Person person = new Person(login, email, password);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new DaoException("Could not find a user.");
        }

        return personList;
    }
}
