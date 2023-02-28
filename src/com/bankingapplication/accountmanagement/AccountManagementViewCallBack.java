package com.bankingapplication.accountmanagement;

public interface AccountManagementViewCallBack {

	void accountCreated(String string,String[] user);

	void validAdmin(String string);

	void invalidAdmin(String string);

	void validUser(String string);

	void invalidUser(String string);

	void validNumber(String string);
	
}