public class EmailNotification implements NotificationChannel {
    public void send(String objectName) {
        System.out.println("Email notification: detected " + objectName + ".");
    }
}
