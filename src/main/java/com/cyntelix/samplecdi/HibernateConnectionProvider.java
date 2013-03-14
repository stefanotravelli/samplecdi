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

import org.apache.deltaspike.jpa.impl.datasource.ConfigurableDataSource;
import org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provide a CDI configurable DataSource to the Hibernate JPA implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HibernateConnectionProvider extends InjectedDataSourceConnectionProvider {

    Logger logger = LoggerFactory.getLogger(HibernateConnectionProvider.class);

    public HibernateConnectionProvider() {
        logger.info("Instantiating configurable data source.");
        setDataSource(new ConfigurableDataSource());
    }

}
