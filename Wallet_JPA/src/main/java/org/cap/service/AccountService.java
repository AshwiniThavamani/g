package org.cap.service;

import java.util.Date;
import java.util.List;

import org.cap.model.Account;
import org.cap.model.Transaction;


public interface AccountService {
	
	public void createAccount(Account account);

	public List<Account> getAllAccounts(int customerId);
	
	public List<Account> getAccountWithBalance(int custId);	
	
	public void addTransaction(Transaction transaction);

	public Account findAccount(long accountNo);
	
	public List<Transaction> getTransactions(Integer id);

	public void fundTransfer(Transaction transaction2);

	public Account getAccount(long accNo);

	public Account getAccount1(long accNo1);

	public List<Account> getAllToAccounts(Integer customerId);

	
	

}
