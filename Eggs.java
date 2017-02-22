package com.cubic.assignments.oops;

import java.io.Serializable;
import java.util.Scanner;

public class Eggs extends RetailItem {
	 private static final long serialVersionUID = -841825462075598133L;
	int rate=3;
	
	
	@Override
	public String toString() {
		return "Eggs [Rate=" + rate + ", Eggs Type=" + name + ", Total=" + ct + "]";
	}


	public Eggs(String name) {
		super(name);
		
		System.out.println("Please Enter the no of eggs  [       3$ per Dozen      ]");
				
		getCost();
		
	}

	
	public int getCost() {
		
		
		Scanner s= new Scanner(System.in);
		
		q= s.nextInt();
		
		ct=q/12*3;
		
		
		return 0;
	}
	
	
	

}
