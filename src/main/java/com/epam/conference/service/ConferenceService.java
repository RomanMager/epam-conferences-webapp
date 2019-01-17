package com.epam.conference.service;

import com.epam.conference.dao.impl.ConferenceDaoImpl;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;

public class ConferenceService {
    public void createConference(Conference conference) throws ServiceException {
        try {
            ConferenceDaoImpl.getInstance().add(conference);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
