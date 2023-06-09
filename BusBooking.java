import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.*;

/**
 * BusBooking
 */


interface Buses {
    List<Integer> busPrice = new ArrayList<>();
    List<String> busName = new ArrayList<>();
    
    Map <String,Integer> buses = new HashMap<>();
    //static  Map <String, Integer> busSelected =new HashMap<>();
    public void showBuses();
    public void getBus();
}
interface TravelDetails{
    public void getSource();
    public void getDestination();
    public void getDateOfTravel();
   
}

abstract class User implements Buses,TravelDetails{
    String name,source,destination,selectedBus;
    int age,busTag,busChoice;
    Date date;

    abstract public void getUser();
    

   
}

class Traveller extends User implements TravelDetails,Buses{
    // String[] busName = {"B1", "B2", "B3"};
    // int [] price = {2000, 4000, 5000};
     

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
        Stream<Integer> busP = busPrice.stream();
        Stream<String> busN = busName.stream();
        System.out.println("-----------------------");
        System.out.println("Buses available:");
        // for (int i = 0; i <3; i++){
        //     System.out.println((i+1) + "."+ busName[i] + ": Rs." + price[i]);
        // }
        // buses.put("B1", 1000);
        // buses.put("B2", 2000);
        // buses.put("B3", 3000);

        busName.add("B1");
        busName.add("B2");
        busName.add("B3");
        busPrice.add(3000);
        busPrice.add(2000);
        busPrice.add(5000);
        // int i = 1;
        // for (String bus: buses.keySet()){
        //     System.out.println((i) + bus + "- Rs." + buses.get(bus));
        //     i++;
        // }

            busN.forEach((b)->System.out.print(b + " "));
            System.out.println(" ");
            busP.forEach((bP)->System.out.print(bP + " "));
    }

    @Override
    public void getBus() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("-----------------------");
        System.out.println("Enter Bus Choice");
        busChoice = sc.nextInt();

        switch(busChoice){
            case 1:
            selectedBus = busName.get(0);
            break;

            case 2:
            selectedBus = busName.get(1);
            break;

            case 3:
            selectedBus = busName.get(2);
            break;
            
            default:
            System.out.println("Not correct Choice.");
            break;
        }
        // for (String bus : buses.keySet()){
        //     if (bus == busChoice){
        //         busSelected.put(bus, buses.get(bus));
        //     }
        // }
        // selectedBus = busChoice;
        
    }

    public void showFullDetails(){
        System.out.println("-----------------------");
        System.out.println("Booking Successful");
        System.out.println("Source:" + source + " " + "Destination:" + destination);
        System.out.println("Date:" + date);
        System.out.println("Bus Selected:" + selectedBus);
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