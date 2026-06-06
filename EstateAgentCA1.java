/* Assignment 1 Property Estate Agents 
Author: Robyn Ryan	Student Number: L00188388 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import java.util.ArrayList;

//class created and using inheritance to use JavaFx
public class EstateAgentCA1 extends Application
{  
   
   
   //create array list for Property objects 
   ArrayList<Property> listings = new ArrayList<>();
   
   //create text boxes and text area
   TextField txtStreet = new TextField();
   TextField txtTown = new TextField();
   TextField txtCounty = new TextField();
   TextField txtBeds = new TextField();
   TextField txtReceptions = new TextField();
   TextField txtBaths = new TextField();
   TextField txtType = new TextField();
   TextField txtPrice = new TextField();
   TextField txtPropNo = new TextField();
   TextField txtKeyword = new TextField();
   TextArea display = new TextArea();
   
   //create a method to clear all data fields simultaneously
   public void clearFields()
   {
      txtStreet.clear();
      txtTown.clear();
      txtCounty.clear();
      txtBeds.clear();
      txtReceptions.clear();
      txtBaths.clear();
      txtType.clear();
      txtPrice.clear();
      
   }
   //create a method to add a property to the listings array
   public void addProperty()
   {
      //if any listed text fields are empty, display the message to the text area and don't execute any code below within the method
      if (txtStreet.getText().isEmpty() || txtTown.getText().isEmpty() || txtCounty.getText().isEmpty() || txtBeds.getText().isEmpty() || txtReceptions.getText().isEmpty() || 
            txtBaths.getText().isEmpty() || txtPrice.getText().isEmpty() || txtType.getText().isEmpty())
      {
         display.setText("Please enter information in all property detail fields.");
         
         return;
         
      }
                 
            try
            {
               //declare number variables and convert text input to number datatypes
               double price = Double.parseDouble(txtPrice.getText());
               int beds = Integer.parseInt(txtBeds.getText());
               int baths = Integer.parseInt(txtBaths.getText());
               int receptions = Integer.parseInt(txtReceptions.getText());
               //set a condition to accept a specified price range
               if (price < 50000 || price > 5000000)
               {
                  display.setText("Please enter a price within the range of 50,000 to 5,000,000");
                  
                  return; //don't continue adding property out of price range
               }
               //set condition for number of beds, baths and receptions allowed
               if (beds < 1 || beds > 10 || receptions < 1 || receptions > 10 || baths < 1 || baths > 10)
               {
                  display.setText("Please enter positive numbers only for beds, baths and receptions, and price.");
                  
                  return; //don't continue adding property if condition not met
               }

               //store user text entries as strings
               String street = txtStreet.getText();
               String town = txtTown.getText();
               String county = txtCounty.getText();
               String type = txtType.getText();
               
              //create property object p with input parameters
              Property p = new Property(street, town, county, beds, baths, receptions, price, type);
              //add property p to the listings array list
              listings.add(p);
              //display the text in the text area
              display.setText("New property added!");
              //clear all text fields
              clearFields();
              
           } 
           catch (NumberFormatException e) //displays the text to the text area if the user inputs anything other than digits
           {
              display.setText("Please enter numbers only for Beds, Baths, Receptions and Price."); 
           }
   }
   //method to view all property listings
   public void viewProperties()
   {
      //if the array list is empty, display the message to the text area
      if (listings.isEmpty())
      {
         display.setText("There are no listings available.");
      }
      else //otherwise print all listings to the text area
      {
         String allProps = ("All Properties:\n");
         //loop through all elements in listings 
         for(int i = 0; i <listings.size(); i++)
         {  //add element details to a string by calling the toString method from the properties class
            allProps += listings.get(i).toString()+"\n";
         }
         
         display.setText(allProps);
      }
     
   }
   //method to remove a property from the listings
   public void removeProperty()
   {  //store user text input as string
      String removeProp = txtPropNo.getText();
      //if the text field is empty display the message to the text area and don't execute the rest of the code
      if(removeProp.isEmpty())
      {
         display.setText("Please enter a property number to remove.");
         
         return;
      }
      
      try
      {  //store user input text as integer
         int propNo = Integer.parseInt(removeProp);
         //loop through all elements in listings
         for(int i = 0; i < listings.size(); i++)
         {  //if user text matches a property number in the listings, remove the property
            //and display the message to the text area then clear the property no text field
            
            if(propNo == listings.get(i).viewPropNo())
            {
               listings.remove(i);
               display.setText("Property number "+ propNo + " removed.");
               txtPropNo.clear();
               return; //don't execute any code below in this method
            }
         }
         //displays message when user input does not match a property number in the listings
         display.setText("Property number "+ propNo +" not found.");
         txtPropNo.clear();
      }
      catch (NumberFormatException e) //displays the text to the text area if the user inputs anything other than digits
      {
         display.setText("Please enter an integer only.");
      }
     
   }
   //method to update the price of a property listing
   public void updatePrice()
   {
      //stores user input text as strings
      String propNoText = txtPropNo.getText();
      String priceText = txtPrice.getText();
      //if either text field is empty then display the message in the text area
      if(propNoText.isEmpty() || priceText.isEmpty())
      {
         display.setText("Please enter a property number and a new price to update the price.");
         
         return; //don't execute any code below in this method
      }
      
      try
      {  //store user input text as integers
         int propNo = Integer.parseInt(propNoText);
         int newPrice = Integer.parseInt(txtPrice.getText());
         //if user price entered is either below or above these values then display the message
         if(newPrice < 50000 || newPrice > 5000000)
         {
            display.setText("Please enter a price within the range of 50,000 to 5,000,000");
            
            return;//don't execute any code below in this method
         }
         //loop through all properties in listings
         for(int i = 0; i < listings.size(); i++)
         {  //if the user entry matches the property number then change the price
            if(propNo == listings.get(i).viewPropNo())
            {  //set the price at index i to the new price provided by the user
               listings.get(i).setPrice(newPrice);
               //let the user know this has been changed
               display.setText("Property number "+ propNo + " price has been updated.");
               //clear both fields
               txtPropNo.clear();
               txtPrice.clear();
               return;//don't execute any code below in this method
            }
         }
         //displays message when user input does not match a property number in the listings
         display.setText("Property number "+ propNo +" not found.");
         
      }
      catch (NumberFormatException e) //displays the text if the user inputs anything other than digits
      {
         display.setText("Please enter numbers only for both property number and price.");
      }
      //clears both fields
      txtPropNo.clear();
      txtPrice.clear();
   }
   //method to calculate the cost of a mortgage for a property in the listings
   public void calculateMortgage()
   {  //stores unser input property number as a string
      String propNoText = txtPropNo.getText();
   
      //dipslays the message if the property number field is empty
      if (propNoText.isEmpty())
      {
         display.setText("Please enter a property number to calculate mortgage repayments for that property.");
         
         return; //don't execute code below this within the method
      }
      try
      {  //create variables to store the mortgage data and user input property number
         double interestVar = 4.75, interestFixed = 3.45, propPrice, loanAmt, mortgagePaymentsV, mortgagePaymentsTotal, totalInterest;
         int propNo = Integer.parseInt(propNoText);
         int fixedYrs = 4;
         int totalYrs = 30;
          //loop through all properties in the listings to find the property price that corresponds to the property number
          for(int i = 0; i < listings.size(); i++)
            {   
               if(propNo == listings.get(i).viewPropNo())
               {  //store the property price at the index i
                  propPrice = listings.get(i).viewPrice();
                  //calculate the loan as 90% of the property price
                  loanAmt = propPrice * 0.9;
                  //calculate fixed interest rate and term of the loan in terms of months
                  double monthlyInterest = interestFixed/100/12;
                  int fixedMths = fixedYrs * 12;
                  //calculate monthly payments for a fixed rate period
                  double mortgagePaymentsF = loanAmt * (monthlyInterest * Math.pow(1 + monthlyInterest, totalYrs * 12)) / (Math.pow(1 + monthlyInterest, totalYrs * 12) - 1);
                  //calculate the remaining balance after the fixed rate term
                  double remainingLoanBalance = loanAmt * Math.pow(1 + monthlyInterest, fixedMths) - mortgagePaymentsF * (Math.pow(1 + monthlyInterest, fixedMths)- 1)/ monthlyInterest;
                  //calculate the variable interest rate and term of the loan in terms of months
                  int varMths = (totalYrs - fixedYrs) * 12;
                  monthlyInterest = interestVar/100/12;
                  //calculate the monthly payments for the variable rate period
                  mortgagePaymentsV = remainingLoanBalance * (monthlyInterest * Math.pow(1 + monthlyInterest, varMths)) / (Math.pow(1 + monthlyInterest, varMths) - 1);
                  //calculate the total cost of the mortgage loan for the full term
                  mortgagePaymentsTotal = (mortgagePaymentsV * varMths)+ (mortgagePaymentsF * fixedMths);
                  //calculate total interest to pay over the full term
                  totalInterest = mortgagePaymentsTotal - loanAmt;
                  //display the results to the text area
                  display.setText("Based on a 4 year fixed rate mortgage for a term of 30 years and a loan for 90% of the value of the property:\nLoan Amount: €"
                  +String.format("%.2f",loanAmt)+"\nFixed Interest Rate: "+interestFixed+"%\nVariable Interest Rate: "+interestVar+"%\nMonthly Repayments Fixed Term: €"
                  +String.format("%.2f",mortgagePaymentsF)+"\nMonthly Repayments Remainder of Term: €"+String.format("%.2f",mortgagePaymentsV)+"\nTotal Amount Repayable €"
                  +String.format("%.2f",mortgagePaymentsTotal)+"\nTotal Interest Payable: €"+String.format("%.2f",totalInterest));
                  txtPropNo.clear();
                  return; //don't execute any code below within this method
                  
               }
            }
            //displays the message when uer input property number does not match any listings              
            display.setText("Property number "+ propNo +" not found.");
            
      }
      catch (NumberFormatException e) //displays the text if the user inputs anything other than digits
      {
         display.setText("Please enter numbers only for property number.");
      }
      
      txtPropNo.clear();  
      
   }
   
   public void sortByPrice()
   {
      //loop through all the listings in the array list starting at index 0
      for(int i = 0; i < listings.size(); i++)
      {  //create a variable to store the index for the property with the highest price 
         int indexMax = i;
         //loop through the listings in the array list starting at index 1
         //use nested loop to compare elements at two different indexes
         for(int n = i + 1; n < listings.size(); n++)
         {
            //if statment to compare if price at index n is greater than price at index i
            if(listings.get(n).viewPrice() > listings.get(i).viewPrice())
            {
               //store the index of the property with the highest price
               indexMax = n;
            }
            
         }
         //create temporary property object and store the current element in the loop
         Property p = listings.get(i);
         //replace the current element with the element that has the max price property
         listings.set(i, listings.get(indexMax));
         //move the original property into the position the property with the higest value was in
         listings.set(indexMax, p);
      }
   }
   //method to check every position in a string and compare to the keyword entry
   public boolean matchString(String check, String keyword)
   {
      //store strings as all lowercase
      check = check.toLowerCase();
      keyword = keyword.toLowerCase();
      //create int to store length of each string
      int checkLength = check.length();
      int keywordLength = keyword.length();
      //if keyword length is longer than current string length then end the method
      if (keywordLength > checkLength)
      {
         return false;
      }
      //loops through characters in a string 
      for(int i = 0; i <= checkLength - keywordLength; i++)
      {
         boolean match = true;
         //loops through each character in the keyword
         for(int n = 0; n < keywordLength; n++)
         {
            if(check.charAt(i + n) != keyword.charAt(n))
            {
               match = false;
               break; //go to next statement
            }
         }
         //if the keyword is found then continue
         if (match)
         {
            return true;
         }
      }
      //keyword not found
      return false;
   }
   //method to search for keywords in the property listings
   public void searchKeyword()
   {
      //store the user input text as a string
      String keyword = txtKeyword.getText().toLowerCase();
      //display the message if the keyword text field is empty
      if (keyword.isEmpty()) 
      {
         display.setText("Please enter a keyword to search the property listings.");
         
         return; //don't execute any code below in this method
      }
      //create a string to store keyword search results
      String searchResults = "All Search Results:\n";
      //create a boolean to track if a keyword match has been found
      boolean found = false;
      //loop through all listings
      for(Property p : listings)
      {  
         String priceStr = String.format("%.2f", p.viewPrice());
         //if the keyword is found in any of the listed data, then add the listing details
         //to the search results string
         
         if (matchString(p.viewStreet(), keyword) ||
         matchString(p.viewTown(), keyword) ||
         matchString(p.viewCounty(), keyword) ||
         matchString(p.viewPropertyType(), keyword) ||
         matchString(priceStr, keyword))
         {
            searchResults += p.toString() + "\n";
            
            found = true;
         }
      }
      if (found) //only executes if a keyword match has been found
      {
         display.setText(searchResults);
      }
      else //displays the message if the boolean found = false
      {
         display.setText("No property results found for the keyword search: "+ keyword);
      }
      //clear the keyword text field
      txtKeyword.clear(); 
   }
   //method to store the gui controls and layouts in the main container stage
   public void start(Stage stage)
   
   {  
      //create objects to add to an array for each property
      Property p1 = new Property("85 Oldtown Woods", "Celbridge", "Kildare", 3, 3, 1, 450000.00, "Semi-Detached");
      Property p2 = new Property("1 Ballyadam", "Kilmuckridge", "Wexford", 4, 3, 2, 327000.00, "Detached");
   
      //add listings
      listings.add(p1);
      listings.add(p2);
      //configure the text fields and text area
      txtStreet.setMaxWidth(300);
      txtTown.setMaxWidth(300);
      txtCounty.setMaxWidth(300);
      txtBeds.setMaxWidth(80);
      txtReceptions.setMaxWidth(80);
      txtBaths.setMaxWidth(80);
      txtType.setMaxWidth(300);
      txtPrice.setMaxWidth(300);
      txtPropNo.setMaxWidth(50);
      txtKeyword.setMaxWidth(300);
      display.setMaxWidth(1000);
      display.setMaxHeight(300);
      display.setWrapText(true);
      display.setEditable(false);
      
      //create labels with text 
      Label enterDetails = new Label("******************** Enter Property Details ********************");
      Label lblStreet = new Label("Street ");
      Label lblTown = new Label("Town ");
      Label lblCounty = new Label("County ");
      Label lblBeds = new Label("Beds ");
      Label lblReceptions = new Label("Receptions ");
      Label lblBaths = new Label("Bath ");
      Label lblType = new Label("Type ");
      Label lblPrice = new Label("Price € ");
      Label propFunctions = new Label("******************** Property Functions ********************");
      Label addFunctions = new Label("******************** Additional Functions ********************");
      Label lblPropNo = new Label("Property Number");
      Label lblKeyword = new Label("Enter Keyword: ");
      //create buttons
      Button btnAddProp = new Button("Add Property");
      Button btnViewProps = new Button("View All Properties");
      Button btnRemoveProp = new Button("Remove Property");
      Button btnUpdatePrice = new Button("Update Property Price");
 
      Button btnSortBy = new Button("Sort By Price");
      Button btnMortgageCalc = new Button("Calculate Mortgage");
      Button btnSearchKeyword = new Button("Search Keyword");
      
      //action on button press calls methods created
      btnAddProp.setOnAction(e -> { addProperty(); });
      
      btnViewProps.setOnAction(e -> { viewProperties(); });
      
      btnRemoveProp.setOnAction(e -> { removeProperty(); });
      
      btnUpdatePrice.setOnAction(e -> { updatePrice(); });
      
      btnMortgageCalc.setOnAction(e -> { calculateMortgage(); });
      
      btnSortBy.setOnAction(e -> { sortByPrice(); viewProperties();});
      
      btnSearchKeyword.setOnAction(e -> { searchKeyword(); });
      
      //create a layout using hbox to order the gui controls in a horizontal line
      HBox input1 = new HBox(10);
      input1.getChildren().addAll(lblStreet, txtStreet, lblTown, txtTown, lblCounty, txtCounty);
      input1.setAlignment(Pos.CENTER);
      HBox input2 = new HBox(10);
      input2.getChildren().addAll(lblBeds, txtBeds, lblReceptions, txtReceptions, lblBaths, txtBaths, lblType, txtType, lblPrice, txtPrice);
      input2.setAlignment(Pos.CENTER);
      HBox input4 = new HBox(5);
      input4.getChildren().addAll(lblPropNo, txtPropNo);
      input4.setAlignment(Pos.CENTER);
      HBox input3 = new HBox(10);
      input3.getChildren().addAll(btnAddProp, btnViewProps, btnUpdatePrice, btnRemoveProp);
      input3.setAlignment(Pos.CENTER);
      HBox input5 = new HBox(5);
      input5.getChildren().addAll(btnSortBy, btnMortgageCalc);
      input5.setAlignment(Pos.CENTER);
      HBox input6 = new HBox(5);
      input6.getChildren().addAll(lblKeyword, txtKeyword, btnSearchKeyword);
      input6.setAlignment(Pos.CENTER);
      //create a layout using VBox
      VBox root = new VBox(10);
      //set the position of the controls
      root.setAlignment(Pos.CENTER);
      //add the controls to the layout
      root.getChildren().addAll(enterDetails, input1, input2, propFunctions, input4, input3, display, addFunctions, input5, input6);
      //Add VBox to the scene with width 1000 pixels and height of 600 pixels
      Scene scene = new Scene(root,1200,600);
      
      //add scene to the stage
      stage.setScene(scene);
      //set the title to appear on the stage
      stage.setTitle("Estate Agents");
      //show the stage
      stage.show();
   }
   //main method
   public static void main(String []args)
   {
      //calls application launch method and passes any arguments through it
      launch(args);
   }// end main method

}//end class