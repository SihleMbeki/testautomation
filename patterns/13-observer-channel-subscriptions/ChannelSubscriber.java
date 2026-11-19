public interface ChannelSubscriber {
    void onMessage(String channelName, String message);
}
