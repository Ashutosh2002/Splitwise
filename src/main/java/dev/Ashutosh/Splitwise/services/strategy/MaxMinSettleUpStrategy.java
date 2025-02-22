package dev.Ashutosh.Splitwise.services.strategy;

import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.PayoutLedger;
import dev.Ashutosh.Splitwise.models.Transaction;
import dev.Ashutosh.Splitwise.models.User;

import java.util.HashMap;
import java.util.List;

public class MaxMinSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        HashMap<User,Double> totalOutStandingMap = new HashMap<>();
        for(Expense expense : expenses){
            for(PayoutLedger payoutLedger : expense.getPayoutLedgers()){
                User user = payoutLedger.getUser();
                if(totalOutStandingMap.containsKey(payoutLedger.getUser())){
                    double currentBalance = totalOutStandingMap.get(user);
                    currentBalance += payoutLedger.getAmountPaid() -payoutLedger.getAmountOwed();
                    totalOutStandingMap.put(user,currentBalance);
                } else {
                    totalOutStandingMap.put(user, payoutLedger.getAmountPaid() - payoutLedger.getAmountOwed());

                }
            }
        }
    }
}
