package org.cap.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.cap.model.Account;
import org.cap.model.Transaction;



public interface AccountDao {
	
	public void createAccount(Account account);

	public List<Account> getAllAccounts(int customerId);
	
	public Map<Account, Double> getAmoutCrDe(String strQuery,int customerId);
	
	public void addTransaction(Transaction transaction1);
	
	public Account findAccount(long accountNo);
	
	public List<Transaction> getTransactions(Integer id);
	
	public void fundTransfer(Transaction transaction2);

	public Account getAccount(long accNo);

	public Account getAccount1(long accNo1);

	List<Account> getAllToAccounts(Integer customerId);



	
		
}
