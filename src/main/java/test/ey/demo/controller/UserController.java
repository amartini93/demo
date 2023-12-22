package test.ey.demo.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.ey.demo.dto.UserDto;
import test.ey.demo.exception.EmailAlreadyRegisteredException;
import test.ey.demo.model.User;
import test.ey.demo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registro")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto) {
        try {
            String email = userDto.getEmail();

            // Print email to console
            System.out.println(email);

            // Validate email format
            // if (!isValidEmail(email)) {
            //     return ResponseEntity
            //             .badRequest()
            //             .body(Map.of("mensaje", "Invalid email format. Please provide a valid email address."));
            // }

            // Set createdDate, modifiedDate, and lastLogin to current time
            LocalDateTime currentTime = LocalDateTime.now();
            userDto.setCreatedDate(currentTime);
            userDto.setModifiedDate(currentTime);
            userDto.setLastLogin(currentTime);
            userDto.setActive(true);

            // Continue with user registration
            User registeredUser = userService.registerUser(userDto);

            // Build the response map with user data
            Map<String, Object> userResponse = Map.of(
                    "id", registeredUser.getId(),
                    "name", registeredUser.getName(),
                    "email", registeredUser.getEmail(),
                    "created", registeredUser.getCreatedDate(),
                    "modified", registeredUser.getModifiedDate(),
                    "last_login", registeredUser.getLastLogin(),
                    "token", registeredUser.getJwtToken(),
                    "isactive", registeredUser.isActive()
            );

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userResponse);
        } catch (EmailAlreadyRegisteredException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensaje", "Email already registered."));
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("mensaje", "Internal Server Error"));
        }
    }

    // private boolean isValidEmail(String email) {
    //     // Simple email validation using regular expression
    //     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    //     return email.matches(emailRegex);
    // }
}
