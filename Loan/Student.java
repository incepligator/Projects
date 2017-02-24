package Assignment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	public int SID;

	public String SName;

	static public Course course = new Course();

	public int Score;

	public enum Grade {
		A, B, C, D
	}

	static Scanner sc = new Scanner(System.in);

	void input() {

		System.out.println("Please Enter Student SID .................");
		SID = sc.nextInt();

		System.out.println("Please Enter Student Name .................");
		SName = sc.next();

		System.out.println("Please Enter Student Score 0-100 only  .................");
		Score = sc.nextInt();

		System.out.println("Please Enter CourseDetails .................");

		System.out.println("\t Please Enter Course ID .................");
		course.CID = sc.nextInt();

		System.out.println("\t Please Enter Course Name .................");
		course.Name = sc.next();
		System.out.println("\t Please Enter Course Professor .................");
		course.Professor = sc.next();

		System.out.println("\t Please Enter Course is Prereq .................");
		course.IspreReq = sc.next();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		core();

		System.out.println("Do you want to Insert another student data");

		String y = sc.next();

		if (y.equalsIgnoreCase("y")) {
			core();
		} else {
			//print arraylist
			course.printStudent();
			//write table in sql 
			new WriteTable().Connect();
			

		}

	}

	@Override
	public String toString() {
		return "Student [SID=" + SID + ", SName=" + SName + ", course=" + course + ", Score=" + Score + "]";
	}

	public Student() {

	}

	public Student(int sID, String sName, Course course, int score) {
		super();

		SID = sID;
		SName = sName;
		this.course = course;
		Score = score;

	}

	static void core() throws IOException, ClassNotFoundException, SQLException {

		Student j = new Student();
		Loan ll = new Loan();

		j.input();

		Student s1 = new Student(j.SID, j.SName, course, j.Score);

		course.student.add(s1);
		
		//loan portion 
		ll.CheckGrade();
		ll.getAmount();

	}

}