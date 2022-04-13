package com.app.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
