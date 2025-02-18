package dev.Ashutosh.Splitwise.repository;

import dev.Ashutosh.Splitwise.models.Expense;
import dev.Ashutosh.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
