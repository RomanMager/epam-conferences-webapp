package com.epam.conference.dao.impl;

import com.epam.conference.dao.ConferenceDao;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;

import java.util.List;

public class ConferenceDaoImpl implements ConferenceDao {
    @Override
    public Conference findByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Conference> findAll() throws DaoException {
        return null;
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
