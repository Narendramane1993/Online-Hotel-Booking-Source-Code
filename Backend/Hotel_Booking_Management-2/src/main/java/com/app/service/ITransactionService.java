package com.app.service;
import java.util.List;
import com.app.pojos.Transaction;

public interface ITransactionService {
	List<Transaction> getAllTransactionsby(String userEmail);
	Transaction transactionDetails(int userid, Transaction transaction);
	double generateRevenue();
}
