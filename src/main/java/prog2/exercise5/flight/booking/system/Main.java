package prog2.exercise5.flight.booking.system;

public class Main 
{
    public static void main( String[] args )
    {   
        int size = 3;
        FlightBooking fb = new FlightBooking(size);
        fb.reserveTickets();

        }
    }
