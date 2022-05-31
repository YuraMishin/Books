package com.mishinyura.books.db;

import com.mishinyura.books.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class ConnectionManager.
 * Implements Connection Manager.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.03.2022
 */
@Slf4j
public final class ConnectionManager {
    /**
     * USERNAME.
     */
    private static final String USERNAME_KEY = "db.username";
    /**
     * PASSWORD.
     */
    private static final String PASSWORD_KEY = "db.password";
    /**
     * URL.
     */
    private static final String URL_KEY = "db.url";

    static {
        loadDriver();
    }

    /**
     * Constructor.
     */
    private ConnectionManager() {
    }

    /**
     * Method loads db driver.
     */
    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error(
                    "Exception caught while connecting to database: {}",
                    e.getMessage()
            );
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Method opens connection.
     *
     * @return Connection
     */
    public static Connection open() {
        try {
            Connection con = DriverManager
                    .getConnection(
                            PropertiesUtil.get(URL_KEY),
                            PropertiesUtil.get(USERNAME_KEY),
                            PropertiesUtil.get(PASSWORD_KEY));
            log.debug("Connection is opened");
            return con;
        } catch (SQLException e) {
            log.error(
                    "Exception caught while connecting to database: {}",
                    e.getMessage()
            );
            throw new RuntimeException(e.getMessage());
        }
    }
}
