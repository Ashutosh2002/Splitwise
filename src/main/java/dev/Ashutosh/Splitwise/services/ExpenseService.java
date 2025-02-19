package dev.Ashutosh.Splitwise.services;

import dev.Ashutosh.Splitwise.dto.ExpenseCreationReqDTO;
import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.PayoutLedger;
import dev.Ashutosh.Splitwise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupService groupService;

    public Expense createExpense(ExpenseCreationReqDTO expenseCreationReqDTO){
        Expense expense = new Expense();

        expense.setAmount(expenseCreationReqDTO.getAmount());
        expense.setDescription(expenseCreationReqDTO.getDescription());
        expense.setGroup(groupService.getGroupById(expenseCreationReqDTO.getGroupId()));

    }
}
