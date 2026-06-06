public class BankAccountTester
{
   public static void main(String[] args)
   {
      BankAccount myAcc = new BankAccount();
      
      
      myAcc.setAccountName("Kaida Thunderpaws");
      myAcc.deposit(2000.00);
      System.out.print(myAcc.getBalance());
   }
}