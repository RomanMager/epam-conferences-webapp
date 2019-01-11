package com.epam.conference.dao;

import com.epam.conference.entity.Entity;
import com.epam.conference.exception.DaoException;

import java.util.List;

public interface Dao<T extends Entity> {
    void add(T entity) throws DaoException;

    void remove(T entity);

    void update(T entity);

    List<T> findAll() throws DaoException;
}
