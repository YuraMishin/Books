package com.mishinyura.books.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * Interface Dao.
 * Declares DAO API.
 *
 * @param <K> key
 * @param <E> models
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
public interface Dao<K, E> {
    /**
     * Method saves models.
     *
     * @param entity Entity
     * @param conn   Connection
     * @return E
     */
    E save(E entity, Connection conn);

    /**
     * Method gets all models.
     *
     * @param conn Connection
     * @return List<Entity>
     */
    List<E> findAll(Connection conn);

    /**
     * Method finds models by id.
     *
     * @param id   Id
     * @param conn Connection
     * @return Optional<E>
     */
    Optional<E> findById(K id, Connection conn);

    /**
     * Method updates models.
     *
     * @param entity Entity
     * @param conn   Connection
     */
    void update(E entity, Connection conn);

    /**
     * Method deletes models by id.
     *
     * @param id   Id
     * @param conn Connection
     * @return boolean
     */
    boolean delete(K id, Connection conn);
}
