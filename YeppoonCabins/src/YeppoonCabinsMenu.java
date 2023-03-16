/*
Programmer: Amanda Windsor 12197877
File: YeppoonCabinsMenu.java
Due Date: Friday 3, 2023
Purpose: Assignment 1 part B
*/


import java.util.Scanner;




// TODO -- copy the Booking2 class from assignment one part A and rename the class to Booking and rename the file to Booking.java - done
// TODO -- implement the toString method in the Booking class - done

public class YeppoonCabinsMenu
{

    
    // Welcome message
    private static void welcomeMessage() {
        System.out.println("Welcome to Yeppoon Cabins Management System");
    }
    // Exit message
    private static void exitMessage() {
        System.out.println("Thank you for using the Yeppoon Cabins Management System\nProgram written by Amanda Windsor");
    }
    
        // Constants
	final int ENTER_BOOKING = 1;
	final int DISPLAY_BOOKINGS = 2;
	final int DISPLAY_STATISTICS = 3;
	final int SEARCH_BOOKINGS = 4;
	final int EXIT = 5;

	// TODO -- declare any further constants
        final int MAXIMUM_BOOKINGS = 10;
        final int MINIMUM_NIGHTS = 1;

	// TODO -- declare array of Booking objects
        Booking[][] bookings = new Booking[MAXIMUM_BOOKINGS][MAXIMUM_BOOKINGS];
        
        // Counter for number of bookings entered
        int index = 0;
       
        // Data storage for statistics
        float nightsCount = 0; // Tracks all nights booked to calculate averages, float allows for accurate output of calculation
        
	// TODO -- declare variable for the current booking entered (integer)
        public int currentBooking;
        
        
        
        
        
	Scanner inputMenuChoice = new Scanner(System.in);

	private int getMenuItem()
	{
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of nights");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of nights and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(EXIT + ". Exit the application");
		System.out.print("Enter choice==> ");

		String choice = inputMenuChoice.nextLine();
		while (choice.equals("") || !isStringNumeric(choice))
		{
			System.out.println("Error - Menu selection name cannot be blank and must be numeric");

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
	}


	private boolean isStringNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}


	private void processOrders()
	{
		int choice = getMenuItem();
		while (choice != EXIT)
		{
			switch (choice)
			{
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}
	}


	private void enterBooking()
	{
		// TODO -- check if maximum bookings has been reached (do this after getting the other functionality working)
                if (index >= MAXIMUM_BOOKINGS)
                    System.out.println("Error - maximum bookings to be entered has been reached");
                
		// TODO -- read in the booking name (as a string)
                Scanner inText = new Scanner(System.in);
                System.out.print("Please enter the booking name ==> ");
                String bookingName = inText.nextLine();
                
		// TODO -- create validation loop (do this after getting the other functionality working)
                while(bookingName.equals("") || bookingName.equals(" "))
                {
                System.out.print("Error - booking name cannot be blank\n");
                System.out.print("Please enter the booking name ==> ");
                bookingName = inText.nextLine();
                }
                
		// TODO -- read in the number of nights	
                Scanner inNumber = new Scanner(System.in);
                System.out.print("\nEnter the number of nights for " + bookingName + " ==> ");
                int nights;
                nights = inNumber.nextInt();
                nightsCount = nightsCount + nights;
                
                // TODO -- create validation loop (do this after getting the other functionality working)
                while(nights < 1)
                {
                    System.out.print("Error - number of nights must be at least 1\n");
                    System.out.print("Enter the number of nights for " + bookingName + " ==> ");
                    nights = inNumber.nextInt();  
                }
        
                  
		// TODO -- add the data to the array (use the new keyword and the parameterised constructor in Booking class)
                
                bookings[this.index][this.index] = new Booking(bookingName, nights);
                bookings[this.index][this.index].setBookingName(bookingName);
                bookings[this.index][this.index].setNights(nights);
                
                
                System.out.println("Details for 1 booking entered");
                displayHeading();
//                System.out.printf(bookings[numOfBookings].getBookingName() + bookings[numOfBookings].getNights());
		// TODO -- display the booking name, number of nights and the charge
                System.out.printf(bookings[index][index].toString());

		// TODO -- increment the current booking variable for the next entry
                index = index + 1;
	}
        
        
        
	private void displayHeading()
	{
		System.out.printf("%-30s%-11s%-6s\n", "Booking Name", "Nights", "Charge");
	}


	private void displayAllBookings()
	{
		
                // TODO -- check if there has been an booking entered (do this after getting the other functionality working)
                if (index <= 0)
                    System.out.print("Error - You must enter at least one booking");
        
                
		// TODO -- display all of the entries entered so far (just display the current entries not the whole array, use the current booking variable as the termination condition)
                else {
                    displayHeading();
               }
                // for loop to display only parts of the array that have data
                for (int i = 0; i < index; i++){
                System.out.print(bookings[i][i].toString()); 
                }
                             
                
                // Loop through booking array and print each entry
//                for(int sub = 0; sub > bookings.length; ++sub)
//                    System.out.print(sub);
                
        }
        
	private void displayStatistics()
	{
            
            
            
            // TODO -- check if there has been an booking entered (do this after getting the other functionality working)
            if (index <= 0){
                    System.out.print("Error - You must enter at least one booking");
                }
            
            else {

                System.out.println("Statistics for Yeppoon Cabins");
                
//		 TODO -- loop though the current entries in the array and calculate and display the statistics
                

                // Display minimum and maximum nights booked
                System.out.println(bookings[0][0].getBookingName() + " has the minimum number of " + bookings[0][0].getNights() + " nights");
                System.out.println(bookings[index - 1][index - 1].getBookingName() + " has the maximum number of " + bookings[index - 1][index - 1].getNights() + " nights");
                
                float average = nightsCount / index; // Calculate average nights booked per booking
                System.out.println("Average number of nights per booking is " + average);
                
                // Calculate total charges of all bookings
                double totalCharges = 0;
                for (int i = 0; i < index; i++){
                    double charge = bookings[i][i].calculateCharge();
                    totalCharges = totalCharges + charge;
                }
                    
                // Display sum of all charges
                System.out.println("The total charges are: " + totalCharges);
                
               
               
            }
                }
        
	private void searchBookings()
	{
		// TODO -- check if there has been an booking entered (do this after getting the other functionality working)
                if (index <= 0)
                    System.out.print("Error - You must enter at least one booking");
                else {
                    
		// TODO -- read the search key
                Scanner inText = new Scanner(System.in);
                System.out.println("Please enter the booking name ==> ");
                String searchKey = inText.nextLine();
                
                // TODO -- loop though the current entries in the array to search for the search key
                for (int i = 0; i < index; ++i)               
                    if (searchKey.equals(bookings[i][i].getBookingName())){ // match found
                        System.out.println("Booking found");
                        displayHeading();
                        System.out.printf(bookings[i][i].toString());
                    }
                    else {
                        System.out.println(searchKey + " not found");
                    }
            }
        }
		
	public static void main(String [] args)
	{
                welcomeMessage();
            
		YeppoonCabinsMenu app = new YeppoonCabinsMenu();

		app.processOrders();
                
                exitMessage();
	}

    
}
