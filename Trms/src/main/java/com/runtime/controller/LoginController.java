package com.runtime.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.runtime.bean.User;
import com.runtime.dao.UserDaoImple;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}

		String username = request.getParameter("Username");
		String password = request.getParameter("Password1");

		UserDaoImple userDaoImpl = new UserDaoImple();
		User user = new User();

		try {
			user = userDaoImpl.getUserByUsrPass(username, password);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (username.equals(user.getUserName()) && password.equals(user.getPassWord())) {
			if (user.getJobType() == 1) {
				request.getSession().setAttribute("User", user);

				return "/html/Profile.html";
			} else if ((user.getJobType() == 2) || (user.getJobType() == 3) || (user.getJobType() == 4)){
				request.getSession().setAttribute("User", user);
				return "/html/ProfileM.html";
			}
		} else {
			return "/html/Login.html";
		}
		return "/html/Login.html";

	}
}
