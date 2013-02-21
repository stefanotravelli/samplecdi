package com.cyntelix.samplecdi;

import javax.enterprise.inject.Specializes;
import java.util.Properties;

/**
 * Data Source configuration for the test environment.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Specializes
public class TestDataSourceConfig extends SampleDataSourceConfig {
    public String getConnectionClassName(String connectionId) {
        return "org.hsqldb.jdbc.JDBCDriver";
    }


    public String getJdbcConnectionUrl(String connectionId) {
        return "jdbc:hsqldb:mem:jamsession";
    }
}
