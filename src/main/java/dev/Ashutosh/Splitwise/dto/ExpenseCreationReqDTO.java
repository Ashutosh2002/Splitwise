package dev.Ashutosh.Splitwise.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class ExpenseCreationReqDTO {

    private double amount;
    private String description;
    private Integer groupId;
    private List<PayoutDTO> payoutDTOS;

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public List<PayoutDTO> getPayoutDTOS() {
        return payoutDTOS;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setPayoutDTOS(List<PayoutDTO> payoutDTOS) {
        this.payoutDTOS = payoutDTOS;
    }
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
