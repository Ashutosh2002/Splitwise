package dev.Ashutosh.Splitwise.services;

import dev.Ashutosh.Splitwise.dto.ExpenseCreationReqDTO;
import dev.Ashutosh.Splitwise.dto.PayoutDTO;
import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.PayoutLedger;
import dev.Ashutosh.Splitwise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private PayoutLedgerService payoutLedgerService;

    public Expense createExpense(ExpenseCreationReqDTO expenseCreationReqDTO){
        Expense expense = new Expense();

        expense.setAmount(expenseCreationReqDTO.getAmount());
        expense.setDescription(expenseCreationReqDTO.getDescription());
        expense.setGroup(groupService.getGroupById(expenseCreationReqDTO.getGroupId()));
        List<PayoutLedger> payoutLedgers = new ArrayList<>();

        for (PayoutDTO payoutDTO : expenseCreationReqDTO.getPayoutDTOS()){
            PayoutLedger payoutLedger = new PayoutLedger();
            payoutLedger.setUser(userService.getUserById(payoutDTO.getUserId()));
            payoutLedger.setAmountPaid(payoutDTO.getPaidAmount());
            payoutLedger.setAmountOwed(payoutDTO.getOwedAmount());
            payoutLedger = payoutLedgerService.createPayoutLedger(payoutLedger);
            payoutLedgers.add(payoutLedger);
        }

        expense.setPayoutLedgers(payoutLedgers);
        return expenseRepository.save(expense);

    }
}
