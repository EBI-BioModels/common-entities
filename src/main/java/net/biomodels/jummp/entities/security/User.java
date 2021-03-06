package net.biomodels.jummp.entities.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*@Column(name = "created_on")
    private Date createdAt;
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_on")
    private Date updatedAt;
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;*/

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;
    public boolean getEnabled() {
        return this.enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean accountExpired = false;
    public boolean getAccountExpired() {
        return accountExpired;
    }
    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    private boolean accountLocked = false;
    public boolean getAccountLocked() {
        return accountLocked;
    }
    public void setAccountLocked(final boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    private boolean passwordExpired = false;
    public boolean getPasswordExpired() {
        return passwordExpired;
    }
    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    /**
     * The code with which a new user can validate the registration
     */
    private String registrationCode;
    public String getRegistrationCode() {
        return registrationCode;
    }
    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }
    /**
     * The date when the registration code becomes invalid.
     */
    private Date registrationInvalidation;
    public Date getRegistrationInvalidation() {
        return registrationInvalidation;
    }
    public void setRegistrationInvalidation(Date registrationInvalidation) {
        this.registrationInvalidation = registrationInvalidation;
    }

    /**
     * The code with which a user can reset a password
     */
    private String passwordForgottenCode;
    public String getPasswordForgottenCode() {
        return passwordForgottenCode;
    }
    public void setPasswordForgottenCode(String passwordForgottenCode) {
        this.passwordForgottenCode = passwordForgottenCode;
    }
    /**
     * The date when the password forgotten code becomes invalid.
     */
    private Date passwordForgottenInvalidation;
    public Date getPasswordForgottenInvalidation() {
        return passwordForgottenInvalidation;
    }
    public void setPasswordForgottenInvalidation(Date passwordForgottenInvalidation) {
        this.passwordForgottenInvalidation = passwordForgottenInvalidation;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Column(nullable = false)
    private Set<Role> authorities = new HashSet<>();
    public Set<Role> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /*@Override
    public boolean isAccountNonExpired() {
        return !this.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.getAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.getAccountExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }*/
}
