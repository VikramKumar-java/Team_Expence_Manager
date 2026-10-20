package com.vikram.Team_expence_Manager.Repository;

import com.vikram.Team_expence_Manager.Entity.Event;
import com.vikram.Team_expence_Manager.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
//   List<Expense> findByEventId(Long eventId);
}
