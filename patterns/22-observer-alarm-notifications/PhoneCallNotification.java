public class PhoneCallNotification implements NotificationChannel {
    public void send(String objectName) {
        System.out.println("Phone call: detected " + objectName + ".");
    }
}
