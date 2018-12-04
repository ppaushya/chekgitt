package org.cap.service;

import org.cap.exception.InsufficientbalanceException;
import org.cap.model.Account;
import org.cap.model.Customer;

public interface IAccountService {

	public Account createAccount(Customer customer,double balance) throws InsufficientbalanceException;
	
	public Account findAccount(int accountNo);
	
	public Account withdraw(int accountNo,double amount);

	public Account deposit(int accountNo, double amount);
}
