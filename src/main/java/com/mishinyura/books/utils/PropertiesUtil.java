package com.mishinyura.books.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class PropertiesUtil.
 * Implements access to jdbc properties.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.05.2022
 */
@Slf4j
public final class PropertiesUtil {
    /**
     * Properties.
     */
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    /**
     * Constructor.
     */
    private PropertiesUtil() {
    }

    /**
     * Method loads properties.
     */
    private static void loadProperties() {
        try (InputStream inStr = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream("jdbc.properties")) {
            PROPERTIES.load(inStr);
            log.debug("jdbc.properties is loaded");
        } catch (Exception e) {
            log.error(
                    "Exception caught while loading jdbc.properties: {}",
                    e.getMessage()
            );
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Method retrieves the value by key.
     *
     * @param key Key
     * @return Value
     */
    public static String get(final String key) {
        return PROPERTIES.getProperty(key);
    }
}
