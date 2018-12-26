package com.epam.conference.service;

import com.epam.conference.dao.impl.ParticipantDAOImpl;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DAOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ParticipantService {
    public Person findParticipant(String login, String email, String password) {
        throw new UnsupportedOperationException();
    }

    // TODO:
    //  - implement basic functionality without validation
    //  - and without checking if the user already exist in database
    public void createParticipant(Person person) {
        // TODO: VALIDATION
        //      - Check if already exists in DB
        ParticipantDAOImpl participantDAO = ParticipantDAOImpl.getInstance();
        try {
            participantDAO.add(person);
        } catch (DAOException e) {
            // TODO: TROW exception or LOG exception?
            log.error(e);
        }
    }
}
