package com.epam.conference.service;

import com.epam.conference.dao.impl.ParticipantDaoImpl;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ParticipantService {

    public void createParticipant(Person person, ParticipantData data) throws ServiceException {
        // TODO: VALIDATION
        //      - Check if already exists in DB
        ParticipantDaoImpl participantDAOImpl = ParticipantDaoImpl.getInstance();
        try {
            participantDAOImpl.registerParticipant(person, data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Person> findAllParticipants() throws ServiceException {
        List<Person> personList;
        try {
            personList = ParticipantDaoImpl.getInstance().findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return personList;
    }

    public Person findParticipant(String login, String password) throws ServiceException {
        Person person;
        try {
            person = ParticipantDaoImpl.getInstance().findParticipantByLoginPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return person;
    }

    public Person findParticipant(int participantId) throws ServiceException {
        Person person;

        try {
            person = ParticipantDaoImpl.getInstance().findParticipantById(participantId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return person;
    }

    public ParticipantData findParticipantData(int participantId) throws ServiceException {
        ParticipantData data;

        try {
            data = ParticipantDaoImpl.getInstance().findParticipantDataById(participantId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return data;
    }
}
