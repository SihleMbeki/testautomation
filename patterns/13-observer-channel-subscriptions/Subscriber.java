public final class Subscriber implements ChannelSubscriber {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(String channelName, String message) {
        System.out.println("NOTIFY " + name + " via " + channelName + ": " + message);
    }
}
