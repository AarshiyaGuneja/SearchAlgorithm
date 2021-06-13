package search.algorithm.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "movies")
@EntityListeners(AuditingEntityListener.class)
public class NetflixTitles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "cast", nullable = false)
    private String cast;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "date_added", nullable = false)
    private String date_added;

    @Column(name = "release_year", nullable = false)
    private int release_year;

    @Column(name = "rating")
    private String rating;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "listed_in", nullable = false)
    private String listed_in;

    @Column(name = "description", nullable = false)
    private String description;

    public NetflixTitles() {}
    public NetflixTitles(int id, String type, String title, String director, String cast,
                         String country, String date_added, int release_year, String rating,
                         String duration, String listed_in, String description) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
        this.description = description;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets Type.
     *
     * @return the Type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets Type.
     *
     * @param type the Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets cast.
     *
     * @return the cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * Sets cast.
     *
     * @param cast
     */
    public void setCast(String cast) {
        this.cast = cast;
    }

}
