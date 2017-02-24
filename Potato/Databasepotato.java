package com.cubic.assignments.oops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Databasepotato implements Serializable{
	
	public static final long serialVersionUID = -6334799572225439822L;
	public static void main(String[] args) throws SQLException, IOException {
		
		Databasepotato p= new Databasepotato();
		
		
		p.tablewrite();
		
	}


	void tablewrite() throws SQLException, IOException {

		
		JDBCconnection JC = new JDBCconnection();
		Connection con = null;
		

		String linux;

		

		try {
			con = JC.getConnection();
			
			System.out.println("sucess");
			
			Statement stmt = con.createStatement();
			
			
			for (RetailItem xx : CheckOut.apr) {

				linux = "insert into Potato values(human.nextval,'" + xx.name + "','"+xx.q+"',"+xx.ct+")";

				System.out.println(linux);

				stmt.executeUpdate(linux);

			}

			System.out.println("table updated");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con.close();

		System.out.println("Connection Closed");
	}

}
