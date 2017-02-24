package com.cubic.assignments.oops;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckOut {
	static CheckOut c = new CheckOut();

	static ArrayList<RetailItem> apr = new ArrayList<RetailItem>();

	float total;

	public void method() throws IOException, ClassNotFoundException, SQLException {

		System.out.println("Enter the Name of the item [Potato] [Eggs] [IceCream] [Sundae]");

		Scanner in = new Scanner(System.in);

		String str = in.next();

		switch (str.substring(0, 3).toUpperCase()) {

		case "POT":

			Potato p = new Potato(str);

			System.out.println(p);
			c.apr.add(p);
			c.yesno();

			break;

		case "EGG":

			Eggs e = new Eggs(str);

			System.out.println(e);
			c.apr.add(e);

			c.yesno();

			break;

		case "ICE":

			IceCream ice = new IceCream(str);
			System.out.println(ice);
			c.apr.add(ice);

			c.yesno();

			break;

		case "SUN":

			break;

		default:
			method();

			break;

		}

	}

	void yesno() throws IOException, ClassNotFoundException, SQLException {

		Databasepotato d = new Databasepotato();

		System.out.println("Do you want to continue Y/N");

		Scanner s = new Scanner(System.in);

		String st = s.next();

		if (st.equalsIgnoreCase("y")) {

			c.method();
		}

		else {

			for (RetailItem xx : apr) {

				System.out.println(xx);

				total = (total) + (xx.ct);

				d.tablewrite();

			}

			System.out.println("Grand Total cost is........." + total);

		}

	}

	void des() throws IOException, ClassNotFoundException {

		System.out.println("Deserializable .....................");

		ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("C:\\Users\\Kosovo\\Desktop\\cubic\\Purchasestr.txt"));

		ArrayList<RetailItem> pp = (ArrayList<RetailItem>) oin.readObject();

		for (RetailItem s : pp) {

			System.out.println(s.name + "     " + s.ct);

		}

		oin.close();

		System.out.println("deserialized");

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		c.method();
		c.write();
		c.des();

	}

	void write() throws IOException {

		FileWriter fiko = new FileWriter("C:\\Users\\Kosovo\\Desktop\\Cubic\\Purchase.txt");
		PrintWriter fiks = new PrintWriter(fiko);

		FileOutputStream fks = new FileOutputStream("C:\\Users\\Kosovo\\Desktop\\cubic\\Purchasestr.txt");

		ObjectOutputStream o = new ObjectOutputStream(fks);

		for (Object xx : apr) {

			fiks.println(xx);
		}

		o.writeObject(apr);

		System.out.println("Serialized");

		fiks.close();
		fiko.close();

		o.close();
		fks.close();

	}

}
