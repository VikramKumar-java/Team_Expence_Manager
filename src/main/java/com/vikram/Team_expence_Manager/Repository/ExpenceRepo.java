package com.vikram.Team_expence_Manager.Repository;

import com.vikram.Team_expence_Manager.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenceRepo extends JpaRepository<Expense , Long> {

    List<Expense> findByEventId(Long eventId);

}
