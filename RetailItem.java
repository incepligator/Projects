package com.cubic.assignments.oops;

import java.io.Serializable;

// RetailItem- abstract superclass

//Abstract superclass for RetailItem  hierarchy

public abstract class RetailItem implements Serializable{
	public static final long serialVersionUID = -6334799572225439822L;
	public  String name;
	public float ct,q;
	
	
	// Initializes RetailItem data
	
	
	public RetailItem(String name) {
		super();
		this.name = name;
	}

	
	
	
	// Returns name of RetailItem

	public final String getName() {
		return name;
	}

	
	
	
	// Returns cost of RetailItem
	public abstract  int getCost();

}
