package assignments.loan.sql;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Wsql {

	void waterfall() throws ClassNotFoundException, SQLException, EncryptedDocumentException, InvalidFormatException, IOException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");
		
		// create table with primary key and add foriegn key

		String Table_Student = "create table Student(SID number(5) NOT NULL primary key, SName VARCHAR2(20),Course varchar2(20), foreign key(Course) references Course(CName),Score number(4))";
		String Table_Course = "create table Course(CID number(4) NOT NULL, CName VARCHAR2(20) primary key,Professor varchar2(20), IsPreq varchar2(5))";

		String course_cid="create sequence course_cid start with 2 increment by 2";
		String student_sid="create sequence student_sid start with 1 increment by 2";
		
		Statement stmt = con.createStatement();

		
/*		stmt.executeUpdate(Table_Course);
		stmt.executeUpdate(Table_Student);
		
			
		System.out.println("Table Created ");
		
		stmt.executeUpdate(course_cid);
		stmt.executeUpdate(student_sid);*/
		
	//	System.out.println("Sequence Student and Course  Created ");
		
		// insert values by preparedstatements
				String a = "insert into Course values(course_cid.nextval,?,?,?)";
				String b = "insert into Student values(student_sid.nextval,?,?,?)";

				PreparedStatement pstc = con.prepareStatement(a);
				PreparedStatement psts = con.prepareStatement(b);
				
				/*pstc.setString(1, (xls("Course", 1, 1)));
				pstc.setString(2, (xls("Course", 1, 2)));
				pstc.setString(3, (xls("Course", 1, 3)));
				
				pstc.executeUpdate();*/
				//for row excel
				for (int j = 1; j <= 5; j++) {
					//for column excel
					for (int i = 1; i<=3; i++) {
						
						pstc.setString((i), (xls("Course", j, i)));				
						
						
					}
					pstc.executeUpdate();
				}
				//for row excel
				for (int j = 1; j <= 21; j++) {
					//for column excel
					for (int i = 1; i<=3; i++) {
						
						if(i==3){
							float score= Float.parseFloat(xls("Student", j, i));
							psts.setFloat(i, score);
							
						}
						else 
						{
							psts.setString((i), (xls("Student", j, i)));
					}
					}
					psts.executeUpdate();
				}
				
				
				
			System.out.println("Data transfer into excel into sql ");	
				
		con.close();

		System.out.println("connection closed ");
	}

	

	public String xls(String sdata, int rdata, int cdata)
			throws EncryptedDocumentException, InvalidFormatException, IOException

	{

		FileInputStream fis = new FileInputStream("C:\\Users\\Kosovo\\Desktop\\Cubic\\Table.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sdata);
		Row r = s.getRow(rdata);
		Cell c1 = r.getCell(cdata);
		
		return c1.toString();

	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		
		Wsql x= new Wsql();
		
		x.waterfall();
		
		
	}

}
