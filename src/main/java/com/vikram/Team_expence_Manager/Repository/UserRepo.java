package com.vikram.Team_expence_Manager.Repository;

import com.vikram.Team_expence_Manager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User>  findByEmail(String Email);
}
