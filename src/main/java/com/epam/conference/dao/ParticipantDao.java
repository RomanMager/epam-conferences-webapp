package com.epam.conference.dao;

import com.epam.conference.entity.ParticipantData;
import com.epam.conference.entity.Person;
import com.epam.conference.exception.DaoException;

public interface ParticipantDao extends Dao<Person> {
    void registerParticipant(Person person, ParticipantData data) throws DaoException;

    Person findParticipantByLoginPassword(String login, String password) throws DaoException;
}
