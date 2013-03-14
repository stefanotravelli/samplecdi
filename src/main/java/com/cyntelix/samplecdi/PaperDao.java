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

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Person DAO utility.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Model
public class PaperDao {

    @Inject
    @SampleCdi
    EntityManager entityManager;

    public List<Paper> getAll() {
        return entityManager.createQuery("select p from Paper p order by p.title", Paper.class)
                .getResultList();
    }

    public void persist(Paper paper) {
        entityManager.persist(paper);
    }




}
