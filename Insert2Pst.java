package com.J2Ee.Task;

import java.sql.*;
import java.util.*;

public class Insert2Pst {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
		
		PreparedStatement pst = con.prepareStatement("insert into employee values(?, ?, ?, ?)");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many row you want to insert: ");
		int row = sc.nextInt();
		
		for(int i=0; i<row; i++) {
			System.out.print("Enter the new id: ");
			int eid = sc.nextInt();
			
			System.out.print("Enter the new name: ");
			String ename = sc.next();
			
			System.out.print("Enter the new email: ");
			String email = sc.next();
			
			System.out.print("Enter the new contact: ");
			long contact = sc.nextLong();
			
			pst.setInt(1, eid);
			pst.setString(2, ename);
			pst.setString(3, email);
			pst.setLong(4, contact);
			
			int a = pst.executeUpdate();
			System.out.println(a + " rows inserted");
			
		}
		con.close();
	}

}
