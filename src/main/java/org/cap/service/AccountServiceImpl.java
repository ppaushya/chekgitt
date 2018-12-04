package org.cap.service;

import org.cap.dao.IAccountDao;
import org.cap.exception.InsufficientbalanceException;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService{
	
	
	private IAccountDao accountDao;
	
	
	

	public AccountServiceImpl(IAccountDao accountDao2) {
		this.accountDao=accountDao2;
	}




	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}




	@Override
	public Account createAccount(Customer customer, double balance) throws InsufficientbalanceException {
		
		if(customer==null)
			throw new IllegalArgumentException("Sorry! Invalid Customer");
		if(balance<500)
			throw new InsufficientbalanceException("Insufficient Opening Balance");
		
		Account account=new Account();
		account.setAccountNo(AccountUtil.generateAccountno());
		account.setCustomer(customer);
		account.setOpeningBalance(balance);
		
		if(accountDao.createAccount(account))
			return account;
		
		return null;
	}




	@Override
	public Account findAccount(int accountNo) {
		
		return accountDao.findAccount(accountNo);
	}




	@Override
	public Account withdraw(int accountNo, double amount) {
		
		Account account=accountDao.findAccount(accountNo);
		
		if(account!=null) {
			if(account.getOpeningBalance()>amount) {
				double balance=account.getOpeningBalance()-amount;
				account.setOpeningBalance(balance);
				return account;
			}
		}
		
		return null;
	}




	@Override
	public Account deposit(int accountNo, double amount) {
		Account account=accountDao.findAccount(accountNo);
		
		if(account!=null) {
			
				double balance=account.getOpeningBalance()+amount;
				account.setOpeningBalance(balance);
				return account;
			
		}
		
		return null;
	}

}
