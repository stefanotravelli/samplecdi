/*
 * This file is part of SampleCdi.
 *
 *     SampleCdi is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SampleCdi is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SampleCdi.  If not, see <http://www.gnu.org/licenses/>.
 */

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
