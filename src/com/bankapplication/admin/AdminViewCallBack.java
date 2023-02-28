package com.bankapplication.admin;

import java.util.ArrayList;
import java.util.List;

public interface AdminViewCallBack {

	void showDetails(ArrayList<List<String>> usersInfo);

	void invalidAccount(String string);

	void validAccount(ArrayList<String> userInfo);

}