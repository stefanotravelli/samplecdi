package com.cyntelix.samplecdi;

import org.apache.deltaspike.jpa.api.datasource.DataSourceConfig;

import java.util.Properties;

/**
 * Configure the DataSource
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SampleDataSourceConfig implements DataSourceConfig {
    public String getConnectionClassName(String connectionId) {
        return null;
    }

    public String getJndiResourceName(String connectionId) {
        return "java:/comp/env/jdbc/samplecdi";
    }

    public Properties getConnectionProperties(String connectionId) {
        return null;
    }

    public String getJdbcConnectionUrl(String connectionId) {
        return null;
    }
}
