import java.util.Scanner;

public class HotelTester
{    
   public static void main(String[] args)
   {  
      int option;
      int numberNights;
      
      Scanner keyIn = new Scanner(System.in);
      
      HotelBooking booking1 = new HotelBooking(2220, "Family Room", 120.00, 3);
      
      HotelBooking booking2 = new HotelBooking(1001,"Single Room", 70.00);
      
      do
      {
         System.out.println("Please type a number for the following options:\n1. View Room Type\n2. View all Booking Details\n3. Change Number of Nights\n4. View Price Per Night\n5.View Total Price");
         option = keyIn.nextInt();
         keyIn.nextLine();
         
         if (option == 1)
         {
            System.out.println("Room Type: "+booking1.getRoomType());
         }
         else if (option == 2)
         {
            System.out.println("Booking Details: \n"+booking1.toString());
         }
         else if (option == 3)
         {
            System.out.println("Number of nights: "+booking1.getNumNights()+"\nWould you like to change the number of nights? (y/n): ");
            String choice = keyIn.nextLine();
            
            if (choice.equals("y"))
            {
               System.out.println("How many nights would you like to stay? ");
               numberNights = keyIn.nextInt();
               
               booking1.setNumberOfNights(numberNights);
            }

         }
         else if (option == 4)
         {
            System.out.println("Price per night: $"+booking1.getPricePerNight());
         }
         else if (option == 5)
         {
            System.out.println("Total price: $"+booking1.calcTotalCost());
         }
         else if (option == 0)
         {
            System.out.println("Thank you. Goodbye!");
         }
         else
         {
            System.out.println("invalid option. Please try again");
         }  
         
      }while ( option != 0);
   }
}