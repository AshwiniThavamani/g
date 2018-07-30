package org.cap.service;

import org.cap.model.Customer;

public interface ILoginService {
	
	public boolean validateLogin(int customerId,String custPass);

	public String getCustomerName(int custId);
	public Customer findCustomer(int customerId) ;
}
