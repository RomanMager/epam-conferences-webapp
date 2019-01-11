package com.epam.conference.dao;

import com.epam.conference.entity.Person;

public interface ParticipantDao extends Dao<Person> {
    void registerParticipant();
    /*
    findUserByLogin
    findUserByEmail
     */
}
