public class CinemaBooking
{
   //private instance variables only accessible through methods in CinemaBooking class
   private  int bookingID;
   private String movieTitle;
   private String showTime;
   private int numTickets;
   private double pricePerTicket;
  
   //constructors
   //constructor #1 - default
   public CinemaBooking()
   {
      bookingID = 0;
      movieTitle = "";
      showTime = "";
      numTickets = 1;
      pricePerTicket = 0.0;
   }
   //constructor #2 with input parameters
   public CinemaBooking(int bookingID, String movieTitle, String showTime, double pricePerTicket)
   {
      this.bookingID = bookingID;
      this.movieTitle = movieTitle;
      this.showTime = showTime;
      numTickets = 1;
      this.pricePerTicket = pricePerTicket;
   }
   //constructor #3 with input parameters
   public CinemaBooking(int bookingID, String movieTitle, String showTime, int numTickets, double pricePerTicket)
   {
      this.bookingID = bookingID;
      this.movieTitle = movieTitle;
      this.showTime = showTime;
      this.numTickets = numTickets;
      this.pricePerTicket = pricePerTicket;
   }
   //accessor method returns movie title as a String
   public String getMovieTitle()
   {
      return "Movie Title: "+ movieTitle;
   }
   //accessor method returns show time as a String
   public String getShowTime()
   {
      return "Show time: "+ showTime;
   }
   //mutator method to set the movie title needs 1 String type input parameter
   //Isn't used in the tester
   public void setMovieTitle(String movieTitle)
   { 
      this.movieTitle = movieTitle;
   }
   //mutator method to set the show time needs 1 String type input parameter
   //Isn't used in the tester
   public void setShowTime(String showTime)
   {  
      this.showTime = showTime;
   }
   //mutator method to set the number of tickets needs 1 int type input parameter
   public void setNumTickets(int numTickets)
   { 
      //only accepts number of tickets between 1 and 10
      if (numTickets > 0 && numTickets <= 10)
      {
         this.numTickets = numTickets;
      }
      else
      {
         System.out.println("Number of Tickets must be within the valid range 1 to 10.");
      }
   }
   //accessor method returns the price per ticket as a String to 2 decimal places
   public String getPricePerTicket()
   {
      return "Price Per Ticket: €" + (String.format("%.2f",pricePerTicket));
   }
   //method calculates total price of tickets and returns the total
   public double calculateTotalPrice()
   {
     double total = numTickets * pricePerTicket;
     return total;
   }
   //method returns all booking details as a String
   public String toString()
   {
      return "Booking Number: " +bookingID+ 
             "\nMovie: " +movieTitle+ 
             "\nShow Time: " +showTime+ 
             "\nTickets: " +numTickets+  
             "\nTicket Price: €" +String.format("%.2f",pricePerTicket)+
             "\nTotal Price: €"+String.format("%.2f",calculateTotalPrice());
   }
}//end of class