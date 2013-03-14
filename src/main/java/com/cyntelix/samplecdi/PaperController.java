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


import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Add a new paper.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Model
public class PaperController {

    @Inject
    PaperDao paperDao;
    private Paper instance = new Paper();

    public Paper getInstance() {
        return instance;
    }

    public void setInstance(Paper instance) {
        this.instance = instance;
    }

    public void insert() {
        paperDao.persist(instance);
        instance = new Paper();
    }
}
