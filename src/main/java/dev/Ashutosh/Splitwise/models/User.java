package dev.Ashutosh.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{

    private String username;
    private String password;
    private String email;
    @ManyToMany
    private List<Group> groups;
    @ManyToMany
    private List<Transaction> transactions;
    @ManyToMany
    private List<Expense> expenses;

}
