package org.jarvis.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

/**
 * @author tennyson
 * @date 2020/8/8-23:06
 */
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        return null;
    }
}
