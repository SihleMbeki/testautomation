public class Naive {
    public static void main(String[] args) {
        Candle candle = new Candle();
        // This room must know Candle's incompatible method names.
        candle.light();
        candle.blowOut();
    }
}
