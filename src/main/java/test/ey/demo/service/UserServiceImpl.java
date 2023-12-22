package test.ey.demo.service;

import java.time.LocalDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import test.ey.demo.dto.UserDto;
import test.ey.demo.exception.EmailAlreadyRegisteredException;
import test.ey.demo.model.User;
import test.ey.demo.repository.UserRepository;
import test.ey.demo.util.JwtKeyGenerator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) throws EmailAlreadyRegisteredException {
        // Check if the email is already registered
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EmailAlreadyRegisteredException("El correo ya está registrado");
        }

        // Validate email format
        // if (!isValidEmail(userDto.getEmail())) {
        //     throw new IllegalArgumentException("Invalid email format. Please provide a valid email address.");
        // }

        // Implement password validation logic (placeholder example)
        if (!isValidPassword(userDto.getPassword())) {
            throw new IllegalArgumentException("Invalid password format. Password must contain at least one uppercase letter, one lowercase letter, and at least two numbers.");
        }

        // Generate JWT token
        String jwtToken = generateJwtToken(userDto.getEmail());

        LocalDateTime currentTime = LocalDateTime.now();
        // Create a new User entity
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setCreatedDate(currentTime);
        newUser.setModifiedDate(currentTime);
        newUser.setLastLogin(currentTime);
        newUser.setToken(jwtToken);
        newUser.setActive(true);

        // Save the user to the database
        User savedUser = userRepository.save(newUser);

        // You can set additional fields or perform other actions here

        return savedUser;
    }

    // private boolean isValidEmail(String email) {
    //     // Simple email validation using regular expression
    //     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    //     return email.matches(emailRegex);
    // }

    private boolean isValidPassword(String password) {
        // Implement your password validation logic here
        return true; // Placeholder logic; replace with actual validation
    }

    private String generateJwtToken(String email) {
        // Set the expiration time for the token (e.g., 1 hour)
        long expirationMillis = System.currentTimeMillis() + 3600000; // 1 hour

        // Your secret key 
        SecretKey jwtSecretKey = JwtKeyGenerator.generateKey();

        // Build the JWT token
        String jwtToken = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(expirationMillis))
                .signWith(jwtSecretKey)
                .compact();

        return jwtToken;
    }
}
