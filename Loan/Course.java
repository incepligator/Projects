package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

	public int CID;

	public String Name;

	public String Professor;

	public String IspreReq;

	public static ArrayList<Student> student;
	
	public Course(){
		student = new ArrayList<Student>();
	}

/*	public Course(int cID, String name, String professor, String ispreReq) {
		super();
		CID = cID;
		Name = name;
		Professor = professor;
		IspreReq = ispreReq;

	}*/

	void printStudent() {

		for (Student x : student) {

			System.out.println(x.course.CID);
			System.out.println(x.course.Name);

		}

	}

	@Override
	public String toString() {
		return "Course [CID=" + CID + ", Name=" + Name + ", Professor=" + Professor + ", IspreReq=" + IspreReq + "]";
	}

}
