package org.cap.dao;

import java.util.List;
import java.util.Map;

import org.cap.model.Account;
import org.cap.model.Transaction;

public interface IAccountDao {

	public void createAccount(Account account);
	public List<Account> getAllAccounts(int customerId);
	public Map<Account, Double> getAmoutCrDe(String strQuery,int customerId);
	public void addTransaction(Transaction transaction1);
	public Account findAccount(long accountNo);
	public void fundTransaction(Transaction transaction1);	

}
