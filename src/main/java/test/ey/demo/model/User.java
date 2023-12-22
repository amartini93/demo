package test.ey.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_phones", joinColumns = @JoinColumn(name = "user_id"))
    private List<Phone> phones;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime lastLogin;
    private String jwtToken;
    private boolean isActive;

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public User(String name, String email, String password, List<Phone> phones,
                LocalDateTime createdDate, LocalDateTime modifiedDate,
                LocalDateTime lastLogin, String jwtToken, boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.lastLogin = lastLogin;
        this.jwtToken = jwtToken;
        this.isActive = isActive;
    }

    // Getters and setters for other fields...

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
