import java.util.ArrayList;
import java.util.List;

public class AlarmOwner implements AlarmObserver {
    private final List<NotificationChannel> channels = new ArrayList<NotificationChannel>();
    public AlarmOwner() {
        channels.add(new PhoneNotification());
        channels.add(new EmailNotification());
        channels.add(new PhoneCallNotification());
    }
    public void addChannel(NotificationChannel channel) { channels.add(channel); }
    public void onDetection(String objectName) {
        for (NotificationChannel channel : channels) channel.send(objectName);
    }
}
