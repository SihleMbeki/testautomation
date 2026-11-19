public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel("Travel News");
        Subscriber ava = new Subscriber("Ava");
        Subscriber ben = new Subscriber("Ben");
        channel.subscribe(ava);
        channel.subscribe(ben);
        channel.publish("New routes announced");
        channel.unsubscribe(ava);
        channel.publish("Weekend fares available");
    }
}
