public class OnlineFoodOrder extends FoodOrder {
    private final FulfilmentStrategy fulfilment;

    public OnlineFoodOrder(FulfilmentStrategy fulfilment) { this.fulfilment = fulfilment; }

    protected void fulfilOrder() { fulfilment.fulfil(); }
}
