import java.util.ArrayList;
import java.util.List;

public final class Channel {
    private final String name;
    private final List<ChannelSubscriber> subscribers = new ArrayList<ChannelSubscriber>();

    public Channel(String name) {
        this.name = name;
    }

    public void subscribe(ChannelSubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println("SUBSCRIBED to " + name);
        }
    }

    public void unsubscribe(ChannelSubscriber subscriber) {
        if (subscribers.remove(subscriber)) {
            System.out.println("UNSUBSCRIBED from " + name);
        }
    }

    public void publish(String message) {
        System.out.println("PUBLISH " + name + ": " + message);
        for (ChannelSubscriber subscriber : new ArrayList<ChannelSubscriber>(subscribers)) {
            subscriber.onMessage(name, message);
        }
    }
}
