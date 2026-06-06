public class DogTester
{
   public static void main(String[] args)
   {
      Dog firstDog = new Dog();
      
      firstDog.setName("Holly");
      firstDog.setBreed("King Charles Cavalier");
      firstDog.setHeight(14);
      
      System.out.print(firstDog.toString()+ "\nBark type: "+firstDog.bark());
   }  
}