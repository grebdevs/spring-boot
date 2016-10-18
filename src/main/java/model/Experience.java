package model;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
public class Experience {

    private Long id;
    private String workPlace;
    private String role;
    private String responsibilities;
    private String duration;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
