package test.ey.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserDto {

    private String name;
    private String email;
    private String password;
    private List<PhoneDto> phones;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime lastLogin;
    private String jwtToken;
    private boolean isActive;

    // Constructors, getters, and setters

    public UserDto() {
        // Default constructor
    }

    public UserDto(String name, String email, String password, List<PhoneDto> phones,
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

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
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

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}