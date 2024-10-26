package services;

import DTO.UserDTO;

public interface AuthenticationService {
    void signUpUser(UserDTO user);
    boolean isEmailExist(String email);

}
