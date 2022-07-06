package com.mishinyura.books.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class GeneralConfig.
 * Implements Generalal Configuration for Spring Application.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 06.07.2022
 */
@Configuration
public class GeneralConfig {
    /**
     * @return ModelMapper
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
