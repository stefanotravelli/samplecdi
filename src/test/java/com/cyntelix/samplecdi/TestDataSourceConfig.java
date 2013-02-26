package com.cyntelix.samplecdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Specializes;

/**
 * Data Source configuration for the test environment.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Specializes
public class TestDataSourceConfig extends SampleDataSourceConfig {
    Logger logger = LoggerFactory.getLogger(TestDataSourceConfig.class);

    public String getConnectionClassName(String connectionId) {
        return "org.hsqldb.jdbc.JDBCDriver";
    }

    @Override
    public String getJndiResourceName(String connectionId) {
        return null;
    }

    public String getJdbcConnectionUrl(String connectionId) {
        logger.info("Test data source config");
        return "jdbc:hsqldb:mem:jamsession";
    }
}
