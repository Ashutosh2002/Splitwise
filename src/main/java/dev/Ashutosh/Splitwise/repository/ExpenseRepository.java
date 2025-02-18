package dev.Ashutosh.Splitwise.repository;

import dev.Ashutosh.Splitwise.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
