import java.util.Scanner;
import java.util.Iterator;
import java.io.*;
/**
 * This class is responsible for individual products within the inventory
 * 3/25/19
 * @version 2.0
 * @author Hunter Moore
 */

//I commented out Comparable because I could not get compareTo to work, but I left it for future review.

public class Product {//implements Comparable<Object> {
	//vars
	private String name;
	private int number;
	private String category;
	private boolean availability;
	protected int result;

	/**
	* Constructor creates a Product that includes the necesary details
	* @param name Name of product added
	* @param number Product number of product
	* @param category What department does the product belong to
	* @param availability Whether or not product is in stock
	*/
	public Product (String name, int number, String category, boolean availability){
		this.name = name;
		this.number = number;
		this.category = category;
		this.availability = availability;
	}
	
	/**
	* Generic constructor does nothing, is not useful
	*/
	public Product(){}

	//Getter methods for instance variables 
	public String getName(){
		return name;
	}

	public int getNumber(){
		return number;
	}


	public boolean getAvailability(){
		return availability;
	}

	/**
	 * I could not get this method to work. I left it here so I could review it in the future.
	 */
	/**public int compareTo(Object o){

			result = (Product)o.getNumber();
			if (result < 0){
				return -1;
			}
			else if (result == 0){
				return 0;
			}
			else{
				return 1;
			}
		}
		*/
	
	/**
	 * Prints out Product information as a string 
	 * @return String returns product information. Including product number, name, and category.
	 * Runtime: O(c)
	 */
	 
	public String toString(){
		return "Product number: " + number + "," + " Name: " + name + "," + " Product Category: " + category;

	}

}

