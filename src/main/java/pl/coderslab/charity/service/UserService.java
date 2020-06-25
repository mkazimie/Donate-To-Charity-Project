package pl.coderslab.charity.service;

import pl.coderslab.charity.domain.User;
import pl.coderslab.charity.domain.dto.UserDto;
import pl.coderslab.charity.exception.RecordAlreadyExistsException;

public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);

    void registerUser (UserDto userDto) throws RecordAlreadyExistsException;

}
