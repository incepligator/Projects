package com.cubic.assignments.oops;


import java.io.Serializable;
import java.util.Scanner;

public class Potato  extends RetailItem {
	 private static final long serialVersionUID = -841825462075598133L;
	float sweetrt, redrt, whitert, localrt;
	public float rate;
String sname;

	
	

	@Override
	public String toString() {
		return "Potato [Quantity=" + q + ", Rate=" + rate + ", Potato Types =" + name + ", Total=" + ct + "]";
	}

	public Potato(String name) {
		super(name);

		super.name="Potato";
		

		
		types();
		

	}
	
	void types(){
		
		sweetrt = (float) 2.5;
		redrt = (float) 20.5;
		whitert = (float) 52.2;
		localrt = (float) 0.55;

		System.out.println("Enter the " + name + " types [Sweet] [ Red] [White] [Local]");
		System.out.println("   pound  " + name + " rate  [ " + sweetrt + "] [" + redrt + "] [ " + whitert + "] [ "
				+ localrt + "]");
		
		Scanner ss = new Scanner(System.in);

		sname = ss.next();
		
		
		
//		name= ss.next();
		
		
		
		if (sname.equalsIgnoreCase("Sweet") || sname.equalsIgnoreCase("Red") || sname.equalsIgnoreCase("White") || sname.equalsIgnoreCase("Local"))
		{
			super.name=sname+" Potato";
			getCost();
			
		}
		else{
			types();
			
		}
		
	}

	public int getCost() {
		
			
			
			System.out.println("Enter the quantity of " + name);

			Scanner s = new Scanner(System.in);

			
			
			boolean fl;
			
			fl=s.hasNextFloat();
			
			
			
			if(fl){
				
				q = s.nextFloat();
			
		if (name.equalsIgnoreCase("Sweet Potato")){
			rate=sweetrt;
			ct = sweetrt * q;}
		else if (name.equalsIgnoreCase("Red Potato")){
			
			rate=redrt;
			ct = redrt * q;
		}
		else if (name.equalsIgnoreCase("White Potato")){
			
			rate=whitert;
			ct = whitert * q;}
				
				
			
		else if (name.equalsIgnoreCase("Local Potato")){
			rate=localrt;
			
			ct = localrt * q;
		}
			}
			else{
				System.out.println("Invalid Input Quantity");
				getCost();
				
			}

//		return (int) ct;
		return  (int) rate;
		
	}

	

}
