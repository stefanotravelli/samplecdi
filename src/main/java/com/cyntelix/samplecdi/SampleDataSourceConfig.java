package com.cyntelix.samplecdi;

import org.apache.deltaspike.jpa.api.datasource.DataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Configure the DataSource
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SampleDataSourceConfig implements DataSourceConfig {
    Logger logger = LoggerFactory.getLogger(SampleDataSourceConfig.class);

    public String getConnectionClassName(String connectionId) {
        return null;
    }

    public String getJndiResourceName(String connectionId) {
        logger.info("Sample data source config");
        return "java:/comp/env/jdbc/samplecdi";
    }

    public Properties getConnectionProperties(String connectionId) {
        return null;
    }

    public String getJdbcConnectionUrl(String connectionId) {
        return null;
    }
}
