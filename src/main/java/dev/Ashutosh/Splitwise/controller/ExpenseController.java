package dev.Ashutosh.Splitwise.controller;

import dev.Ashutosh.Splitwise.dto.ExpenseCreationReqDTO;
import dev.Ashutosh.Splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense")
    public ResponseEntity addExpense(@RequestBody ExpenseCreationReqDTO expenseCreationReqDTO){
        return ResponseEntity.ok(expenseService.createExpense(expenseCreationReqDTO));
    }
}
