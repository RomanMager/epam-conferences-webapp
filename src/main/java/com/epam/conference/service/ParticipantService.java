package com.epam.conference.service;

import com.epam.conference.dao.impl.ParticipantDao;
import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DAOException;
import com.epam.conference.exception.ServiceException;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ParticipantService {

    public void createParticipant(Person person, ParticipantData data) {
        // TODO: VALIDATION
        //      - Check if already exists in DB
        ParticipantDao participantDAO = ParticipantDao.getInstance();
        try {
            participantDAO.add(person, data);
        } catch (DAOException e) {
            // TODO: TROW exception or LOG exception?
            log.error(e);
        }
    }

    public List<Person> getAllParticipants() throws ServiceException {
        List<Person> personList;
        try {
            personList = ParticipantDao.getInstance().findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return personList;
    }

    public Person findParticipant(String login, String password) {
        Person person = null;
        try {
            person = ParticipantDao.getInstance().findParticipantByLoginPassword(login, password);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return person;
    }

    public Person findParticipant(int participantId) {
        Person person = null;

        return person;
    }

    public ParticipantData findParticipantData(int participantId) {
        ParticipantData data = null;

        return data;
    }
}
