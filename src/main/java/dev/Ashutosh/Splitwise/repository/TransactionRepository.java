package dev.Ashutosh.Splitwise.repository;

import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
