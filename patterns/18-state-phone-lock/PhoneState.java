public interface PhoneState {
    void pressKey(Phone phone, String key);
    void unlock(Phone phone);
    void lock(Phone phone);
}
