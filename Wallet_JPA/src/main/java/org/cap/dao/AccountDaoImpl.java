package org.cap.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")

public class AccountDaoImpl implements AccountDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void createAccount(Account account) {
		
		Query query= entityManager.createQuery("select max(accountNo) from Account");
		
		List<Long> max= query.getResultList();
		
		account.setAccountNo(max.get(0)+1);
	
		entityManager.persist(account);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllAccounts(int customerId) {
		
		Query query= entityManager
			.createQuery("from Account acc where acc.customer.customerId=:custId");
		
		query.setParameter("custId", customerId);
		
		
		List<Account> accounts= query.getResultList();
		
		
		return accounts;
	}
	
	
	
	
	@Transactional(readOnly=true)
	public Map<Account, Double> getAmoutCrDe(String strQuery,int customerId){
	
		
		Query query2=entityManager
				.createQuery(strQuery);
		
		query2.setParameter("custId", customerId);
		
		List<Transaction> transactions=query2.getResultList();
		Map<Account, Double> map=
		transactions.stream()
				.collect(
				Collectors.groupingBy(Transaction::getFromAccount,
					Collectors.summingDouble(Transaction::getAmount))
				);
		return map;
	}
	
	@Transactional
	public void addTransaction(Transaction transaction1) {
		System.out.println("Transaction complete............");
		entityManager.persist(transaction1);
		
	}

	@Override
	public Account findAccount(long accountNo) {
		Query query= entityManager.createQuery("from Account where accountNo=:accno");
		query.setParameter("accno", accountNo);
		List<Account> accounts= query.getResultList();
		return accounts.get(0);
	}
	

	@Override
	public List<Transaction> getTransactions(Integer id) {
		// TODO Auto-generated method stub
		
		Query query= entityManager.createQuery("from Transaction tx where tx.customer.customerId=:cust");// between tx.transactionDate=:date1 and tx.transactionDate=:date2");
		query.setParameter("cust", id);
				List <Transaction> transaction= query.getResultList();
		for (Transaction transaction2 : transaction) {
			System.out.println(transaction2);
		}
		
		return transaction;
	}
	
	
	@Transactional
	@Override
	public Account getAccount(long accountNo) {
		Query query= entityManager.createQuery("from Account where accountNo=:accno");
		query.setParameter("accno", accountNo);
		List<Account> accounts= query.getResultList();
		return accounts.get(0);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllToAccounts(Integer customerId) {
		Query query=entityManager.createQuery("from Account acc where acc.customer.customerId!=:custId");
		query.setParameter("custId", customerId);
		
		List<Account> accounts=query.getResultList();
		
		return accounts;
		
	}

	@Override
	@Transactional
	public void fundTransfer(Transaction transaction) {
		
	    
		entityManager.persist(transaction);
		
		
	}

	@Override
	@Transactional
	public Account getAccount1(long accNo1) {
		Query query= entityManager.createQuery("from Account where accountNo=:accno");
		query.setParameter("accno", accNo1);
		List<Account> accounts= query.getResultList();
		return accounts.get(0);
	}



	
	
	



}
