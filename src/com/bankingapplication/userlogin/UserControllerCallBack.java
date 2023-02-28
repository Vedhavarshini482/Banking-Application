package com.bankingapplication.userlogin;

public interface UserControllerCallBack {

	void displayAccount(String accountNumber);

	void isValid(String receiverAcc);

	void validAmount(String accountNumber, String amount);

	void validAccountNumber();

	void transferMoney();

	void transactionDetails(String accountNumber, String receiverAcc, String amount, String strDate);

	void addAmount(String amount,String accountNumber);

	void validAmountDebit(String accountNumber, String amount);

	void exit();

	void changePinNumber(String mobileNumber, String mPin);

	void pinNumber(String accountNumber, String pinNumber);

	void validMobileNumber(String accountNumber, String mobileNumber, String mPin);

}