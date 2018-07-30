package org.cap.service;

import org.cap.dao.ILoginDao;
import org.cap.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginDao loginDao;
	@Override
	public boolean validateLogin(int customerId, String custPass) {
		// TODO Auto-generated method stub
		return loginDao.validateLogin(customerId, custPass);
	}
	@Override
	public String getCustomerName(int custId) {
		// TODO Auto-generated method stub
		return loginDao.getCustomerName(custId);
	}
	
	
	@Override
	public Customer findCustomer(int customerId) {
		
		return loginDao.findCustomer(customerId);
	}
	

}
