package com.vikram.Team_expence_Manager.ServiceImpl;

import com.vikram.Team_expence_Manager.Dto.ExpenseRequest;
import com.vikram.Team_expence_Manager.Entity.Event;
import com.vikram.Team_expence_Manager.Entity.Expense;
import com.vikram.Team_expence_Manager.Entity.User;
import com.vikram.Team_expence_Manager.Exceptions.ResourceNotFoundException;
import com.vikram.Team_expence_Manager.Repository.EventRepo;
import com.vikram.Team_expence_Manager.Repository.ExpenceRepo;
import com.vikram.Team_expence_Manager.Repository.UserRepo;
import com.vikram.Team_expence_Manager.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    ExpenceRepo expenceRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Expense createExpense(ExpenseRequest request) {
        Event event = eventRepo.findById(request.eventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event with Id" + request.eventId() + "not found"));
        User user = userRepo.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("user with id" + request.userId() + "not found"));
        Expense expense = new Expense();
        expense.setAmount(request.amount());
        expense.setCategory(request.category());
        expense.setDescription(request.description());
        expense.setEvent(event);
        expense.setExpenseDate(request.expenseDate());
        expense.setPaidBy(user);
        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenceRepo.findAll();
    }

    @Override
    public Expense getExpenseById(Long Id) {
        return expenceRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense with id" + Id + "not found"));
    }

    @Override
    public List<Expense> getExpenseByEvent(Long eventId) {
        if (!eventRepo.existsById(eventId)) {

            throw new ResourceNotFoundException(
                    "Event with ID " +
                            eventId +
                            " not found"
            );
        }

        return expenceRepo.findByEventId(eventId);

    }

    @Override
    public Expense updateExpense(Long Id, ExpenseRequest request) {
        Expense expense = getExpenseById(Id);

        Event event = eventRepo.findById(
                request.eventId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Event with ID " +
                                request.eventId() +
                                " not found"
                )
        );


        User user = userRepo.findById(
                request.userId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "User with ID " +
                                request.userId() +
                                " not found"
                )
        );


        expense.setDescription(request.description());
        expense.setAmount(request.amount());
        expense.setCategory(request.category());
        expense.setExpenseDate(request.expenseDate());
        expense.setEvent(event);
        expense.setPaidBy(user);


        return expenceRepo.save(expense);

    }

    @Override
    public void deleteExpense(Long Id) {
        Expense expense = getExpenseById(Id);

        expenceRepo.delete(expense);
    }
}
