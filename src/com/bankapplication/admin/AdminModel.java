package com.bankapplication.admin;

import java.util.ArrayList;
import java.util.List;

import com.bankingapplication.respository.Repository;

public class AdminModel implements AdminModelCallBack{
	private AdminModelControllerCallBack controller;

	AdminModel(AdminModelControllerCallBack controller) {
		this.controller = controller;
	}

	
	interface AdminModelControllerCallBack{

		void showDetails(ArrayList<List<String>> usersInfo);

		void validAccount(ArrayList<String> userInfo);

		void invalidAccount(String string);
		
	}

	@Override
	public void userDetails() {
		ArrayList<List<String>> usersInfo=Repository.getInstance().userDetails();
		controller.showDetails(usersInfo);
	}

	@Override
	public void searchAccount(String accountNumber) {
		if(Repository.getInstance().validCheck(accountNumber)) {
		ArrayList<String> userInfo=Repository.getInstance().searchAccount(accountNumber);
		controller.validAccount(userInfo);
		}
		else
			controller.invalidAccount("There is no account exist");
	}
}