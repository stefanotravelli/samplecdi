package com.cyntelix.samplecdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

/**
 * Produce (and dispose) the entity manager factory.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class EntityManagerFactoryProducer {

    Logger logger = LoggerFactory.getLogger(EntityManagerProducer.class);


    @Inject
    JpaBootstrapper jpaBootstrapper;

    @Produces
    @ApplicationScoped
    @SampleCdi
    EntityManagerFactory createEntityManagerFactory() {
        return jpaBootstrapper.getEntityManagerFactory();
    }

    public void onApplicationStop(@Disposes @SampleCdi EntityManagerFactory entityManagerFactory) {

        entityManagerFactory.close();
    }

}
