package com.runtime.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.runtime.bean.Transaction;

public class TransactionDaoImpl implements TransactionDao {
	private static String url = "jdbc:oracle:thin:@aug27pega.c6dt4deskvoq.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String usr = "BenCoAdmin";
	private static String pss = "IaminTheMoney";

	@Override
	public List<Transaction> getTransList(int userId) throws SQLException {
		List<Transaction> getTrans = new ArrayList<Transaction>();
		try (Connection conn = DriverManager.getConnection(url, usr, pss)) {
			System.out.println(userId);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM TRANSACTIONS WHERE EMPLOYEE_ID=?");
			
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			Transaction s = null;
			while (rs.next()) {

				s = new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5));
				getTrans.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(getTrans);
		return getTrans;
	}

}
