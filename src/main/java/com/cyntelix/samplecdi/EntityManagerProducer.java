package com.cyntelix.samplecdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;

/**
 * Produce (and dispose) the JPA entity manager
 *
 * @author Stefano Travelli (Cyntelix)
 */

public class EntityManagerProducer {

    Logger logger = LoggerFactory.getLogger(EntityManagerProducer.class);

    @Inject
    @SampleCdi
    EntityManagerFactory entityManagerFactory;

    @Produces
    @SampleCdi
    @RequestScoped
    public EntityManager createEntityManager() {
        logger.debug("Creating entity manager.");
        return entityManagerFactory.createEntityManager();
    }

    public void onRequestEnd(@Disposes @SampleCdi EntityManager entityManager) {
        logger.debug("Disposing entity manager");
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
