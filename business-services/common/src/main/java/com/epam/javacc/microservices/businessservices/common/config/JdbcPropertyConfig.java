package com.epam.javacc.microservices.businessservices.common.config;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.JDBCConfigurationSource;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcPropertyConfig {
    @Autowired
    DataSource h2DataSource;

    @Bean
    public AbstractConfiguration addJdbcApplicationPropertiesSource() {
        PolledConfigurationSource source = new JDBCConfigurationSource(h2DataSource, "select distinct key, value from properties", "key", "value");
        return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
    }

}
