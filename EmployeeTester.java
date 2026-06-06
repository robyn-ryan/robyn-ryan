import java.util.Scanner;

public class EmployeeTester
{
   public static void main(String[] args)
   {
      Employee emp1 = new Employee();
      
      System.out.println(emp1.toString());
      
      Scanner keyIn = new Scanner(System.in);
      System.out.print("Enter employee number: ");
      int eNum = keyIn.nextInt();
      keyIn.nextLine();
      System.out.print("\nEnter name: ");
      String n = keyIn.nextLine();
      System.out.print("\nEnter job title: ");
      String j = keyIn.nextLine();
      System.out.print("\nEnter salary: ");
      double s = keyIn.nextDouble();
     
      Employee emp3 = new Employee(eNum,n,j,s);
      
      System.out.println(emp3.toString());
      
      emp3.decreaseSalary(3000);
      System.out.println(emp3.getSalary());
      
      System.out.println(emp3.monthlyWage());
      
      System.out.println(emp3.bonus(10)+"\n"+ emp3.getSalary());
   }
}