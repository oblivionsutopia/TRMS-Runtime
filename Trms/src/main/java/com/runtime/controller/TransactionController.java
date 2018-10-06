package com.runtime.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtime.bean.Transaction;
import com.runtime.bean.User;
import com.runtime.dao.TransactionDaoImpl;


public class TransactionController {

	public static String TransJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in TransJSON method");
		Transaction trans = (Transaction) request.getSession().getAttribute("Transaction");
		System.out.println(trans);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(trans));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}

	public static String getTrans(HttpServletRequest request) {
		if (request.getMethod().equals("POST")) {
			return "/html/TransactionHistoryE.html";
		}
		
//		String name = request.getParameter("name");
//		String type = request.getParameter("type");
		User user = new User();
		int userId = Integer.parseInt(request.getParameter("EID"));
		System.out.println(userId);
		 request.getSession().setAttribute("User", user);
		 user.setUserId(userId);
		 
		System.out.println("userId");
		Transaction trans = new Transaction();
		
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		
		 
		try {
			System.out.println("getTrans");
			transactionDaoImpl.getTransList(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/html/TransactionHistoryE.html";
	}

}
