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
