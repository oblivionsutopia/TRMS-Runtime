package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void getUserList() throws SQLException {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS");
		ResultSet rs = stmt.executeQuery();

		   ResultSetMetaData rsmd = rs.getMetaData();
		   System.out.println("All the Users of the Database");
		   int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++)
			{
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
			System.out.println();			
		}	
		System.out.println();
		
	}

}
