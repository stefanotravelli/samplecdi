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
