package com.vikram.Team_expence_Manager.Service;

import com.vikram.Team_expence_Manager.Dto.ExpenseRequest;
import com.vikram.Team_expence_Manager.Entity.Event;
import com.vikram.Team_expence_Manager.Entity.Expense;

import java.util.List;

public interface ExpenseService {
    public Expense createExpense(ExpenseRequest request);
    List<Expense> getAllExpenses();
    public Expense getExpenseById(Long Id);
    public List<Expense> getExpenseByEvent(Long eventId);
    public Expense updateExpense (Long Id, ExpenseRequest request);
    public void deleteExpense(Long Id);
}
