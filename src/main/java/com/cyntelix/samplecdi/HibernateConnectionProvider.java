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
