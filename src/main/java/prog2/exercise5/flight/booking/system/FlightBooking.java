package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;


public class FlightBooking{

    public static final String FLIGHT_COMPANY = "Flights-Of-Fancy";
/////////////////////////////////////////////
    private String[] passengerFullName;
    private String[] passengerGender ;
    private int[] passengerAge ;
    private String [] ticketNumber;
/////////////////////////////////////////////
    private int childPassengers;
    private int adultPassengers;
    private int number;
/////////////////////////////////////////////////////////////////////////////////////////
    public FlightBooking(LocalDate dep1,LocalDate ret1,int child,int adult){
        departureDate = dep1;
        returnDate = ret1;
        childPassengers = child;
        adultPassengers = adult;
    }
///////////////////////////////////////////////////////////////////////////////////////
    public FlightBooking(int num){
        passengerFullName = new String[num];
        passengerGender = new String[num];
        passengerAge = new int[num];
        ticketNumber = new String[num];
        number = num;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void reserveTickets(int number){
    Scanner GQK = new Scanner(System.in);
    for (int repeat =number;repeat>0;--repeat) 
    {
        System.out.println("Dear passenger please input the following messages for the No."+(number+1-repeat)+"passenger");
        System.out.println("Please enter Your FullName :");
        passengerFullName[number-repeat] = GQK.next();
        System.out.println("Please enter Your gender(Male, Female or Other):");
        passengerGender[number-repeat]= GQK.next();
        System.out.println("Please enter Your age:");
        passengerAge[number-repeat] =GQK.nextInt();
    }
//////////////////////////////////////////////
        System.out.println("Give me the class you want to book (1:first, 2:bussiness, 3:economic) :");
        String str = GQK.next();

        System.out.println("Give me the trip type you want to make (1:oneway, 2:return) :");
        String str2 = GQK.next();

        System.out.println("Please give me where you from (1 for NANJING, 2 for BEIJING,3 for SHANGHAI,4 for OULU,5 for HELSINKI,6 for PARIS) :");
        String str3 = GQK.next();  

        System.out.println("Please give me where you go (1 for NANJING, 2 for BEIJING,3 for SHANGHAI,4 for OULU,5 for HELSINKI,6 for PARIS) :");
        String str4 = GQK.next(); 

        System.out.println("Give me the date  you depart in YYYY-MM-DD");
        String dep = GQK.next();
        LocalDate departure = LocalDate.parse(dep);


        System.out.println("Give me the date  you return in theYYYY-MM-DD ");
        String ret = GQK.next();
        LocalDate returning = LocalDate.parse(ret);

        System.out.println("How many children?");
        int childs = GQK.nextInt(); 

        System.out.println("How many children?");
        int adults = GQK.nextInt(); 
//////////////////////////////////////////////
setBookingClass(str);
setTripType(str2);
//////
setTripSource(str3);
setSourceAirport(str3);
//////
setTripDestination(str3, str4);
setDestinationAirport(str3, str4);
//////
setDepartureDate(departure);
setReturnDate(returning);
//////////
for (int repeat =number;repeat>0;--repeat){
    setTicketNumber(number-repeat);
}
///////////
setDepartingTicketPrice(childs,adults);
setReturnTicketPrice();
setTotalTicketPrice();
//////////////////////////////////////////////////////
GQK.close();
    
}
//乘客名字的get/set/////////////////////////////////////////////////////////////////////////////////////////
    public String getPassengerFullName(int index) {
        return passengerFullName[index];
    }
    public void setPassengerFullName(int index,String fullName) {
        passengerFullName [index] = fullName;
    }
//乘客性别////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getPassengerGender(int index) {
        return passengerGender[index];
    }
    public void setPassengerGender(int index,String gender) {
        passengerGender[index] = gender;
    }
//乘客年龄的get/set///////////////////////////////////////////////////////////////////
    public int getPassengerAge(int index) {
        return passengerAge[index];
    }
    public void setPassengerAge(int index,int age) {
        passengerAge[index] = age;
    }
////////////////////////////////////////////////////////////////////////////////////
    public int getchildPassengers(){
        return childPassengers;
    }
    public int getadultPassengers(){
        return adultPassengers;
    }

    private BookingClass bookingClass;
    enum BookingClass{FIRST,BUSINESS,ECONOMY}
    public BookingClass getBookingClass(){
        return bookingClass;
    }
    public void setBookingClass(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                bookingClass = BookingClass.FIRST;
                break;
            case 2:
                bookingClass = BookingClass.BUSINESS;
                break;
            case 3:
                bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Sorry,you must log in 1,2 or 3");
        }
    }

    private TripType tripType;
    enum TripType{ONE_WAY,RETURN}
    public TripType getTripType(){
        return tripType;
    }
    public void setTripType(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                tripType = TripType.ONE_WAY;
                break;
            case 2:
                tripType = TripType.RETURN;
                break;
            default:
                System.out.println("Sorry,you must log in 1 or 2");
        }
    }

    private TripSource tripSource;
    private SourceAirport sourceAirport;
    enum TripSource{NANJING, BEIJING, SHANGHAI, OULU, HELSINKI,PARIS}
    enum SourceAirport{NANJING_LUKOU_INTERNATIONAL_Airport,BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT,OULU_AIRPORT,HELSINKI_AIRPORT,PARIS_CHARLES_DE_GAULLE_AIRPORT} 
    public TripSource getTripSource(){
        return tripSource;
    }
    public SourceAirport getsourceAirport(){
        return sourceAirport;
    }
    public void setTripSource(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                tripSource = TripSource.NANJING;                
                break;
            case 2:
                tripSource = TripSource.BEIJING;               
                break;
            case 3:
                tripSource = TripSource.SHANGHAI;                 
                break;
            case 4:
                tripSource = TripSource.OULU;                 
                break;          
            case 5:
                tripSource = TripSource.HELSINKI;                
                break;
            case 6:
                tripSource = TripSource.PARIS;               
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
        }
    }
    public void setSourceAirport(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:                
                sourceAirport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_Airport;
                break;
            case 2:              
                sourceAirport = SourceAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case 3:                 
                sourceAirport = SourceAirport.SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT;
                break;
            case 4:               
                sourceAirport = SourceAirport.OULU_AIRPORT;
                break;          
            case 5:
                sourceAirport = SourceAirport.HELSINKI_AIRPORT;
                break;
            case 6:
                sourceAirport = SourceAirport.PARIS_CHARLES_DE_GAULLE_AIRPORT;
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
        }
    }
/////////////////////////////////////////////////
    private TripDestination tripDestination;
    private DestinationAirport destinationAirport;
    enum TripDestination{NANJING, BEIJING, SHANGHAI, OULU, HELSINKI,PARIS}
    enum DestinationAirport{NANJING_LUKOU_INTERNATIONAL_Airport,BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT,OULU_AIRPORT,HELSINKI_AIRPORT,PARIS_CHARLES_DE_GAULLE_AIRPORT}
    public TripDestination getTripDestination(){
        return tripDestination;
    }
    public DestinationAirport getDestinationAirport(){
        return destinationAirport;
    }
    public void setDestinationAirport(String SourceOfTrip,String DestinationOfTrip){
        int num3 = Integer.parseInt(SourceOfTrip);
        int num4 = Integer.parseInt(DestinationOfTrip);
        if(num3 != num4 ){
            switch(num4){
            case 1:
                
                destinationAirport = DestinationAirport.NANJING_LUKOU_INTERNATIONAL_Airport;
                break;
            case 2:
                
                destinationAirport = DestinationAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case 3:
                 
                destinationAirport = DestinationAirport.SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT;
                break; 
            case 4:
                   
                destinationAirport = DestinationAirport.OULU_AIRPORT;
                break;        
            case 5:
                
                destinationAirport = DestinationAirport.HELSINKI_AIRPORT;
                break;
            case 6:
                
                destinationAirport = DestinationAirport.PARIS_CHARLES_DE_GAULLE_AIRPORT;
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
            }

        } else{
            System.out.println("error! The trip source and the trip destination cannot be the same.");
        }
    }
    public void setTripDestination(String SourceOfTrip,String DestinationOfTrip){
        int num3 = Integer.parseInt(SourceOfTrip);
        int num4 = Integer.parseInt(DestinationOfTrip);
        if(num3 != num4 ){
            switch(num4){
            case 1:
                tripDestination = TripDestination.NANJING;       
                break;
            case 2:
                tripDestination = TripDestination.BEIJING;         
                break;
            case 3:
                tripDestination = TripDestination.SHANGHAI;            
                break; 
            case 4:
                tripDestination = TripDestination.OULU;                  
                break;        
            case 5:
                tripDestination = TripDestination.HELSINKI;
                break;
            case 6:
                tripDestination = TripDestination.PARIS;
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
            }

        } else{
            System.out.println("error! The trip source and the trip destination cannot be the same.");
        }
    }
///////////////////////////////////////////////
    private LocalDate departureDate;  
    public LocalDate getDepartureDate(){
        return departureDate;
    }
    public void setDepartureDate(LocalDate depart){
        departureDate = depart;
    }

    private LocalDate returnDate; 
    int flag; 
    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate ret){
        long dayDifference = ChronoUnit.DAYS.between(departureDate,ret);
        if(dayDifference == 1){
            flag = 1;
            returnDate = departureDate.plusDays(2);
        } else if(dayDifference == 2){
            flag = 2;
            returnDate = departureDate.plusDays(1);
        }
        else{
            flag = 3;
            returnDate = ret;
        }
    }


///////////////////////////////////
    private String  ticketNumberThird = getTicketNumberThird(4);

    public String getTicketNumberThird(int length){
        String range = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for(int i =0;i <length; i++){
            int number = random.nextInt(62);
            str.append(range.charAt(number));
        }
        return str.toString();
    }

    private String ticketNumberFirst;
    private String ticketNumberSecond;
    private String ticketNumberLast;

    public void setTicketNumber(int index){
        if(tripType == TripType.ONE_WAY){ticketNumberFirst = "11";}       
        else{ticketNumberFirst = "22";}
        if(bookingClass == BookingClass.FIRST){ticketNumberSecond = "F";}
        else if(bookingClass == BookingClass.BUSINESS){ticketNumberSecond = "B";}
        else{ticketNumberSecond = "E";}
        if(tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING || tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING){ticketNumberLast = "DOM";}
        else if(tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI || tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU){ticketNumberLast = "DOM";}
        else {ticketNumberLast = "INT";}

        ticketNumber[index] = ticketNumberFirst + ticketNumberSecond +ticketNumberThird +ticketNumberLast;
        
    }
    public String getTicketNumber(int index) {
        setTicketNumber(index);
        return ticketNumber[index];
    }
//////////////////////////////////////////////////////

    private int departingTicketPrice;
    public int getDepartingTicketPrice(){
        return departingTicketPrice;
    }
    public void  setDepartingTicketPrice(int child,int adult){
        int dtp;
        if(tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING || tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING || tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI || tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU)
        {dtp =345;}
       else {dtp = 375;}
    
    if (bookingClass == BookingClass.FIRST) {
        departingTicketPrice =(child +adult) * (dtp +250);
    } else if (bookingClass == BookingClass.BUSINESS) {
        departingTicketPrice =(child +adult) *(dtp +150);
    } else{
        departingTicketPrice =(child +adult) *(dtp +50);
    }
    }
    private int returnTicketPrice;
    private int totalTicketPrice;
    public void setReturnTicketPrice() {
        if (tripType == TripType.ONE_WAY) {
            returnTicketPrice = 0;
        } else {
            returnTicketPrice = departingTicketPrice;
        }
    }
    public void setTotalTicketPrice() {
        totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }
    public int getTotalTicketPrice() {
        return totalTicketPrice;
    }

        
    public void displayTripDetails(){
        String initial = "Thank you for booking your flight with "+
                FLIGHT_COMPANY+"\nYou reserved a total of" + number +"tickets."+"\n\n";
        System.out.println(initial);
        if (flag == 1||flag ==2){
            for (int repeat=number;repeat>0;--repeat){
                System.out.println("Here are the trip details for Passenger No."+(number-repeat+1)+"\n\nPassenger's Ticket Number: "+
                        ticketNumber[number-repeat]+"\nPassenger's Full Name:"+passengerFullName[number-repeat]+
                        "\nPassenger's Age:"+passengerAge[number-repeat]+"\nPassenger's Gender:"+passengerGender[number-repeat]+
                        "\nFrom:"+tripSource+"("+sourceAirport+")"+"\nTo:"+tripDestination+"("+destinationAirport+")"+"\nThe flight departs on:"+
                        departureDate+"(Changed  to new "+returnDate+")"+"\nAnd the return flight is on:"+ returnDate+"\n\n");
            }
            System.out.println("\nThe total ticket price is:"+totalTicketPrice+"\n\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
                    "less than two days apart from your departure date.");

        }else{
            for (int repeat=number;repeat>0;--repeat){
                System.out.println("Here are the trip details for Passenger No."+(number-repeat+1)+"\n\nPassenger's Ticket Number: "+
                        ticketNumber[number-repeat]+"\nPassenger's Full Name:"+passengerFullName[number-repeat]+
                        "\nPassenger's Age:"+passengerAge[number-repeat]+"\nPassenger's Gender:"+passengerGender[number-repeat]+
                        "\nFrom:"+tripSource+"("+sourceAirport+")"+"\nTo:"+tripDestination+"("+destinationAirport+")"+"\nThe flight departs on:"+
                        departureDate+"\nAnd the return flight is on:"+ returnDate+"\n\n");
            }
            System.out.println("\nThe total ticket price is:"+totalTicketPrice);
        }

    }
}





