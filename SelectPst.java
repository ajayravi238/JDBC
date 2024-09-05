package com.J2Ee.Task;

import java.sql.*;
import java.util.*;

public class SelectPst {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql:///j2ee", "root", "root");
		
		PreparedStatement pst = con.prepareStatement("select ename, contact from employee where eid = ?");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the id you want to select: ");
		int eid = sc.nextInt();
		
		pst.setInt(1, eid);
		 	 	
		ResultSet rs = pst.executeQuery();
		rs.next();
		System.out.println(rs.getString(1) + " - " + rs.getLong(2));
		
		con.close();
	}

}
