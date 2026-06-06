public class Employee
{
   private int employeeNumber;
   private String name;
   private String jobTitle;
   private double salary;
   
   public Employee()
   {
      employeeNumber = 0;
      name = "";
      jobTitle = "";
      salary = 0.0;
   }
   public Employee(int eNum, String n, double s)
   {
      employeeNumber = eNum;
      name = n;
      salary = s;
   }
   public Employee(int eNum, String n, String j, double s)
   {
      employeeNumber = eNum;
      name = n;
      jobTitle = j;
      salary = s;
   }
   public String getSalary()
   {
      return "Salary: $"+salary;
   }
   public String getEmployeeNumber()
   {
      return "Employee Number: "+employeeNumber;
   }
   public String getJobTItle()
   {
      return "Job Title: "+jobTitle;
   }
   public String getName()
   {
      return "Name: "+name;
   }
   public void increaseSalary(double s)
   {
      salary += s;
   }
   public void decreaseSalary(double s)
   {
      salary -= s;
   }
   public double monthlyWage()
   {
      return salary/12;
   }
   public double bonus(double p)
   {
      double bonus = (salary*p)/100;
      salary += bonus;
      return bonus;
   }
   public String toString()
   {
      return "Employee #: "+employeeNumber+"\nEmployee Name: "+name+"\nJob Title: "+jobTitle+"\nSalary: $"+salary;
   }
}