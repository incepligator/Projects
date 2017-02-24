package Assignment;

import java.io.IOException;

import Assignment.Student.Grade;

public class Loan {

	Student s = new Student();
	String SGrade;

	String CheckGrade() throws IOException {

		if (s.Score >= 90) {
			SGrade = Grade.A.toString();
		} else if (s.Score >= 80) {
			SGrade = Grade.B.toString();
		} else if (s.Score >= 70) {
			SGrade = Grade.C.toString();
		} else {
			SGrade = Grade.D.toString();
		}

		return SGrade;

	}

	void getAmount() {

		if (SGrade.equalsIgnoreCase("A")) {
			System.out.println("The loan passed is 25,000");
			System.out.println("the interest rate is 8%");
		} else {
			System.out.println("The loan passed is 10,000");
			System.out.println("the interest rate is 10%");
		}

	}

	void getIntrest() {

	}

}
