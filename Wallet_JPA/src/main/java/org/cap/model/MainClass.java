package org.cap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		EntityManagerFactory factory=
				Persistence.createEntityManagerFactory("jpademo");
		EntityManager entityManager=factory.createEntityManager();
		
		EntityTransaction transaction= entityManager.getTransaction();
		
		transaction.begin();
		
		Customer customer=new Customer();
		customer.setCustomerPwd("tom123");
		customer.setFirstName("Tom");
		customer.setLastName("Jerry");
		customer.setLastLoginDate(new Date());
		
		Customer customer1=new Customer();
		customer1.setCustomerPwd("sush123");
		customer1.setFirstName("sush");
		customer1.setLastName("sh");
		customer1.setLastLoginDate(new Date());
		
		Account account=new Account();
		account.setAccountNo(567432432L);
		account.setAccountType("savings");
		//account.setOpeningBalance(2000);
		
	
		account.setCustomer(customer);
		
		Account accountrd=new Account();
		accountrd.setAccountNo(32432432234L);
		accountrd.setAccountType("rd");
		
		accountrd.setCustomer(customer);
		accountrd.setYears(3);
		
		Account account1=new Account();
		account1.setAccountNo(45635L);
		account1.setAccountType("current");
		//account.setOpeningBalance(5000);
		account1.setCustomer(customer);
		
		
		
		Transaction transaction2=new Transaction();
		transaction2.setCustomer(customer);
		transaction2.setFromAccount(account);
		transaction2.setAmount(1000);
		transaction2.setTransactionType("debit");
		transaction2.setTransactionDate(new Date());
		
		
		Transaction transaction3=new Transaction();
		transaction3.setCustomer(customer);
		transaction3.setFromAccount(account);
		transaction3.setToAccount(account1);
		transaction3.setAmount(1000);
		transaction3.setTransactionType("credit");
		transaction3.setTransactionDate(new Date());
		
		entityManager.persist(customer);
		entityManager.persist(customer1);
		entityManager.persist(account);
		entityManager.persist(account1);
		entityManager.persist(accountrd);

		entityManager.persist(transaction2);
		entityManager.persist(transaction3);
		transaction.commit();


	}

}
