package prog2.exercise5.flight.booking.system;


import java.util.Scanner;


public class Main{
    public static void main(String[] args) {


        Scanner GQK = new Scanner(System.in);
////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Please enter how many tickets you want to book:");
        int number  =GQK.nextInt();
        FlightBooking FB2 = new FlightBooking(number);
        FB2.reserveTickets(number);
        FB2.displayTripDetails();
        GQK.close();
////////////////////////////////////////////////////////////////////////////////////





        
    }
    }
