package com.cyntelix.samplecdi;

import org.apache.deltaspike.jpa.impl.datasource.ConfigurableDataSource;
import org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider;

/**
 * Provide a CDI configurable DataSource to the Hibernate JPA implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HibernateConnectionProvider extends InjectedDataSourceConnectionProvider {

    public HibernateConnectionProvider() {
        setDataSource(new ConfigurableDataSource());
    }

}
