public class CandleAdapter implements Light {
    private final Candle candle;

    public CandleAdapter(Candle candle) { this.candle = candle; }
    public void turnOn() { candle.light(); }
    public void turnOff() { candle.blowOut(); }
}
