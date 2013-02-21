package com.cyntelix.samplecdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Extension;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A CDI extension that bootstraps the JPA entity manager factory in a non-JSR316 servlet environment (i.e. Tomcat/Jetty)
 *
 * @author Stefano Travelli (Cyntelix)
 */
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
public class JpaBootstrapper implements Extension {

    Logger logger = LoggerFactory.getLogger(JpaBootstrapper.class);

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }


    protected void startUp(@Observes AfterDeploymentValidation event) {
        logger.info("Starting up JPA");
        entityManagerFactory = Persistence.createEntityManagerFactory("samplePu");
    }

}
