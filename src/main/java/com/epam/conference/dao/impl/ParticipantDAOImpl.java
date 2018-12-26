package com.epam.conference.dao.impl;

import com.epam.conference.dao.ParticipantDAO;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DAOException;
import com.epam.conference.pool.ConnectionPool;
import com.epam.conference.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ParticipantDAOImpl implements ParticipantDAO {
    private static final String SQL_ADD_PARTICIPANT = "INSERT INTO persons(login, password, email) VALUES (?,?,?)";

    private static ParticipantDAOImpl instance = new ParticipantDAOImpl();

    private ParticipantDAOImpl() {
    }

    public static ParticipantDAOImpl getInstance() {
        return instance;
    }

    @Override
    public void add(Person entity) throws DAOException {
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
    public List<Person> findAll() {
        return null;
    }

    @Override
    public void registerParticipant() {

    }
}
