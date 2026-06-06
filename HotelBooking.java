public class HotelBooking
{
   private int roomNum;
   private String roomType;
   private int numNights;
   private double pricePerNight;
   private double totalCost;
   
   public HotelBooking(int room, String t, double price)
   {
      roomNum = room;
      roomType = t;
      pricePerNight = price;
      numNights = 1;
      totalCost = pricePerNight*numNights;
   }
   public HotelBooking(int room, String t, double price, int nights)
   {
      roomNum = room;
      roomType = t;
      pricePerNight = price;
      numNights = nights;
      totalCost = pricePerNight*numNights;
   }
   public String getRoomType()
   {
      return roomType;
   }
   public double getPricePerNight()
   {
      return pricePerNight;
   }
   public int getNumNights()
   {
      return numNights;
   }
   public void setNumberOfNights(int n)
   {
      numNights = n;
      totalCost = pricePerNight*numNights;
   }
   public double calcTotalCost()
   {
      return totalCost;
   }
   public String toString()
   {
      return "Room Type: "+roomType+"\nPrice Per Night: $"+pricePerNight+"\nTotal Nights: "+numNights+"\nTotal Cost: $"+totalCost;
   }
}