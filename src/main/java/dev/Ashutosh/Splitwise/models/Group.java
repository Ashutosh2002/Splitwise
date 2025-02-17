package dev.Ashutosh.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Group extends BaseModel{

    private String name;
    @ManyToMany
    private List<User> users;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<Transaction> transactions;
}
