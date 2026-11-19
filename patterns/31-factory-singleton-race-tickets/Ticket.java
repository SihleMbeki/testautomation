public class Ticket {
    private final int raceNumber;
    private final boolean freeShirt;

    public Ticket(int raceNumber, boolean freeShirt) {
        this.raceNumber = raceNumber;
        this.freeShirt = freeShirt;
    }

    public int raceNumber() { return raceNumber; }
    public boolean hasFreeShirt() { return freeShirt; }
}
