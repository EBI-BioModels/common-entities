package net.biomodels.jummp.entities.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "user")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "CREATED_ON")
    private Date createdAt;

    @Column(name = "UPDATED_ON")
    private Date updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
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

    // custom additions
    /**
     * The code with which a new user can validate the registration
     */
    String registrationCode;
    /**
     * The date when the registration code becomes invalid.
     */
    Date registrationInvalidation;
    /**
     * The code with which a user can reset a password
     */
    String passwordForgottenCode;
    /**
     * The date when the password forgotten code becomes invalid.
     */
    Date passwordForgottenInvalidation;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))

    private List<Authority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
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
    }
}
