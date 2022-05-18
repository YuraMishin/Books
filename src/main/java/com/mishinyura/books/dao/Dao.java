package com.mishinyura.books.dao;

import java.sql.Connection;
import java.util.List;

/**
 * Interface Dao.
 * Declares DAO API.
 *
 * @param <K> key
 * @param <E> entity
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public interface Dao<K, E> {
    /**
     * Method saves entity.
     *
     * @param entity Entity
     * @param conn   Connection
     * @return E
     */
    E save(E entity, Connection conn);

    /**
     * Method gets all entities.
     *
     * @param conn Connection
     * @return List<Entity>
     */
    List<E> findAll(Connection conn);
}
