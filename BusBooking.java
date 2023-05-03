import java.util.Date;
import java.util.Scanner;

/**
 * BusBooking
 */


interface Buses {
    public void showBuses();
}
interface TravelDetails{
    public void getSource();
    public void getDestination();
    public void getDateOfTravel();
   
}

abstract class User implements Buses,TravelDetails{
    String name,source,destination,busSelected;
    int age,busTag;
    Date date;

    abstract public void getUser();
    abstract public void getBus();

   
}

class Traveller extends User implements TravelDetails,Buses{
    String[] busName = {"B1", "B2", "B3"};
    int [] price = {2000, 4000, 5000};

@Override
public void getUser() {
    Scanner sc = new Scanner(System.in);
    System.out.println("-----------------------");
    System.out.println("Enter Name:");
    name = sc.nextLine();
    System.out.println("Enter Age:");
    age = sc.nextInt();
    }

    @Override
    public void getSource() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter Source:");
        source = sc.nextLine();
    }

    @Override
    public void getDestination() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter destination:");
        destination = sc.nextLine();
    }
    @Override
    public void getDateOfTravel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter Date:");
        try{
            date = new Date(sc.next());
        }
        catch(Exception e){
        System.out.println("Enter correct date.");
        }
        
        
    }

     @Override
    public void showBuses() {
        System.out.println("-----------------------");
        System.out.println("Buses available:");
        for (int i = 0; i <3; i++){
            System.out.println((i+1) + "."+ busName[i] + ": Rs." + price[i]);
        }
    }

    @Override
    public void getBus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter Bus Choice");
        busTag = sc.nextInt();

        switch(busTag){
            case 1:
            busSelected = busName[0];
            break;

            case 2:
            busSelected = busName[1];
            break;

            case 3:
            busSelected = busName[2];
            break;
            
            default:
            System.out.println("Not correct Choice.");
            break;
        }
        
    }

    public void showFullDetails(){
        System.out.println("-----------------------");
        System.out.println("Booking Successful");
        System.out.println("Source:" + source + " " + "Destination:" + destination);
        System.out.println("Date:" + date);
        System.out.println("Bus Selected:" + busSelected);
        System.out.println("Name:" + name +  " " + "Age:" + age);

    }

}

public class BusBooking {

    public static void main(String[] args) {
        int choice = 1;
        Scanner sc = new Scanner(System.in);
        Traveller t1 = new Traveller();
        System.out.println("...Welcome To Big Bus....");
        while(choice == 1){
        t1.getSource();
        t1.getDestination();
        t1.getDateOfTravel();
        t1.showBuses();
        t1.getBus();
        t1.getUser();
        t1.showFullDetails();
        System.out.println("1.Book another ticket?");
        System.out.println("2.Exit.");
        System.out.println("Enter choice:");
        choice = sc.nextInt();
        }
    }
}