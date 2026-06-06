/*CA1 - Fruit Harvest
Author: Robyn Ryan 
Date: 25/01/2025
A program to calculate the value of fruit a user harvests */

import java.util.Scanner; //imports scanner class to allow creation of scanner objects and functions
import java.util.InputMismatchException; //same as above for Input mismatch exceptions

public class CA1FruitHarvest
{  
   //main method
   public static void main(String[] args)
   {  
      //Declare variables
      String another_picker = "Y";
      int top_picker = 0, num_baskets = 0, s_baskets = 0, m_baskets = 0, l_baskets = 0, picker_counter = 0, total_s_baskets= 0, total_m_baskets = 0, total_l_baskets = 0;
      double total_due = 0, total_paid = 0, top_earner = 0, bonus = 0;
      
      // Repeats while another picker equals yes is true
      while (another_picker.equals("Y"))
      {  
         //Set baskets and total made to 0 so the values do not accumulate each iteration of the loop
         s_baskets = 0; m_baskets = 0; l_baskets = 0; total_due = 0;
         //Increment the picker number each iteration so the picker is assigned a unique ID
         picker_counter++;
         //Displays current picker ID 
         System.out.println("Picker # "+picker_counter+":");
         //Create instance of scanner class to allow user input
         Scanner userInput = new Scanner(System.in);
         //Declare a boolean called notInvalid and set to true 
         
         
         //catch exceptions resulting from user inputting anything other than an integer, informs the user and prompts them to re-enter an integer
         //continues on a loop until the boolean notInvalid is set to false, which means the user has entered an integer.
         boolean notInvalid = true;
         do
         {
           try
           {
               System.out.print("   How many baskets of fruit did you collect?: ");
               //stores scanner userInput as an integer representing number of baskets collected
               num_baskets = userInput.nextInt();
               //reads from the next line accounting for the white space
               userInput.nextLine();
               //stops another iteration of the do while loop
               notInvalid = false;
           }
           catch(InputMismatchException java_error)
           {
               System.out.println("Please enter an integer only.");
               userInput.nextLine();
           
           }//end try catch block
         
         }while (notInvalid);//end do while loop
         
         //asks the user the size of each basket based on the number of baskets they collected   
         for (int basket_counter = 1; basket_counter <= num_baskets; basket_counter++)
         {
            System.out.print("Enter the size of the basket # "+basket_counter+" [S, M or L]: ");
            //converts user input to uppercase 
            String basket_size = userInput.nextLine().toUpperCase();
            
            //switch statement reads basket size and executes the code only under that case
            switch (basket_size)
            {
               case "S":
                  //keeps track of small baskets for this iteration
                  s_baskets++;
                  //set value of small baskets at 6 and add to total due
                  total_due += 6;
                  break;
               case "M":
                  m_baskets++;
                  total_due += 8;
                  break;
               case "L":
                  l_baskets++;
                  total_due += 12;
                  break;
               default:
                  //catches user input error for basket size, prompts user to re-enter and reduces the basket counter to repeat the iteration
                  System.out.println("Invalid basket size entered. Enter S, M, or L.");
                  basket_counter--;
            
            }//end switch block     
            
         }//end for loop
         
         //calculating bonuses for earnings over 40 first and then over 30 and adding them to the total due
         if (total_due > 40.00)
         {   
            bonus = total_due*0.25;
            System.out.print("Over $40 so 25% bonus added: $"+String.format("%.2f",bonus));
            total_due*= 1.25;
            
         }
         else if (total_due > 30.00)
         {
            bonus = total_due*0.15;
            System.out.print("Over $30 so 15% bonus added: $"+String.format("%.2f",bonus));
            total_due*= 1.15;
            
         }//end if else block
         
         //Displays the information with the variable values to the screen for the current iteration
         System.out.println("\n************************************\n\n"+
         "Picker #"+picker_counter+
         ":\nTotal baskets collected: "+num_baskets+
         "\nSmall baskets: "+s_baskets+
         "\nMedium baskets: "+m_baskets+
         "\nLarge baskets: "+l_baskets+
         "\nTotal amount due: $"+String.format("%.2f",total_due)+
         "\n************************************\n");
         
         //tracks the highest earner by comparing iterations that came before
         if (total_due > top_earner)
         {
            top_earner = total_due;
            top_picker = picker_counter;  
            
         }//end if block
            
         //keeps track of the total earned by all pickers and total baskets of each size over every iteration
         total_paid += total_due;
         total_s_baskets += s_baskets;
         total_m_baskets += m_baskets;
         total_l_baskets += l_baskets;
         
         
         //asks the user if they want to enter details for another picker then either continues the loop if yes or prints grand totals and breaks out of loop.
         //do while and switch statement used to catch user inputting anything other than y or n, informs the user and prompts them to re-enter y or n
         boolean wrongLetter = true;
         do
         {   
            System.out.print("Process another picker? (Y/N): ");
            another_picker = userInput.nextLine().toUpperCase();
            
            switch (another_picker)
            {
               case "N":
                  System.out.print("\n************************************\nTotal number of fruit pickers: "+picker_counter+
                  "\nTotal small baskets: "+total_s_baskets+
                  "\nTotal medium baskets: "+total_m_baskets+
                  "\nTotal large baskets: "+total_l_baskets+
                  "\nTotal amount paid out: "+String.format("%.2f",total_paid)+
                  "\nTop Picker: Picker "+top_picker+" with $"+String.format("%.2f",top_earner)+
                  "\n************************************");
                  wrongLetter = false;
                  break;
               case "Y":
                  System.out.println("\n************************************");
                  wrongLetter = false;
                  break;
               default:
                  System.out.print("Please enter either Y or N\n");
            }
                  
         }while(wrongLetter);//end do while loop        
         
      }//end while loop
      
   }//end main method
   
}//end class