package com.cyntelix.samplecdi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A sample entity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Entity
public class Paper {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String surname) {
        this.author = surname;
    }
}
