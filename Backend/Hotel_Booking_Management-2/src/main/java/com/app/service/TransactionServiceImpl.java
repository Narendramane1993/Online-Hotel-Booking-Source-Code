package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TransactionRepository;
import com.app.pojos.Transaction;
import com.app.pojos.User;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	TransactionRepository transRepo;
	
	@Autowired
	IUserService userService;

	@Override
	public Transaction transactionDetails(int userid, Transaction transaction) {
		User user = userService.findById(userid);
		transaction.setUser(user);
		return transRepo.save(transaction);
	}
	
	@Override
	public List<Transaction> getAllTransactionsby(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double generateRevenue() {
		List<Transaction> allTransactions = transRepo.findAll();
		double revenue = 0;
		for (Transaction transaction : allTransactions) {
			revenue = revenue + transaction.getAmount();
		}
		return revenue;
	}


}
