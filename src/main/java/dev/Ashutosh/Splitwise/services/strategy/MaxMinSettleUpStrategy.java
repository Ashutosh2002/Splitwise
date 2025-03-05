package dev.Ashutosh.Splitwise.services.strategy;

import dev.Ashutosh.Splitwise.models.*;

import java.util.*;

public class MaxMinSettleUpStrategy implements SettleUpStrategy{

    @Override
    public List<Transaction> settleUp(Group group) {
        List<Expense> expenses = group.getExpenses();
        List<Transaction> transactions = new ArrayList<>();
//      ascending order -> smaller to bigger
        Comparator<UserAmount> minUserAmountComp = Comparator.comparingDouble(UserAmount::getAmount);
//      descending order -> bigger to smaller
        Comparator<UserAmount> maxUserAmountComp = Comparator.comparingDouble(UserAmount::getAmount).reversed();

        PriorityQueue<UserAmount> minHeap = new PriorityQueue<>(minUserAmountComp);
        PriorityQueue<UserAmount> maxHeap = new PriorityQueue<>(maxUserAmountComp);

        for(Map.Entry<User,Double> entry : getOutstandingBalances(expenses).entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            } else if(entry.getValue() > 0){
                maxHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            } else {
                System.out.println("User is already settled. username : " + entry.getKey().getUsername());
            }
        }

        while(!(maxHeap.isEmpty() || minHeap.isEmpty())){
            UserAmount maxLendor = maxHeap.remove();
            UserAmount maxBorrower = minHeap.remove();

            if(maxLendor.getAmount() > Math.abs(maxBorrower.getAmount())){
                Transaction transaction =
                        new Transaction(Math.abs(maxBorrower.getAmount()),List.of(maxBorrower.getUser(),maxLendor.getUser()),group);
                transactions.add(transaction);
                maxLendor.setAmount(maxLendor.getAmount() - Math.abs(maxBorrower.getAmount()));
                maxHeap.add(maxLendor);
            } else if(maxLendor.getAmount() < Math.abs(maxBorrower.getAmount())){
                Transaction transaction =
                        new Transaction(Math.abs(maxLendor.getAmount()),List.of(maxBorrower.getUser(),maxLendor.getUser()),group);
                transactions.add(transaction);
                maxBorrower.setAmount(maxLendor.getAmount() - Math.abs(maxBorrower.getAmount()));
                minHeap.add(maxLendor);
            } else {
                Transaction transaction =
                        new Transaction(Math.abs(maxLendor.getAmount()),List.of(maxBorrower.getUser(),maxLendor.getUser()),group);
                transactions.add(transaction);
            }
        }

        return transactions;
    }

    private HashMap<User,Double> getOutstandingBalances(List<Expense> expenses){
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
        return totalOutStandingMap;
    }

    private static class UserAmount{
        User user;
        Double amount;

        public UserAmount(User user , Double amount) {
            this.amount = amount;
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }
}
