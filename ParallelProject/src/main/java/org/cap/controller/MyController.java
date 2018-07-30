package org.cap.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.Transaction;
import org.cap.service.IAccountService;
import org.cap.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired
	private ILoginService loginService;
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/validateLogin")
	public String ValidateLogin(ModelMap map,@RequestParam("customerId") String customerId, @RequestParam("customerPwd") String userPwd,HttpSession session)
	{
		int custId=Integer.parseInt(customerId);
		if(loginService.validateLogin(custId,userPwd))
		{
			session.setAttribute("custId", custId);
			String custName=loginService.getCustomerName(custId);
			map.put("custName", custName);
		   return "mainForm";
		 }
		
			return "redirect:/";
		}
	

	@RequestMapping("/createAccount")
	public String showCreateAccountPage(ModelMap map) {
		map.put("accounts", new Account());
		return "createAccount";
	}


	@PostMapping("/saveAccount")
	public String saveAccountDetails(HttpSession session,@ModelAttribute("accounts") Account account)
	{
		account.setOpeningDate(new Date());
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		
		account.setCustomer(customer);
		
		account.setStatus("active");
	
		accountService.createAccount(account);
		
		return "redirect:createAccount";
	}
	
	@RequestMapping("/showBalance")
	public String showBalancePage(ModelMap map,HttpSession session) {
	
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		List<Account> accounts= accountService.getAccountWithBalance(custId);
		
		map.put("accounts", accounts);
		
		return "showBalance";
	}

	@RequestMapping("/depositWithdraw")
	public String showDepositWithdrawPage(ModelMap map,HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		List<Account> accounts= accountService.getAllAccounts(custId);
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
		Account account=accountService.findAccount(accNo);
		transaction1.setFromAccount(account);
		
		accountService.addTransaction(transaction1);
		
		return "redirect:depositWithdraw";
	}
	
	
	@PostMapping(value="/fundTransaction")
	public String fundTransaction(
			@ModelAttribute("transaction") Transaction transaction,
			HttpSession session) {
		
		Integer customerId=Integer.parseInt(session.getAttribute("custId").toString());
		
		Customer customer= loginService.findCustomer(customerId);
		
		transaction.setTransactionDate(new Date());
		transaction.setStatus("completed");
		transaction.setCustomer(customer);
		System.out.println(customer);
		long accNo1=transaction.getFromAccount().getAccountNo();
		long accNo2=transaction.getToAccount().getAccountNo();
		Account account1=accountService.findAccount(accNo1);
		
		Account account2=accountService.findAccount(accNo2);
		transaction.setFromAccount(account1);
	
		transaction.setToAccount(account2);
		accountService.fundTransaction(transaction);
		
		return "redirect:fundTransfer";
	}

	@RequestMapping("/fundTransfer")
	public String showFundTransferPage(ModelMap map,HttpSession session) {
		
		Integer custId= Integer.parseInt(session.getAttribute("custId").toString());
		
		List<Account> accounts= accountService.getAllAccounts(custId);
		map.put("accounts", accounts);
		map.put("transaction", new Transaction());
		
		
		return "fundTransfer";
	}
	
	


	@RequestMapping("/printTransaction")
	public String showPrintTransactionPage() {
		return "printTransaction";
	}


}
