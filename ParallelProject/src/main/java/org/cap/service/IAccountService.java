package org.cap.service;

import java.util.List;

import org.cap.model.Account;
import org.cap.model.Transaction;

public interface IAccountService {

	public void createAccount(Account account);
	public List<Account> getAllAccounts(int customerId);
	public List<Account> getAccountWithBalance(int custId);		
	public void addTransaction(Transaction transaction) ;
	public Account findAccount(long accountNo);
	public void fundTransaction(Transaction transaction1);	
	
}
