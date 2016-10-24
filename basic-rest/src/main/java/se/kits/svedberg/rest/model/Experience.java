package se.kits.svedberg.rest.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */

@Entity
@Table(name = "Experiences")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "workplace", nullable = false)
    private String workplace;

    @Column(nullable = false)
    private String title;

    private String responsibilities;
    private String duration;

    protected Experience() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public Experience(Long id, String workplace, String title, String responsibilities, String duration) {
        setId(id);
        setWorkplace(workplace);
        setTitle(title);
        setResponsibilities(responsibilities);
        setDuration(duration);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
