package dev.Ashutosh.Splitwise.services.strategy;

import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.Group;
import dev.Ashutosh.Splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {

    List<Transaction> settleUp(Group group);

}
