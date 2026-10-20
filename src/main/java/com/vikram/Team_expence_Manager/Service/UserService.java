package com.vikram.Team_expence_Manager.Service;

import com.vikram.Team_expence_Manager.Dto.UserRequest;
import com.vikram.Team_expence_Manager.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequest request);
    List<User> getAllUsers();
    User getUserById(Long Id);
    void deleteUser(Long Id);
}
