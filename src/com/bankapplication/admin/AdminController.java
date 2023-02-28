package com.bankapplication.admin;

import java.util.ArrayList;
import java.util.List;

import com.bankapplication.admin.AdminModel.AdminModelControllerCallBack;

public class AdminController implements AdminControllerCallBack,AdminModelControllerCallBack{

	private AdminModelCallBack model;
	private AdminViewCallBack view;
	
	AdminController(AdminView view){
		this.view=view;
		model=new AdminModel(this);
	}

	@Override
	public void userDetails() {
		model.userDetails();
	}

	@Override
	public void showDetails(ArrayList<List<String>> usersInfo) {
		view.showDetails(usersInfo);
	}

	@Override
	public void searchAccount(String accountNumber) {
		model.searchAccount(accountNumber);
	}

	@Override
	public void validAccount(ArrayList<String> userInfo) {
		view.validAccount(userInfo);
	}

	@Override
	public void invalidAccount(String string) {
		view.invalidAccount(string);
	}

	
}