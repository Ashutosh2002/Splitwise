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

    private double amount;
    @ManyToMany
    private List<User> parties;// [0-borrower]  [1-lendor] parties[0] will pay parties[1] amount
    @ManyToOne
    private Group group;

}
