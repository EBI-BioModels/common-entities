package net.biomodels.jummp.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String userRealName;
    public String getUserRealName() {
        return userRealName;
    }
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    private String orcid;
    public String getOrcid() {
        return orcid;
    }
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    /*private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/
}