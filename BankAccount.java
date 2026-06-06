//CLASSES AND OBJECTS
public class BankAccount
{ //instance variables
   private String accountName;
   private double balance;
   //constructor
   public BankAccount()
   {
      accountName = "";
      balance = 0.0;
   }
   //accessor method for accountName 
   public String getAccountName()
   {
      return accountName;
   }
   //mutator method for accountName 
   public void setAccountName(String name)
   {
      accountName = name;
   }
   //accessor method for balance
   public double getBalance()
   {
      return balance;
   }
   //deposit method to increase balance by amount
   public void deposit(double amount)
   {
      balance = balance + amount;
   }
   //withdraw method to decrease balance by amount
   public void withdrawMoney(double amount)
   {
      balance = balance - amount;
   }
}//end class

