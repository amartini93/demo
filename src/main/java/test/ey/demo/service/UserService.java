package test.ey.demo.service;

import test.ey.demo.dto.UserDto;
import test.ey.demo.exception.EmailAlreadyRegisteredException;
import test.ey.demo.model.User;

public interface UserService {
    User registerUser(UserDto userDto) throws EmailAlreadyRegisteredException;
}
