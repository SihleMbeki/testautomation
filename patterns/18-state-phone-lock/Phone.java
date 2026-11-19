public class Phone {
    private PhoneState state = new LockedState();

    public void pressKey(String key) { state.pressKey(this, key); }
    public void unlock() { state.unlock(this); }
    public void lock() { state.lock(this); }
    void setState(PhoneState state) { this.state = state; }
}
