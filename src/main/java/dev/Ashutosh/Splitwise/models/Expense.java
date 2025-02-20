package dev.Ashutosh.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{


    private double amount;
    private String description;
    @ManyToOne
    private Group group;
    @OneToMany
    @JoinColumn(name = "expense_id")
    private List<PayoutLedger> payoutLedgers;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<PayoutLedger> getPayoutLedgers() {
        return payoutLedgers;
    }

    public void setPayoutLedgers(List<PayoutLedger> payoutLedgers) {
        this.payoutLedgers = payoutLedgers;
    }
}

/*
        Expense {
            id: 1,
            desc: "Dinner",
            total : 450,
            paidBy : [ 1:150, 3:250, 5:50]
            share : [1:150, 1:150, 1:150]
        }

        USER
        id  name
        1
        2
        3
        4
        5

        EXPENSE
        id  desc    total   groupId
        1   Dinner  450     1

        PAYOUT_LEDGER
        id  userId  amountPaid  amountOwed  expenseId
        1   1       150         150         1
        2   3       250         150         1
        3   5       50          150         1
        4   1       200         0           2

        Cardinality -> Expense PayoutLedger -> 1:M
                       User PayoutLedger -> 1:M
                       PayoutLedger -> 1 User 1
                       User 1 -> PayoutLedger M

 */