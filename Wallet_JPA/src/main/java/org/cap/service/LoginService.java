package org.cap.service;

import org.cap.model.Customer;

public interface LoginService {
	public boolean validateLogin(int customerId, String custPwd);
	public String getCustomerName(int customerId);
	public Customer findCustomer(int customerId) ;
}
