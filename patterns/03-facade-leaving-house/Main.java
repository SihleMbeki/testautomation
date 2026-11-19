public class Main {
    public static void main(String[] args) {
        System.out.println("FACADE - Leaving home");
        new LeavingHomeFacade(new Lights(), new Windows(), new DoorLock(), new Alarm()).leaveHome();
    }
}
