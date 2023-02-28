package com.bankingapplication.accountmanagement;

import com.bankingapplication.dto.Admin;
import com.bankingapplication.dto.User;
import com.bankingapplication.respository.Repository;

public class AccountManagementModel implements AccountManagementModelCallBack {

	private AccountManagementModelControllerCallBack controller;

	AccountManagementModel(AccountManagementModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface AccountManagementModelControllerCallBack {
		void accountCreated(String string, String[] user);

		void validAdmin(String string);

		void invalidAdmin(String string);

		void validUser(String string);

		void invalidUser(String string);

		void validNumber(String string);

	}

	@Override
	public void generateAccountNumber(String name, int age, String mobileNumber, String address) {
		String[] user = Repository.getInstance().generateAccountNumber(name, age, mobileNumber, address);
		controller.accountCreated("Successfully your account has been created", user);
	}

	@Override
	public void validAdmin(String userName, String password) {
		Admin admin = Repository.getInstance().validAdmin(userName, password);
		if (admin != null)
			controller.validAdmin("\t\tHello " + admin.getUserName());
		else
			controller.invalidAdmin("\t\tInvalid login attempt");
	}

	@Override
	public void validLogin(String accountNumber, String mPin) {
		User user = Repository.getInstance().validUser(accountNumber, mPin);
		if (user != null)
			controller.validUser("\t\tHello " + user.getName());
		else
			controller.invalidUser("\t\tInvalid Login attempt");
	}

	@Override
	public void setPinNumber(String accountNumber, String pinNumber) {
		Repository.getInstance().setPinNumber(accountNumber, pinNumber);
		controller.validNumber("\t\tYour Pin number created successfully");
	}

	@Override
	public void setMPin(String accountNumber, String mPin) {
		Repository.getInstance().setMPin(accountNumber, mPin);
		controller.validNumber("\t\tYour M-Pin created successfully");
	}

	@Override
	public void exit() {
		Repository.getInstance().exit();
	}

}