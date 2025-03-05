package dev.Ashutosh.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel{

    public Transaction(){

    }

    public Transaction(double amount, List<User> parties, Group group) {
        this.amount = amount;
        this.parties = parties;
        this.group = group;
    }

    private double amount;
    @ManyToMany
    private List<User> parties;// [0-borrower]  [1-lendor] parties[0] will pay parties[1] amount
    @ManyToOne
    private Group group;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<User> getParties() {
        return parties;
    }

    public void setParties(List<User> parties) {
        this.parties = parties;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        String str = "Paid amount : " + amount + " by : " + parties.get(0).getUsername() + " to : " + parties.get(1).getUsername();
        return str;
    }
}
