package com.epam.conference.service;

import com.epam.conference.dao.impl.ConferenceDaoImpl;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

import java.util.List;

public class ConferenceService {
    public void createConference(Conference conference, int adminId) throws ServiceException {
        try {
            ConferenceDaoImpl.getInstance().addConference(conference, adminId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Conference> findAllConferences() throws ServiceException {
        List<Conference> conferences;
        try {
            conferences = ConferenceDaoImpl.getInstance().findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return conferences;
    }
}
