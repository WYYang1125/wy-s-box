import java.time.LocalDateTime;
public class ERyderLog {
    private String logId;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String logId, String event, LocalDateTime timeStamp) {
        this.logId = logId;
        this.event = event;
        this.timeStamp = timeStamp;
    }

 
    public String getLogId() {
        return logId;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

   
    @Override
    public String toString() {
        return logId + " - " + event + " - " + timeStamp;
    }
}
