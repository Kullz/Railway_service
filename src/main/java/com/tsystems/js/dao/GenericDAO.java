package com.tsystems.js.dao;


import javax.persistence.Query;
import java.util.List;


public interface GenericDAO<T> {

    void add    (T entity);
    void update (T entity);
    void remove (T entity);

    <K> List<K> findManyByQuery  (String query);
    <K> K      findOneByQuery (String query);
}
