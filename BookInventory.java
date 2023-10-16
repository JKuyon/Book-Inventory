/*
 * Author: Jordan Kuyon
 * Purpose of Program: The modeling of a real-life object of a Book Inventory
 * Date: 05/26/2023
 */

import java.util.Scanner; // Importing the scanner class
import java.util.ArrayList; // Importing the ArrayList class
import java.util.List; // Importing List Class

public class BookInventory {
	
	// Origin of Book Class
	static class Book { 
			private int id; // Attribute for numerical Book identification on user input
			private String title; // Attribute for Book title on user input
			private double price; // Attribute for Book price on user input
			
			// Constructor of Book object
			public Book(int id, String title, double price) {
				// Reference to the Book Object
				this.id = id;
				this.title = title;
				this.price = price;
			}
		@Override
		public String toString() { // Display books in proper format
			return "Book id: " + id + " Title: " + title + " Price: " + price;
		}
	} // End of Book Class
	
	static class Inventory { // Origin of the Inventory Class
		
		// 'Inventory' ArrayList to hold Book data
		List<Book> inventory = new ArrayList<>();
		
		// Method to add Book in the ArrayList - Menu Option 1
		public void addBook(Scanner input) {
			
			System.out.print("Please enter the book id (as 5 integers): ");
			int id = input.nextInt();
			System.out.println();
			
			// Validation for id input
			if ((id < 10_000) || (id > 99_999)) { // Range set between 10000 - 99999 for id
				System.err.println("Please re-enter the id of the book (must be 5 integers): "); // Error Message for id
				id = input.nextInt();
				System.out.println();
			} 
			
			System.out.print("Please enter the book title: ");
			String title = input.next();
			input.nextLine();
			System.out.println();
			
			System.out.print("Please enter the book price: ");
			double price = input.nextDouble();
			System.out.println();
			
			// Create book object
			Book book = new Book(id, title, price); 
			inventory.add(book); // Add book to ArrayList after user input
			
			// Success Message for first case 1
			System.out.println("The book was added to the inventory.");
			System.out.println(); // Line Spacing
		}
		
		// Method to remove Book from the ArrayList - Menu Option 2
		public void removeBook(Scanner input) {
			System.out.print("Please enter the book id (as 5 integers): ");
			int id = input.nextInt();
			System.out.println();
			
			int index = binarySearch(id);
			inventory.remove(index); // Calling Method to Remove the element in Array List
			System.out.println(" The book " + id + " has been removed");
			System.out.println();
		}
		
		// Method to find Book from the ArrayList - Menu Option 3
		public Book findBook(Scanner input) {
			System.out.print("Please enter the book id (as 5 integers): ");
			int id = input.nextInt();
			System.out.println();
			
			// Perform Binary Search on ArrayList
			int index = binarySearch(id);
			Book book = inventory.get(index);
			
			System.out.println("You found book:" + book + "using id: " + id);
			return book;
		}
		
		// Method to search through the entire array based on id
		private int binarySearch(int id) {
			int index = 0;
			
			// Cycle through inventory ArrayList
			for (int i = 0; i < inventory.size(); i++) {
				if (id == inventory.get(i).id) {
					index = i;
				}
			}
			return index; // Return index which holds the id
		}
		
		// Method to display all Books from the ArrayList - Menu Option 4
		public void displayAllBooks() {
			System.out.println(inventory.toString());
		}
		
	} // Ending of Origin Class
	
	// Method to display menu for selection
	public static void displayMenu() {
		// Method to display menu options and make selection
		System.out.println("MENU");
		System.out.println("1: Add Book");
		System.out.println("2: Remove Book");
		System.out.println("3: Find Book");
		System.out.println("4: Display all books");
		System.out.println("9: Exit program");
		System.out.println();
		System.out.println("Enter your selection: ");
	}

	
	// Main Method
	public static void main(String[] args) {
		// Variable for menu selection option
		int select;
						
		// Scanner class for the menu selection
		Scanner menuSelection = new Scanner(System.in);
		

		// Instance and Instantiation of the Inventory Class
		Inventory inventory = new Inventory(); 
		
		do { // Loop the program after 1st run
			// Display the menu for selection
			displayMenu();
			select = menuSelection.nextInt();
			
			// Creating switch statement for menu options
			switch(select) { 
			case 1: // Add Book
				inventory.addBook(menuSelection); // Calling Method to Add Book object to inventory ArrayList
				break;
			case 2: // Remove Book
				inventory.removeBook(menuSelection); // Calling Method to Remove Book from inventory ArrayList
				break;
			case 3: // Find Book
				inventory.findBook(menuSelection); // Calling Method to find Book from inventory ArrayList
				break;
			case 4: // Display all books
				inventory.displayAllBooks(); // Calling Method to Display All Books in inventory ArrayList
				break;
			case 9: // Exit Program
				System.out.println("Thank you for using the program. Goodbye!");
				System.exit(0);
			default:
				System.out.println("The option " + select + " cannot be used as a menu option. Please try again (either 1,2,3,4,9).");
			}
		} while(select != 9);
	}
}
