package com.bankingapplication.userlogin;

public interface UserViewCallBack {

	void inValidAccontNumber(String string);

	void inSufficientBalance(String string);

	void validAccountNumber();

	void transferMoney();

	void failed(String string);

	void success(String string);

	void inValidAmount(String string);

	void showUserDetails(String[] userArray);

	void captcha(String password, String string);

	void setPin(String mobileNumber, String mPin);

	void invalidMobileNumber(String string);

}