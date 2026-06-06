public class Circle
{
   private final double pi;
   private double radius;
   
   
   public Circle()
   {
      pi = 3.14;
      radius = 0.0;
      
   }
   public void setRadius(double r)
   {
      radius = r;
   }
   public double getRadius()
   {
      return radius;
   }
   public double Circumference()
   {
      return 2*pi*radius; 
   }
   public double Area()
   {
      return pi*radius*radius;
   }
   public String toString()
   {
      return "Circumference: "+Circumference()+"\nArea: "+Area();
   }
}