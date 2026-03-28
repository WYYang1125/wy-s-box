import java.util.*;
import java.time.LocalDateTime;
public class BikeRental {
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private boolean locationValid;
    private String emailAddress;
    private LocalDateTime tripStartTime;

    public void simulateApplicationInput() {
        Scanner sc=new Scanner(System.in);
        System.out.println("E-bike rental simulation");
        System.out.print("Registered? "); boolean reg=sc.nextBoolean();
        sc.nextLine(); System.out.print("Email: "); emailAddress=sc.nextLine();
        System.out.print("Location: "); String loc=sc.nextLine();
        String bikeID=analyseRequest(reg,emailAddress,loc);
        if(!locationValid) return;
        reserveBike(bikeID); viewActiveRentals();
        removeTrip(bikeID); viewActiveRentals();
    }

    private String analyseRequest(boolean reg, String email, String loc) {
        if(reg) System.out.println("Welcome back "+email);
        else System.out.println("Please register");
        return validateLocation(loc);
    }

    private String validateLocation(String loc) {
        for(Bike b : BikeDatabase.bikes) {
            if(b.getLocation().equals(loc) && b.isAvailable()) {
                locationValid=true; return b.getBikeID();
            }
        } locationValid=false; return null;
    }

    private void reserveBike(String bikeID) {
        for(Bike b : BikeDatabase.bikes) {
            if(b.getBikeID().equals(bikeID)) {
                tripStartTime=LocalDateTime.now();
                b.setAvailable(false); b.setLastUsedTime(tripStartTime);
                activeRentalsList.add(new ActiveRental(bikeID,emailAddress,tripStartTime));
                break;
            }
        }
    }

    private void viewActiveRentals() {
        if(activeRentalsList.isEmpty()) System.out.println("No active rentals");
        else for(ActiveRental ar : activeRentalsList) System.out.println(ar);
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> it=activeRentalsList.iterator();
        while(it.hasNext()) { if(it.next().getBikeID().equals(bikeID)) it.remove(); break; }
        for(Bike b : BikeDatabase.bikes) {
            if(b.getBikeID().equals(bikeID)) { b.setAvailable(true); break; }
        }
    }
}

class BikeDatabase {
    public static ArrayList<Bike> bikes = new ArrayList<>();
    static { bikes.add(new Bike("B001",true,85,LocalDateTime.now(),"Campus")); }
}
