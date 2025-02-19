package dev.Ashutosh.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExpenseCreationReqDTO {

    private double amount;
    private String description;
    private Integer groupId;
    private List<Integer> paidBy;
    private List<Double> paidByAmounts;
    private List<Integer> owedBy;
    private List<Double>  owedByAmounts;

}

/*
        Expense -> Dinner || 500
        A-1 B-2 C-3
        paid By A 200 B 300
        owed By A 100 B 200 C 200

        {
            amount: 500,
            desc : "Dinner",
            groupId : 1,
            payouts : [ [1:200], [1:-100],
        }
     */
