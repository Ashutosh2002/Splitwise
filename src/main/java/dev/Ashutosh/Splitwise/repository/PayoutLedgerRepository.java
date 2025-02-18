package dev.Ashutosh.Splitwise.repository;

import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.PayoutLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayoutLedgerRepository extends JpaRepository<PayoutLedger,Integer> {
}
