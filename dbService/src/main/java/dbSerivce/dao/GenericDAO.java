package dbSerivce.dao;


import javax.persistence.Query;
import java.util.List;


public interface GenericDAO<T> {

    T    add   (T entity);
    void merge (T entity);
    void delete(T entity);

    List<T> findManyByType(String query);
    T       findOneByType (String query);
    T       findById      (long id);
}
