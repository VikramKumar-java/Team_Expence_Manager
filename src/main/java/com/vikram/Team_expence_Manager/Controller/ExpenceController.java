package com.vikram.Team_expence_Manager.Controller;

import com.vikram.Team_expence_Manager.Dto.ExpenseRequest;
import com.vikram.Team_expence_Manager.Entity.Expense;
import com.vikram.Team_expence_Manager.Service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1")
public class ExpenceController {
    ExpenseService expenseService; {

        this.expenseService = expenseService;
    }


    @PostMapping
    public ResponseEntity<Expense> createExpense(
            @Valid @RequestBody ExpenseRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseService.createExpense(request));
    }


    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {

        return ResponseEntity.ok(
                expenseService.getAllExpenses()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                expenseService.getExpenseById(id)
        );
    }


    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Expense>> getExpensesByEvent(
            @PathVariable Long eventId) {

        return ResponseEntity.ok(
                expenseService.getExpenseByEvent(eventId)
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequest request) {

        return ResponseEntity.ok(
                expenseService.updateExpense(id, request)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long id) {

        expenseService.deleteExpense(id);

        return ResponseEntity.noContent().build();
    }
}


