public class Main {
    public static void main(String[] args) {
        System.out.println("Delivery order:");
        new OnlineFoodOrder(new DeliveryFulfilment()).placeOrder();
        System.out.println("Collection order:");
        new OnlineFoodOrder(new CollectionFulfilment()).placeOrder();
    }
}
