package com.epam.conference.dao;

import com.epam.conference.entity.Person;

public interface ParticipantDAO extends DAO<Person> {
    void registerParticipant();
    /*
    findUserByLogin
    findUserByEmail
     */
}
