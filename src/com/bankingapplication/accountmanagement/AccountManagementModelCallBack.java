package com.bankingapplication.accountmanagement;

public interface AccountManagementModelCallBack {

	void generateAccountNumber(String name, int age, String mobileNumber, String address);

	void validAdmin(String userName, String password);

	void validLogin(String accountNumber, String mPin);

	void setPinNumber(String accountNumber, String pinNumber);

	void setMPin(String accountNumber, String mPin);

	void exit();

}