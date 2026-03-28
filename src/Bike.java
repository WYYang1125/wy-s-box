
import java.time.LocalDateTime;
public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;
    public Bike(String id, boolean avail, int bat, LocalDateTime time, String loc) {
        bikeID=id; isAvailable=avail; batteryLevel=bat; lastUsedTime=time; location=loc;
    }
    public String getBikeID(){return bikeID;}
    public boolean isAvailable(){return isAvailable;}
    public void setAvailable(boolean b){isAvailable=b;}
    public void setLastUsedTime(LocalDateTime t){lastUsedTime=t;}
    public String getLocation(){return location;}
}

public class ActiveRental {
    private String bikeID, userEmail;
    private LocalDateTime tripStartTime;
    public ActiveRental(String id, String email, LocalDateTime t) {
        bikeID=id; userEmail=email; tripStartTime=t;
    }
    public String getBikeID(){return bikeID;}
}
