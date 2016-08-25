package dbSerivce.dao;


import javax.persistence.Query;
import java.util.List;


public interface GenericDAO<T> {

    void add    (T entity);
    void update (T entity);
    void remove (T entity);

    List<T> findManyByQuery  (String query);
    T       findOneByQuery (String query);
}
