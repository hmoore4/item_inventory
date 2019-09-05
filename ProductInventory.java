import java.util.Iterator;
import java.util.Stack;
/**
 * This class is responsible for taking care of an entire inventory
 * 3/25/19
 * @ author Hunter Moore
 * @ version 8.0
 */

public class ProductInventory extends Product{
	private Stack<Product> stack = new Stack<Product>();						//Stack keeps track of recent searches
	protected LinkedPositionalList<Product> list;										//Positional List that stores objects
	
	//vars
	private int totalProducts;								//Number of all products
	private int availableProducts;						//Number of products in stock
	private int maxSize;
	private String companyName = "Hunter's Shop";
	/**
	* Constructor makes new list when created
	*/
	public ProductInventory(){
		list = new LinkedPositionalList<Product>();
	}
	
	/**
	* Parametric Constructor
	* @param maxSize max choose maximum size of inventory if desired
	*/
	public ProductInventory(int maxSize) {
		this.maxSize = maxSize;
		list = new LinkedPositionalList<Product>();
	}
	
	/**
	* Displays all items in inventory 
	* Runtime complexity: O(n)
	*/
	public void display(){
		Iterator<Product> iter = list.iterator();

		System.out.println("Printing all items in our inventory:");
		System.out.println("");
		if (list.size() == 0) {
			System.out.println("Error: No items exist in inventory.");
		}
		else {
			while (iter.hasNext()) {					//Goes through iterator
				System.out.println(iter.next());		//Prints Product
			}	
			System.out.println("");
		}
	}
	
	/**
	* This method allows user to search for a product by entering the product number
	* Runtime complexity: O(n)
	* @param productNumber the product number the user searches for
	*/
	public void find(int productNumber) {
		Iterator<Product> iter = list.iterator();
		while(iter.hasNext()) {
			Product temp = iter.next();							//Make temporary variable so I can use iter.next() more than once
			if(temp.getNumber() == productNumber) {			//If the parameter equals a product number
				System.out.println("Searching for product with product number of " + productNumber + "...");
				System.out.println("Product Found: " + temp ); //Print product
				System.out.println("");
				stack.push(temp);										//Add to stack of items searched
				break;
			}
			else if(!iter.hasNext()) {
				System.out.println("Error: No product found with the product number of: " + productNumber);				//Otherwise throw exception because item is not in inventory
				System.out.println("");
			}
		}
	}
	
	/**
	* Displays five most recent searches
	* Runtime: O(c)
	*/
	public void topSearched() {
		System.out.println("Displaying the 5 most recent searched products:");
		if(stack.size() < 5) {																																			//If there are not 5 elements in the stack
			System.out.println("Error: Cannot print because 5 products have not been searched");				//Do not print
			}
		else {
			for(int i = 0; i < 5; i++) {								//Goes through first five elements of stack
				System.out.println(stack.pop());					//Prints them out
			}
		}
	}
	
	/**
	* Prints out all products that are in stock
	* Runtime: O(n)
	*/
	public void displayAvailable() {
		Iterator<Product> iter = list.iterator();
		System.out.println("Printing all products currently available in our inventory:");
		System.out.println("");
		while (iter.hasNext()) {
			Product temp = iter.next();
			totalProducts++;
			if (temp.getAvailability() == true) {		//If item is available
				System.out.println(temp);							//Print it. Otherwise do nothing
				availableProducts++;
			}
		}
		System.out.println("");
		System.out.println("Total products: " + totalProducts);									//Print out other information
		System.out.println("Total available products: " + availableProducts);
		System.out.println("");
	}
	/**
	* Adds a product to the inventory
	* This method tried to implement compareTo, but I could not get it to work. I left the code for future review
	* Runtime: O(c)
	* @param p the product added to inventory
	*/
	public void insert(Product p){
		Iterator<Product> iter = list.iterator();
		System.out.println("Inserting " + p.getName() + " into inventory...");
		list.addFirst(p);
		//System.out.println("");
	}
	

	
	/**
	* Removes item from inventory
	* Runtime: O(c)
	* @param productNumber product number of the product removed from inventory
	*/
	public void remove(int productNumber) {
		Iterator<Product> iter = list.iterator();
			while (iter.hasNext()) {
				Product temp  = iter.next();
				if (temp.getNumber() == productNumber) {
					System.out.println("Removing product with product number of " + productNumber + "..." );
					iter.remove();
					break;
				}
				else if (!iter.hasNext()) {
		System.out.println("Error: Product cannot be removed because no product in the inventory has a product number of " + productNumber);
		}

		}
		//System.out.println("");
		}
	public static void main(String[] args) {
		System.out.println("Welcome to Hunter's Shop!");
		System.out.println("");
		ProductInventory inventory1 = new ProductInventory();
		Product product1 = new Product("Basketball", 1, "Sports", true);					//Make objects
		Product product2 = new Product("Don Quixote", 2, "Literature", true);
		Product product3 = new Product("Chair", 3, "Furniture" , false);
		Product product4 = new Product("Hat", 5, "Clothes" , false);
		Product product5 = new Product("Hoop", 10, "Sports", true);
		Product product6 = new Product ("Shampoo", 15, "Bathroom", true);
		inventory1.insert(product1);					//Insert them
		inventory1.insert(product2);
		inventory1.insert(product3);
		inventory1.insert(product4);
		inventory1.insert(product5);
		inventory1.insert(product6);
		System.out.println("");
		inventory1.display();					//Print them out
		inventory1.remove(3);					//Remove products
		inventory1.remove(15);
		System.out.println("");
		inventory1.display();
		inventory1.insert(product6);
		inventory1.insert(product3);
		System.out.println("");
		inventory1.displayAvailable();				//Print in stock products
		inventory1.find(1);									//Search 6 products
		inventory1.find(2);
		inventory1.find(10);
		inventory1.find(3);
		inventory1.find(5);
		inventory1.find(15);
		inventory1.topSearched();					//Print most recent 5 searched products
		System.out.print("");
		System.out.println("Thanks for using Hunter's Shop!");
	}

}


