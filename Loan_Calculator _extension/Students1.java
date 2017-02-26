package assignments.loan.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Assignment.Course;

public class Students1 {

	Connection con = null;

	@Override
	public String toString() {
		return "[SID=" + SID + ", SName=" + SName + ", course=" + course + ", Score=" + Score + "]";
	}

	int SID;

	String SName;

	Course course;

	static int Score;

	Students x;

	static ArrayList<Students> str = new ArrayList<Students>();

	Students() {

	}

	public Students(int sID, String sName, Course course, int score) {
		super();
		SID = sID;
		SName = sName;
		this.course = course;
		Score = score;
	}

	void pass() {

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int i = 0;
		Students s = new Students();

		s.connection();
		s.rtable();

		// for Fail Student
		for (Students st : str) {

			
			System.out.println(st);
		/*	if (st.Score <= 40) {
				System.out.println("Fail Students are......." + st.SName + "...Score ..." + st.Score);
			}
			
			// for pass student
			if (st.Score >= 40) {
				System.out.println("Pass Students are......." + st.SName + "...Score ..." + st.Score);
			}*/
			

		}
		
		System.out.println("..............................................");

		for (Students st : str) {

			
			

		}

/*		
		if (st.Score <= i) {

		} else {
			i = st.Score;
		}*/
		System.out.println("Higest score is ......." + i);

	}

	void connection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");
	}

	void rtable() throws SQLException {

		Statement stmt;
		try {
			stmt = con.createStatement();
			String sstudent = "select * from student";
			String scourse = "select * from course";

			ResultSet rc = stmt.executeQuery(scourse);
			/*
			 * ResultSetMetaData rsmd = rs.getMetaData();
			 * 
			 * DatabaseMetaData dms=con.getMetaData();
			 */

			System.out
					.println("Enter the Course for PASS FAIL \n\t\t\t\t [JVA.101][SCO.101][NPL.101][MTH.201][PHY.301]");
			Scanner sc = new Scanner(System.in);
			String user = sc.next();

			while (rc.next()) {
				if (user.equalsIgnoreCase(rc.getString(2))) {

					course = new Course(rc.getInt(1), rc.getString(2), rc.getString(3), rc.getString(4));
				}

			}

			ResultSet rs = stmt.executeQuery(sstudent);

			while (rs.next()) {
				if (course.Name.equalsIgnoreCase(rs.getString(3))) {

					x = new Students(rs.getInt(1), rs.getString(2), course, rs.getInt(4));
					str.add(x);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con.close();
	}

}
