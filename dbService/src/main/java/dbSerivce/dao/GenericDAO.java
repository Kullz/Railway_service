package dbSerivce.dao;


import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T> {

    void save  (T entity);
    void merge (T entity);
    void delete(T entity);

    List<T> findMany(Query query);
    T       findOne (Query query);
}
