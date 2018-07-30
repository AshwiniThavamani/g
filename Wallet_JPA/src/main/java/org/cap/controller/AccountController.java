package org.cap.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.Transaction;
import org.cap.service.AccountService;
import org.cap.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private AccountService acccountService;
	
	/*@Autowired
	private TransactionService transactionService;*/

	@PostMapping("/validateLogin")
	public String validateLogin(ModelMap map, @RequestParam("customerId") String customerId,
			@RequestParam("customerPwd") String customerPwd, HttpSession session) {

		Integer custId = Integer.parseInt(customerId);

		if (loginService.validateLogin(custId, customerPwd)) {
			session.setAttribute("custId", custId);
			String custName = loginService.getCustomerName(custId);
			map.put("custName", custName);

			return "main";

		}

		return "redirect:/";
	}

	@RequestMapping("/createAccount")
	public String showCreateAccountPage(ModelMap map) {

		map.put("account", new Account());
		return "createAccount";
	}

	@PostMapping("/saveAccount")
	public String saveAccountDetails(HttpSession session,
			@ModelAttribute("account") Account account) {
		account.setOpeningDate(new Date());
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		account.setCustomer(customer);
		
		account.setStatus("active");
	
		acccountService.createAccount(account);
		
		return "redirect:createAccount";
	}
	

	@RequestMapping("/showBalance")
	public String showBalanceDetails(ModelMap map,
			HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		List<Account> accounts= acccountService.getAccountWithBalance(custId);
		
		map.put("accounts", accounts);
		
		return "showBalance";
	}

	
	@RequestMapping("/depositWithdraw")
	public String depositWithdrawOperatio(ModelMap map, HttpSession session) {
		

		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
	
		List<Account> accounts= acccountService.getAllAccounts(custId);
		map.put("accounts", accounts);
		map.put("transaction1", new Transaction());
		
		return "depositWithdraw";
	}
	
	
	@PostMapping(value="/addTransaction")
	public String addTransaction(
			@ModelAttribute("transaction1") Transaction transaction1,
			HttpSession session) {
		
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		
		transaction1.setTransactionDate(new Date());
		transaction1.setStatus("completed");
		transaction1.setCustomer(customer);
		
		long accNo=transaction1.getFromAccount().getAccountNo();
		Account account=acccountService.findAccount(accNo);
		transaction1.setFromAccount(account);
		
		acccountService.addTransaction(transaction1);
		
		return "redirect:depositWithdraw";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/transfer")
	public String fundTransfer(ModelMap map,HttpSession session,@ModelAttribute("transaction") Transaction transaction) {
		
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		 List<Account> accountNos=acccountService.getAllAccounts(customerId);
			 map.put("accNos",accountNos);
		 List<Account> toAccountNos=acccountService.getAllToAccounts(customerId);
		

		 map.put("toAccNos",toAccountNos);
		 map.put("transaction",new Transaction());
		
		return "transfer";
		
	}

	@RequestMapping("/ftransfer")
	public String fundTransferring(ModelMap map,HttpSession session,
			@ModelAttribute("transaction") Transaction transaction) {
		transaction.setTransactionDate(new Date());
		transaction.setStatus("Transaction successful");
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		
		transaction.setCustomer(customer);
		long accNo=transaction.getFromAccount().getAccountNo();
		long accNo1=transaction.getToAccount().getAccountNo();
		Account account=acccountService.getAccount(accNo);
		Account account1=acccountService.getAccount1(accNo1);
		transaction.setFromAccount(account);
		transaction.setToAccount(account1);
		transaction.setTransactionType("debit");
		Transaction transaction2=new Transaction();
		transaction2.setFromAccount(account1);
		transaction2.setTransactionType("credit");
	  

		acccountService.fundTransfer(transaction);
		acccountService.fundTransfer(transaction2);
		
		return "redirect:/transfer";
		
	}
	@RequestMapping("/tranSummary")
	public String showTransactionSummaryPage(ModelMap map,HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		List<Transaction> transaction= acccountService.getTransactions(custId);
		
		map.put("transactions", transaction);
		return "tranSummary";
	}
		@RequestMapping("/Logout")
		public String showLogoutPage(HttpSession session) {
			session.invalidate();
			return"redirect:/";
		}
	
}
