package org.acme.db;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Developer
 */
@Entity
public class Developer extends PanacheEntity {

    @Column(unique = true)
    public String name;

    @Override
    public String toString() {
        return this.name;
    }
}
