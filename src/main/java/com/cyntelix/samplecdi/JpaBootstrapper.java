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
