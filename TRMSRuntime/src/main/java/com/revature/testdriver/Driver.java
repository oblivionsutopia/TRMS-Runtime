package com.revature.testdriver;

import java.sql.SQLException;

import com.revature.daoimpl.UserDAOImpl;

public class Driver {

	public static void main(String[] args) {
		UserDAOImpl gul = new UserDAOImpl();
		try {
			gul.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
