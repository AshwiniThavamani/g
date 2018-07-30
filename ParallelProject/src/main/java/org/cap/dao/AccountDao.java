package org.cap.dao;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.cap.model.Account;
import org.cap.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class AccountDao implements IAccountDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	@Transactional
	public void createAccount(Account account) {
		
		Query query= entityManager.createQuery("select max(accountNo) from Account");
		System.out.println(query);
		
		List<Long> max= query.getResultList();
		
		account.setAccountNo(max.get(0)+1);
		
		System.out.println(account);
		
		entityManager.persist(account);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllAccounts(int customerId) {
		
		Query query= entityManager.createQuery("from Account acc where acc.customer.customerId=:custId");
		
		query.setParameter("custId", customerId);
		List<Account> accounts= query.getResultList();
		return accounts;
	}

	
	@Transactional(readOnly=true)
	public Map<Account, Double> getAmoutCrDe(String strQuery,int customerId){
		Query query2=entityManager.createQuery(strQuery);
		
		query2.setParameter("custId", customerId);
		List<Transaction> transactions=query2.getResultList();
		Map<Account, Double> map=transactions.stream().collect(Collectors.groupingBy(Transaction::getFromAccount,Collectors.summingDouble(Transaction::getAmount)));
		return map;
	}

	@Transactional
	public void addTransaction(Transaction transaction1) {
		System.out.println("Transaction complete............");
		System.out.println(transaction1);
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
	public void fundTransaction(Transaction transaction1) {
		// TODO Auto-generated method stub
		System.out.println("Transaction complete............");
		entityManager.persist(transaction1);
	}
	
	
	
	
}
 