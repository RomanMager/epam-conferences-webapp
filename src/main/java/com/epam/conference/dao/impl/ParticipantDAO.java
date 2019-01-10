package com.epam.conference.dao.impl;

import com.epam.conference.entity.Person;
import com.epam.conference.exception.DAOException;
import com.epam.conference.pool.ConnectionPool;
import com.epam.conference.pool.ProxyConnection;
import lombok.extern.log4j.Log4j2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ParticipantDAO implements com.epam.conference.dao.ParticipantDAO {
    private static final String SQL_FIND_BY_LOGIN_PASSWORD = "SELECT * FROM persons WHERE persons.login = ? AND persons.password = ?;";
    private static final String SQL_ADD_PARTICIPANT = "INSERT INTO persons(login, password, email) VALUES (?,?,?);";
    private static final String SQL_GET_ALL_PARTICIPANTS = "SELECT personId, login, password, email FROM persons;";

    private static ParticipantDAO instance = new ParticipantDAO();

    private ParticipantDAO() {
    }

    public static ParticipantDAO getInstance() {
        return instance;
    }

    @Override
    public void add(Person entity) throws DAOException { // TODO: Rename parameter
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_PARTICIPANT)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void remove(Person entity) {

    }

    @Override
    public void update(Person entity) {

    }

    @Override
    public List<Person> findAll() throws DAOException {
        List<Person> participants;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_PARTICIPANTS)) {
            ResultSet resultSet = statement.executeQuery();
            participants = this.createParticipants(resultSet);
        } catch (SQLException e) {
            throw new DAOException(e); // TODO: Add meaningful message
        }

        return participants;
    }

    // TODO: Delete -- to create\register a user method `add()` is used
    @Override
    public void registerParticipant() {
        throw new UnsupportedOperationException();
    }

    public Person findParticipantByLoginPassword(String login, String password) throws DAOException {
        List<Person> participants;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            participants = this.createParticipants(result);
        } catch (SQLException e) {
            throw new DAOException("An error occurred when tried to find a user by login and password.", e);
        }

        return participants.get(0);
    }

    private List<Person> createParticipants(ResultSet resultSet) throws DAOException {
        List<Person> personList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int personId = resultSet.getInt("personId");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Person person = new Person(personId, login, email, password);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new DAOException("Could not find a user.");
        }

        return personList;
    }
}
