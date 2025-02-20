package dev.Ashutosh.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayoutDTO {

    private Integer userId;
    private double paidAmount;
    private double owedAmount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(double owedAmount) {
        this.owedAmount = owedAmount;
    }
}
