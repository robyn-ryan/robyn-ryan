//import Scanner class to allow creation of Scanner objects and functions
import java.util.Scanner;

public class CinemaBookingTester
{  //main method
   public static void main(String[] args)
   {  
      //declare variables
      int option, numberTickets = 0, bookingNum = 0, bookingIndex = 0; 
      boolean invalidBooking = true, checkBooking = true;
      
      //create a scanner object to allow user input
      Scanner keyIn = new Scanner(System.in);
      
      //create a CinemaBooking object for each booking
      //input parameter variables for each object to call on a constructor
      CinemaBooking booking1 = new CinemaBooking(1234,"Avengers: Endgame", "7:00 PM", 2, 10.50);
      CinemaBooking booking2 = new CinemaBooking(5678, "Inception","9:30 PM", 1, 8.0);
      //declare and initialise an array for CinemaBooking objects      
      CinemaBooking[] bookings = {booking1, booking2}; 
      //while loop used to ask user if they want to check other booking
      
      while(checkBooking)
      {
         //get the user to input the booking number so the correct booking information is displayed later
         //while loop is used to prompt the user for a booking number repeatedly until a valid booking number is entered
         while (invalidBooking)
         {
            System.out.println("Please enter a booking number:");
            //stores user input in variable called bookingNum
            bookingNum = keyIn.nextInt();
          
            /*set the bookingIndex to correlate to the bookingNum for the CinemaBooking array.
            Using switch and array as there are only two pre-defined bookings. Would use a more scalable method
            if allowing for many bookings or adding new bookings */
            switch (bookingNum)
           {
               case 1234:               
                  bookingIndex = 0; 
                  invalidBooking = false;
                  break;
               case 5678:
                  bookingIndex = 1;
                  invalidBooking = false;
                  break; 
               default:
                  System.out.println("Booking does not exist. Please try again.");         
            }//end switch block
         }//end while loop
         
         //do-while loop will execute at least once and continue to execute until the user enters 0
         do
         {  
            //display numbered options for the user to choose from
            //each number will carry out a different function by calling on methods from the CinemaBooking class
            System.out.println("Please type a number for the following options:\n1 - View Movie Title"+
                                 "\n2 - View Show Time"+
                                 "\n3 - View all Booking Details"+
                                 "\n4 - Change Number of Tickets"+
                                 "\n5 - View Price Per Ticket"+
                                 "\n6 - View Total Price"+
                                 "\n0 - Exit\n");
                                 
            //stores user choice in variable called option
            //could use inputMismatchException try catch if user enters anything other than integers?
            option = keyIn.nextInt();
            
            //reads from the next line accounting for the white space
            keyIn.nextLine();
            
            //executes the code in the case depending on what number option the user selected
            switch(option)
            {
               case 1:
                  //prints movie title of the booking to screen
                  System.out.println(bookings[bookingIndex].getMovieTitle()+"\n");
                  break;
               case 2:
                  //prints show time of the booking to screen
                  System.out.println(bookings[bookingIndex].getShowTime()+"\n");
                  break;
               case 3:
                  //prints all booking details of current booking to screen
                  System.out.println(bookings[bookingIndex].toString()+"\n");
                  break;
               case 4:
                    System.out.println("Would you like to change the number of tickets? (y/n): ");
                    
                    //stores the users input as a lowercase variable called choice
                    String choice = keyIn.nextLine().toLowerCase();
                    
                    //if the user wants to change the number of tickets then they enter the new number and this is stored using the setNumTickets method
                    if (choice.equals("y"))
                    {  
                       System.out.println("How many tickets would you like to book?");
                       numberTickets = keyIn.nextInt();
                        
                       bookings[bookingIndex].setNumTickets(numberTickets);
                    }//end if block
                    //if the user chooses not to update the number of tickets then it returns to the menu options at the beginning of the loop
                    break;
               case 5:
                  //prints the current booking ticket price to screen
                  System.out.println(bookings[bookingIndex].getPricePerTicket()+"\n"); 
                  break;
              case 6:
                  //prints the total cost of the current booking to screen
                  double total = bookings[bookingIndex].calculateTotalPrice();
                  System.out.println("The total cost of the booking is €"+ String.format("%.2f",total)+"\n");
                  break;
              case 0:
                  //prints the exit statement to screen and exits the loop
                  System.out.println("Exiting booking.");
                  break;
              default:
                  //prints to screen when any number outside of 0-6 is inputted by the user and returns to the menu optiond at the beginning of the loop
                  System.out.println("Invalid option. Please choose from numbers 0 through 6.\n");
            }//end switch block
         
         }while(option != 0); //end do-while loop
         
         System.out.println("Would you like to check another booking? (y/n)");
         String check = keyIn.nextLine().toLowerCase();
         //if the user enters "n" or any other letters other than "y" then the prgoram ends, otherwise it will loop again
         if (check.equals("n") || check.equals("y") == false)
         {
            checkBooking = false;
         }  
         else
         {
            invalidBooking = true;
         }
      }// end while loop
      
   }//end main method
   
}//end class