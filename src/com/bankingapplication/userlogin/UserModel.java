package com.bankingapplication.userlogin;

import com.bankingapplication.respository.Repository;

public class UserModel implements UserModelCallBack {

	private UserModelControllerCallBack controller;

	UserModel(UserModelControllerCallBack controller) {
		this.controller = controller;
	}

	interface UserModelControllerCallBack {

		void inValidAccountNumber(String string);

		void validAccountNumber();

		void transferMoney();

		void inSufficientBalance(String string);

		void failed(String string);

		void success(String string);

		void inValidAmount(String string);

		void showUserDetails(String[] userArray);

		void captcha(String password, String string);

		void inValidMobileNumber(String string);

		void setPin(String mobileNumber, String mPin);

	}

	@Override
	public void displayAccount(String accountNumber) {
		String userArray[] = Repository.getInstance().displayAccount(accountNumber);
		controller.showUserDetails(userArray);
	}

	@Override
	public void isValid(String receiverAcc) {
		if (!Repository.getInstance().isValid(receiverAcc))
			controller.inValidAccountNumber(
					"You entered an invalid account number..Do you want to exit enter 0 or otherwise enter 1");
		else
			controller.validAccountNumber();
	}

	public void validAmount(String accountNumber, String amount) {
		if (amount.isEmpty() || amount.equals("0"))
			controller.inValidAmount("Please enter valid amount..Do you want to exit enter 0 or otherwise enter 1");
		else {
			String balance = Repository.getInstance().validAmount(accountNumber);
			if (Double.parseDouble(balance) >= Double.parseDouble(amount))
				controller.transferMoney();
			else
				controller.inSufficientBalance(
						"You have insufficient balance..Do you want to exit enter 0 or otherwise enter 1");
		}
	}

	@Override
	public void transactionDetails(String accountNumber, String receiverAcc, String amount, String strDate) {
		if (Repository.getInstance().transactionDetails(accountNumber, receiverAcc, amount, strDate))
			controller.success("Amount transfered successfully:)");
		else
			controller.failed("Oop's something went wrong..Try later");
	}

	@Override
	public void addAmount(String amount, String accountNumber) {
		if (Repository.getInstance().addAmount(amount, accountNumber))
			controller.success("Amount credited successfully");
		else
			controller.failed("Oop's something went wrong..Try later");
	}

	@Override
	public void validAmountDebit(String accountNumber, String amount) {
		if (amount.isEmpty() || amount.equals("0"))
			controller.inValidAmount("Please enter valid amount..Do you want to exit enter 0 or otherwise enter 1");
		else {
			String balance = Repository.getInstance().validAmount(accountNumber);
			if (!(Double.parseDouble(balance) >= Double.parseDouble(amount)))
				controller.inSufficientBalance(
						"You have insufficient balance..Do you want to exit enter 0 or otherwise enter 1");
			else {
				if (Repository.getInstance().debitAmount(accountNumber, amount))
					controller.success("Amount debited successfully");
				else
					controller.failed("Oop's something went wrong..Try later");
			}
		}
	}

	@Override
	public void exit() {
		Repository.getInstance().exit();
	}

	@Override
	public void changePinNumber(String mobileNumber, String mPin) {
		String password = Repository.getInstance().changePinNumber(mobileNumber, mPin);
		controller.captcha(password, "Enter the captcha");
	}

	@Override
	public void pinNumber(String accountNumber, String pinNumber) {
		if (Repository.getInstance().pinNumber(accountNumber, pinNumber))
			controller.success("Pin number set successfully");
		else
			controller.failed("Oop's something went wrong..Try later");
	}

	@Override
	public void validMobileNumber(String accountNumber, String mobileNumber, String mPin) {
		if(Repository.getInstance().validMobileNumber(accountNumber,mobileNumber,mPin))
			controller.setPin(mobileNumber,mPin);
		else
			controller.inValidMobileNumber("Kindly check your mobile number and M-Pin..Do you want to exit enter 0 or otherwise 1");
	}

}