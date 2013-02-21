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
