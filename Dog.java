public class Dog
{  //instance variables
   private String name;
   private String breed;
   private int heightInches;
   
   //constructor
   public Dog()
   {
      name = "";
      breed = "";
   }
   //accessor method for name
   public String getName()
   {
      return name;
   }
   //mutator method for name
   public void setName(String n)
   {
      name = n;
   }
   //accessor method for breed
   public String getBreed()
   {
      return breed;
   }
   //mutator method for breed
   public void setBreed(String b)
   {
      breed = b;
   }
   //accessor method for heightInches
   public int getHeight()
   {
      return heightInches;
   }
   //mutator method for heightInches
   public void setHeight(int h)
   {
      if (h >= 1 && h <= 40)
      {
         heightInches = h;
      }
      else
      {
         System.out.println("Invalid height");
      }
   }
   //toString method
   public String toString()
   {
      return "Name: "+name+"\nBreed: "+breed+"\nHeight: "+heightInches+" inches";
   }
   public String bark()
   {
      if(heightInches >= 30)
      {
         return "ruff, ruff";
      }
      else if (heightInches < 30)
      {
         return "bow, wow";
      }
      else
      {
         return "yap, yap";
      }
     
   }
      
}