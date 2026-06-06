

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//main class to manage holidays      
public class HolidayManager
{  //Scanner to read user input
   static Scanner keyIn = new Scanner(System.in);
   
   
   //File name to store serialized holiday data
   static final String holiday_data = "holidays.dat";
   //List to store holiday objects
   static ArrayList<Holiday> packages = new ArrayList<>();
   //User menu selection
   static int option;
   //main method
   public static void main (String[] args) throws IOException, ClassNotFoundException
   {  //load saved data from holiday.dat file
      loadFromFile();
      
       do //display the menu to console until user chooses to exit
      {
         System.out.println("\n-------- Holiday Menu --------\n1 - View All Holidays"+
                                 "\n2 - View holiday(s) within a given price range"+
                                 "\n3 - Display Details of Cheapest Holiday"+
                                 "\n4 - Remove a Holiday"+
                                 "\n5 - Update Holiday Details"+
                                 "\n6 - Enter New Holiday"+
                                 "\n0 - Exit\n");
         System.out.print("Enter an option number: ");
         //read and validate user input
         try
         {
            option = Integer.parseInt(keyIn.nextLine());
         }
         catch(NumberFormatException e)
         {
            System.out.println("Please enter a number between 0 and 6 only.");
            continue;
         }
         
         //execute case based on user selection
         switch(option)
         {
           case 1:
              DisplayAllHolidays();
              break;
           case 2:
              displayPriceRange();
              break;
           case 3:
              displayCheapest();
              break;
           case 4:
              removeHoliday();
              break;
           case 5:
              updateHoliday();
              break;
            case 6:
              addHoliday();
              break;
           case 0:
              saveToFile(); //save any changes before exiting the program
              System.out.println("Exiting system.");
              break;           
           default:
              System.out.println("Not a valid option. Please choose a number between 0 and 6.");     
         }
      
      }while (option != 0);
   }//end main method
      //method to load holiday data from file, if it exists
      public static void loadFromFile()
      {
         try
         {  //create file to represent the file holiday.dat
            File file = new File(holiday_data);
            //check if holiday.dat exists so doesn't throw FileNotFoundException
            if (file.exists())
            {  //opens input stream, deserializes objects, reads objects in and assigns to package list
               ObjectInputStream in = new ObjectInputStream(new FileInputStream(holiday_data));
               packages = (ArrayList<Holiday>) in.readObject();
               in.close();
               System.out.println("Loaded holidays.");
               
               int maxHolNo =  0;
               for (Holiday h : packages)
               {  //if larger holiday number found then update max value
                  if(h.getHolidayNo() > maxHolNo)
                  {
                     maxHolNo = h.getHolidayNo();
                  }
               }
               //set the holiday number to make it unique each time the program runs
               Holiday.setNextHolidayNo(maxHolNo + 1);
            }
            
         }//message prints if hoilidays.dat file not found
         catch(IOException | ClassNotFoundException e)
         {
            System.out.println("Loading holidays failed.");
         }
      
      }
      //method to save holiday packages to file
      public static void saveToFile()
      {
         try
         {  //serialize and write the packages list to file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("holidays.dat"));
            out.writeObject(packages);
            out.close();
         }
         catch(IOException e)
         {
            System.out.println("Saving holidays failed.");
         }
      }
      //method to display all holidays stored in holidays.dat
      public static void DisplayAllHolidays() 
      { //if the list is empty print the statement to console
        if(packages.isEmpty()) 
        {
            System.out.println("No holidays to display.");
        }
        else //otherwise print all holidays to console
        {
            System.out.println("All Holidays:");
            for (Holiday h : packages) 
            {
                System.out.println(h);
            }

        } 
        
    }
    //method to display holidays in a given price range
    public static void displayPriceRange()
    {
      double minPrice = 0, maxPrice = 0;
      //read and validate price range from user input
      try
      {
         System.out.print("Enter minimum price: €");
         minPrice = Double.parseDouble(keyIn.nextLine());
         
         System.out.print("Enter maximum price: €");
         maxPrice = Double.parseDouble(keyIn.nextLine());
      
         if (minPrice > maxPrice)
         {
            System.out.println("Minimum price cannot be greater than maximum price");
            return;
         }
      }
      catch (NumberFormatException e)
      {
         System.out.println("Please enter only positive decimal numbers.");
         return;
      }
      
      boolean found = false;
      //loop through holidays in packages and print the holidays in range
      for (Holiday h : packages)
      {
         if(h.getCost() >= minPrice && h.getCost() <= maxPrice)
         {
            System.out.println(h);
            found = true;
         }
      }
      if (!found)
         {
            System.out.println("No holidays in this price range.");
         }
    }
    //method to find and display the cheapest holiday
    public static void displayCheapest()
    {
      if (packages.isEmpty())
      {
         System.out.println("No holidays to display");
         return;
      }
      //compare holiday prices starting with the first holiday
      Holiday c = packages.get(0); 
      for (Holiday h : packages)
      {  //if cheaper holiday then update value c
         if(h.getCost() < c.getCost())
         {
            c = h;
         }
      }
      System.out.println("Cheapest Holiday:\n" + c);
    }
    //method to remove a holiday using the holiday number
    public static void removeHoliday()
    {
      int holNo;
      
      try
      {  //ask the user to enter a holiday number to remove
         System.out.print("Enter the holiday number of the holiday you would like to remove: ");
         holNo = Integer.parseInt(keyIn.nextLine());
      }
      catch (NumberFormatException e)
      {
         System.out.println("Invalid holiday. Please enter an integer only.");
         return;
      }
      //loop through the packages list and remove matching holiday number
      for(int i = 0; i < packages.size(); i++)
      {
         if (packages.get(i).getHolidayNo() == holNo)
         {
            packages.remove(i);
            System.out.println("Holiday removed");
            return;
         }
      }
      System.out.println("There is no holiday matching this holiday number."); 
    }
    //method to update holiday details using the holiday number
    public static void updateHoliday()
    { 
      int holNo;
      try //ask the user to enter holiday number
      {
          System.out.println("Enter the holiday number of the holiday you would like to update:");
          holNo = Integer.parseInt(keyIn.nextLine());
      }
      catch(NumberFormatException e)
      {
         System.out.println("Invalid holiday. Please enter an integer only.");
         return;
      }
      //loop through packages list until it matches the holiday number input by the user  
      for(Holiday h : packages)
      {  //prompt the user to update details
         if (h.getHolidayNo() == holNo)
         {
            System.out.print("Enter new destination: ");
            h.setDestination(keyIn.nextLine());
            
            System.out.print("Enter new departure airport: ");
            h.setDepartureAirport(keyIn.nextLine());
            //take in user input and validate the data type
            try
            {
               System.out.print("Enter new duration: ");
               h.setDuration(Integer.parseInt(keyIn.nextLine()));
            
               System.out.print("Enter new cost: ");
               h.setCost(Double.parseDouble(keyIn.nextLine()));
            }
            catch(NumberFormatException e)
            {
               System.out.println("Invalid input for duration or cost. Update cancelled.");
               return;
            }
            
            System.out.println("Holiday updated successfully");
            return;
         }
      }
      System.out.println("There is no holiday matching this holiday number.");
    }
    
    public static void addHoliday()
    {   
      String destination, deptAirport;
      int duration; double cost;     
    
      System.out.print("Enter a destination: ");
      destination = (keyIn.nextLine());
      
      System.out.print("Enter a departure airport: ");
      deptAirport = (keyIn.nextLine());
      //take in user input and validate the data type
      try
      {
         System.out.print("Enter a duration: ");
         duration = Integer.parseInt(keyIn.nextLine());
      
         System.out.print("Enter a cost: ");
         cost = Double.parseDouble(keyIn.nextLine());
      }
      catch(NumberFormatException e)
      {
         System.out.println("Invalid input for duration or cost. Update cancelled.");
         return;
      }
      Holiday h = new Holiday (destination, deptAirport, duration, cost);
      packages.add(h);
      System.out.println("Holiday added successfully");
      return;
   }
   
      
   
}     