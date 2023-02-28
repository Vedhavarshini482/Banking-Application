package com.bankingapplication.userlogin;

import com.bankingapplication.userlogin.UserModel.UserModelControllerCallBack;

public class UserController implements UserControllerCallBack,UserModelControllerCallBack {

	private UserModelCallBack model;
	private UserViewCallBack view;
	
	UserController(UserView view){
		this.view=view;
		model=new UserModel(this);
	}

	@Override
	public void displayAccount(String accountNumber) {
		model.displayAccount(accountNumber);
	}

	@Override
	public void isValid(String receiverAcc) {
		model.isValid(receiverAcc);
	}

	@Override
	public void inValidAccountNumber(String string) {
		view.inValidAccontNumber(string);
	}

	@Override
	public void validAccountNumber() {
		view.validAccountNumber();
	}

	@Override
	public void validAmount(String accountNumber, String amount) {
		model.validAmount(accountNumber,amount);
	}

	@Override
	public void transferMoney() {
		view.transferMoney();
	}

	@Override
	public void inSufficientBalance(String string) {
		view.inSufficientBalance(string);
	}

	@Override
	public void transactionDetails(String accountNumber, String receiverAcc, String amount, String strDate) {
		model.transactionDetails(accountNumber,receiverAcc,amount,strDate);
	}

	@Override
	public void failed(String string) {
		view.failed(string);
	}

	@Override
	public void success(String string) {
		view.success(string);
	}

	@Override
	public void inValidAmount(String string) {
		view.inValidAmount(string);
	}

	@Override
	public void addAmount(String amount,String accountNumber) {
		model.addAmount(amount,accountNumber);
	}

	@Override
	public void validAmountDebit(String accountNumber, String amount) {
		model.validAmountDebit(accountNumber,amount);
	}

	@Override
	public void exit() {
		model.exit();
	}

	@Override
	public void changePinNumber(String mobileNumber, String mPin) {
		model.changePinNumber(mobileNumber,mPin);
	}

	@Override
	public void showUserDetails(String[] userArray) {
		view.showUserDetails(userArray);
	}

	@Override
	public void captcha(String password, String string) {
		view.captcha(password,string);
	}

	@Override
	public void pinNumber(String accountNumber, String pinNumber) {
		model.pinNumber(accountNumber, pinNumber);
	}

	@Override
	public void validMobileNumber(String accountNumber, String mobileNumber, String mPin) {
		model.validMobileNumber(accountNumber,mobileNumber,mPin);
	}

	@Override
	public void inValidMobileNumber(String string) {
		view.invalidMobileNumber(string);
	}

	@Override
	public void setPin(String mobileNumber,String mPin) {
		view.setPin(mobileNumber,mPin);
	}
	
}