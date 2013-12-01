package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "station")
@NamedQueries({
    @NamedQuery(name = "getStations", query = "from Station s where s.active = 1"),
    @NamedQuery(name = "getStationByName", query = "from Station s where s.name = :name")
})
public class Station implements Serializable {

    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "station_name")
    private String name = null;
    @Column(name = "station_url_streaming")
    private String urlStreaming = null;
    @Column(name = "station_website")
    private String website = null;
    @Column(name = "station_keywords")
    private String keywords = null;
    @OneToOne
    @JoinColumn(name = "station_genre_id")
    private Genre genre = null;
    @Column(name = "station_description")
    private String description = null;
    @OneToOne
    @JoinColumn(name = "station_language_id")
    private Language language = null;
    @Column(name = "station_frecuencie")
    private String frecuencie = null;
    @Column(name = "station_active")
    private boolean active = false;
    @OneToOne
    @JoinColumn(name = "station_contry_id")
    private Contry contry = null;
    @OneToOne
    @JoinColumn(name = "station_type_id")
    private StationType type = null;
    @Column(name = "station_clicks")
    private int clicks = 0;
    @Column(name = "station_modulating")
    private String modulating = null;

    //==========================================================================
    /**
     * create a instance.
     */
    public Station() {
    } // end Station

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getFrecuencie() {
        return frecuencie;
    }

    public void setFrecuencie(String frecuencie) {
        this.frecuencie = frecuencie;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Contry getContry() {
        return contry;
    }

    public void setContry(Contry contry) {
        this.contry = contry;
    }

    public StationType getType() {
        return type;
    }

    public void setType(StationType type) {
        this.type = type;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getModulating() {
        return modulating;
    }

    public void setModulating(String modulating) {
        this.modulating = modulating;
    }

    public String getUrlStreaming() {
        return urlStreaming;
    }

    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }

    @Override
    public String toString() {
        return "id=" + id + " name=" + name + " urlStreaming=" + urlStreaming + " description= " + description + " keywords=" + keywords + " website=" + website + " frecuencie" + frecuencie + " modulationg" + modulating + " active=" + active + " clicks=" + clicks + " contry=" + contry + " genre=" + genre;
    }
} // end class