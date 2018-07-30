package org.cap.model;

public class LoginTable {

	private int customerId;
	private String customerPwd;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	@Override
	public String toString() {
		return "LoginTable [customerId=" + customerId + ", customerPwd=" + customerPwd + "]";
	}
	public LoginTable(int customerId, String customerPwd) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
	}
	public LoginTable() {
	
	}
	
	
	
}
