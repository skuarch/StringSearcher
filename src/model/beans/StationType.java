package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "station_type")
public class StationType implements Serializable {

    @Id
    @Column(name = "station_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "station_type_name", nullable = false)
    private String name = null;

    //==========================================================================
    public StationType() {
    } // end Contry

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }
} // end class