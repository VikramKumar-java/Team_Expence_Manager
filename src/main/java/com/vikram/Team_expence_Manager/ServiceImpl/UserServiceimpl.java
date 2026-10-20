package com.vikram.Team_expence_Manager.ServiceImpl;

import com.vikram.Team_expence_Manager.Dto.UserRequest;
import com.vikram.Team_expence_Manager.Entity.User;
import com.vikram.Team_expence_Manager.Exceptions.BadRequestException;
import com.vikram.Team_expence_Manager.Exceptions.ResourceNotFoundException;
import com.vikram.Team_expence_Manager.Repository.UserRepo;
import com.vikram.Team_expence_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserRepo userRepo ;
    @Override
    public User createUser(UserRequest request) {
        if(userRepo.findByEmail(request.email()).isPresent()){
            throw new BadRequestException("email already exist"+request.email());
        }
        User user = new User();
        user.setEmail(request.email());
        user.setName(request.name());

        return userRepo.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long Id) {
        return userRepo.findById(Id)
                .orElseThrow(()->new ResourceNotFoundException("user with "+Id+"not found"));
    }

    @Override
    public void deleteUser(Long Id) {
        User user = getUserById(Id);
        userRepo.delete(user);

    }
}
