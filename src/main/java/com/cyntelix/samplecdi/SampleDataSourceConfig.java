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
