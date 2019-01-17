package com.epam.conference.dao;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;

public interface ConferenceDao extends Dao<Conference> {
    Conference findByName(String name) throws DaoException;
}
