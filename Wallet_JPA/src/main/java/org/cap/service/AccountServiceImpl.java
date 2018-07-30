package org.cap.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.cap.dao.AccountDao;
import org.cap.model.Account;
import org.cap.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("acccountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;

	@Override
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.createAccount(account);
	}

	@Override
	public List<Account> getAllAccounts(int customerId) {
		// TODO Auto-generated method stub
		return accountDao.getAllAccounts(customerId);
		
	}
	
	@Override
	public List<Account> getAccountWithBalance(int custId){
		
		String str="from Transaction tx where tx.customer.customerId=:custId and tx.transactionType='debit'";
				Map<Account, Double> deMap = accountDao.getAmoutCrDe(str,custId);
		
			String str1="from Transaction tx where tx.customer.customerId=:custId and tx.transactionType='credit'";
			Map<Account, Double> crMap = accountDao.getAmoutCrDe(str1,custId);
				

			List<Account> accounts=getAllAccounts(custId);
					
			Iterator<Account> iterator= accounts.iterator();
			while(iterator.hasNext()) {
				Account account=iterator.next();
				double balance=0;
				double crAmt=0,deAmt=0;
				account.setUpdateBalance(0);
				
				if(crMap.get(account) ==null)
					crAmt=0;
				else
					crAmt=crMap.get(account);
				

				if( deMap.get(account) ==null)
					deAmt=0;
				else
					deAmt= deMap.get(account);
				
				
				
				balance=account.getOpeningBalance() +
						crAmt-deAmt;
				
				account.setUpdateBalance(balance);
				
			}
			
			
			return accounts;
			
			
	}

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		accountDao.addTransaction(transaction);
		
	}

	@Override
	public Account findAccount(long accountNo) {
		// TODO Auto-generated method stub
		return accountDao.findAccount(accountNo);
	}
	
	@Override
	public List<Transaction> getTransactions(Integer id) {
		// TODO Auto-generated method stub
		return accountDao.getTransactions(id);
	}


	@Override
	public void fundTransfer(Transaction transaction2) {
		// TODO Auto-generated method stub
		accountDao.fundTransfer(transaction2);
	}

	@Override
	public Account getAccount(long accNo) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(accNo);
	}

	@Override
	public Account getAccount1(long accNo1) {
		// TODO Auto-generated method stub
		return accountDao.getAccount1(accNo1);
	}

	@Override
	public List<Account> getAllToAccounts(Integer customerId) {
		// TODO Auto-generated method stub
		return accountDao.getAllToAccounts(customerId);
	}
	

	

}