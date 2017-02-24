package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteTable {

	static void Connect() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");

		// create table

		String Table_Studentx = "create table Studentx(SID number(4) NOT NULL primary key, SName VARCHAR2(20),Score number(4))";
		String Table_Course = "create table Course(CID number(4) NOT NULL, CName VARCHAR2(20),Professor varchar2(20), IsPreq varchar2(5))";
		Statement stmt = con.createStatement();
		// stmt.executeUpdate(Table_Studentx);
		// stmt.executeUpdate(Table_Course);

		// insert values by preparedstatements
		String b = "insert into Course values(?,?,?,?)";
		String a = "insert into Studentx values(?,?,?)";

		PreparedStatement pst = con.prepareStatement(a);
		PreparedStatement pstc = con.prepareStatement(b);

		for (Student x : Course.student) {

			// writing table in students
			pst.setInt(1, x.SID);
			pst.setString(2, x.SName);
			pst.setInt(3, x.Score);

			// writing table in course
			pstc.setInt(1, x.course.CID);
			pstc.setString(2, x.course.Name);
			pstc.setString(3, x.course.Professor);
			pstc.setString(4, x.course.IspreReq);

			pst.executeUpdate();
			pstc.executeUpdate();

		}

		System.out.println("Record inserted");

		con.close();

		System.out.println("connection closed ");
	}

}
