public class PhoneNotification implements NotificationChannel {
    public void send(String objectName) {
        System.out.println("Phone notification: detected " + objectName + ".");
    }
}
