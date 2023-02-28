package com.bankingapplication.accountmanagement;

import com.bankingapplication.accountmanagement.AccountManagementModel.AccountManagementModelControllerCallBack;

public class AccountManagementController
		implements AccountManagementControllerCallBack, AccountManagementModelControllerCallBack {

	AccountManagementViewCallBack view;
	AccountManagementModelCallBack model;

	AccountManagementController(AccountManagementView view) {
		this.view = view;
		model = new AccountManagementModel(this);
	}

	@Override
	public void generateAccountNumber(String name, int age, String mobileNumber, String address) {
		model.generateAccountNumber(name, age, mobileNumber, address);
	}

	@Override
	public void validAdmin(String userName, String password) {
		model.validAdmin(userName, password);
	}

	@Override
	public void accountCreated(String string, String[] user) {
		view.accountCreated(string, user);
	}

	@Override
	public void validAdmin(String string) {
		view.validAdmin(string);
	}

	@Override
	public void invalidAdmin(String string) {
		view.invalidAdmin(string);
	}

	@Override
	public void validLogin(String accountNumber, String mPin) {
		model.validLogin(accountNumber, mPin);
	}

	@Override
	public void validUser(String string) {
		view.validUser(string);
	}

	@Override
	public void invalidUser(String string) {
		view.invalidUser(string);
	}

	@Override
	public void setPinNumber(String accountNumber,String pinNumber) {
		model.setPinNumber(accountNumber,pinNumber);
	}

	@Override
	public void setMPin(String accountNumber, String mPin) {
		model.setMPin(accountNumber,mPin);
	}

	@Override
	public void validNumber(String string) {
		view.validNumber(string);
	}

	@Override
	public void exit() {
		model.exit();
	}

}