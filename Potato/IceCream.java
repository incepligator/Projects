package com.cubic.assignments.oops;

import java.io.Serializable;
import java.util.Scanner;

public class IceCream extends RetailItem {
	private static final long serialVersionUID = -841825462075598133L;
	String typ;

	public IceCream(String name) {
		super(name);

		display();

	}

	@Override
	public int getCost() {

		System.out.println("Enter the quantity of " + name);

		Scanner s = new Scanner(System.in);

		boolean x = s.hasNextInt();

		boolean y = s.nextInt() >= 1;

		if (x && y) {

			/* if(q>=1){ */
			q = s.nextInt();

			ct = q * 5;
		}
		/*
		 * else System.out.println("Invalid input  "); getCost(); }
		 */
		else {
			System.out.println("Invalid ");
			getCost();
		}

		return 0;
	}

	@Override
	public String toString() {
		return "IceCream [ Quantity=" + q + ", Rate=" + "5$" + " IceCream Type=" + name + ", Total=" + ct + "]";
	}

	void display() {

		System.out.println("Enter the " + name + " types [Vanilla] [Pecan] [Mint] [Butter] [Chocolate] [Strawberry]");

		Scanner ic = new Scanner(System.in);

		typ = ic.next();

		if (typ.substring(0, 3).toLowerCase().contains("van")) {
			typ = "Vanilla";
			super.name = typ;
			getCost();
		} else if (typ.substring(0, 3).toLowerCase().contains("str")) {
			typ = "Strawberry";
			super.name = typ;
			getCost();
		} else if (typ.substring(0, 3).toLowerCase().contains("pec")) {
			typ = "Pecan";
			super.name = typ;
			getCost();
		} else if (typ.substring(0, 3).toLowerCase().contains("cho")) {
			typ = "Chocolate";
			super.name = typ;
			getCost();
		} else if (typ.substring(0, 3).toLowerCase().contains("min")) {
			typ = "Mint";
			super.name = typ;
			getCost();
		} else if (typ.substring(0, 3).toLowerCase().contains("but")) {
			typ = "Butter";
			super.name = typ;
			getCost();
		}

		/*
		 * if (typ.contains("Vanilla") || typ.equalsIgnoreCase("Strawberry")
		 * ||typ.equalsIgnoreCase("Pecan") ||typ.equalsIgnoreCase("Chocolate")
		 * || typ.equalsIgnoreCase("Mint") || typ.equalsIgnoreCase("Butter")) {
		 * super.name=typ; getCost();
		 * 
		 * 
		 * }
		 */
		else {
			System.out.println("Invalid Input ");
			display();
		}

	}

}
