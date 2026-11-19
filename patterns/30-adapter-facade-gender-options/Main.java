public class Main {
    public static void main(String[] args) {
        GenderDisplay display = new GenderDisplay();
        GenderFacade facade = new GenderFacade();
        for (GenderOption option : facade.getAllGenders()) {
            display.displayGender(option);
        }
    }
}
