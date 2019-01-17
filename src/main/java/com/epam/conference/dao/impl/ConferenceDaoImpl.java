package com.epam.conference.dao.impl;

import com.epam.conference.dao.ConferenceDao;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.pool.ConnectionPool;
import com.epam.conference.pool.ProxyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceDaoImpl implements ConferenceDao {
    private static final String SQL_CREATE_CONFERENCE = "INSERT INTO conferences(title, topic, description, admin) VALUES (?,?,?,?);";
    private static final String SQL_GET_ALL_CONFERENCES = "SELECT title, topic, description FROM conferences;";

    private static ConferenceDaoImpl instance = new ConferenceDaoImpl();

    private ConferenceDaoImpl() {
    }

    public static ConferenceDaoImpl getInstance() {
        return instance;
    }

    public void addConference(Conference entity, int adminId) throws DaoException {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement psConf = connection.prepareStatement(SQL_CREATE_CONFERENCE)) {
            psConf.setString(1, entity.getTitle());
            psConf.setString(2, entity.getTopic());
            psConf.setString(3, entity.getDescription());
            psConf.setInt(4, adminId);

            psConf.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Conference findByName(String name) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Conference> findAll() throws DaoException {
        List<Conference> conferences;

        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement psGetAll = connection.prepareStatement(SQL_GET_ALL_CONFERENCES)) {
            ResultSet resultSet = psGetAll.executeQuery();
            conferences = this.createConferences(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return conferences;
    }

    private List<Conference> createConferences(ResultSet resultSet) throws DaoException {
        List<Conference> conferenceList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String topic = resultSet.getString("topic");
                String description = resultSet.getString("description");

                Conference conference = new Conference(title, topic, description);
                conferenceList.add(conference);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return conferenceList;
    }

    @Override
    public void add(Conference entity) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Conference entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Conference entity) {
        throw new UnsupportedOperationException();
    }
}
