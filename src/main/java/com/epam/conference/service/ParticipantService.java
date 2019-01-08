package com.epam.conference.service;

import com.epam.conference.dao.impl.ParticipantDAO;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DAOException;
import com.epam.conference.exception.ServiceException;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ParticipantService {
    public Person findParticipant(String login, String password) {
        Person person = null;
        try {
            person = ParticipantDAO.getInstance().findParticipantByLoginPassword(login, password);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return person;
    }

    public Person findParticipant(String login, String email, String password) {
        throw new UnsupportedOperationException();
    }

    // TODO:
    //  - implement basic functionality without validation
    //  - and without checking if the user already exist in database
    public void createParticipant(Person person) {
        // TODO: VALIDATION
        //      - Check if already exists in DB
        ParticipantDAO participantDAO = ParticipantDAO.getInstance();
        try {
            participantDAO.add(person);
        } catch (DAOException e) {
            // TODO: TROW exception or LOG exception?
            log.error(e);
        }
    }

    public List<Person> getAllParticipants() throws ServiceException {
        List<Person> personList;
        try {
            personList = ParticipantDAO.getInstance().findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return personList;
    }
}
