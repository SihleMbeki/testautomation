import java.util.List;

public class Naive {
    public static void main(String[] args) {
        List<String> externalCodes = new ExternalGenderProvider().codes();
        // A caller without adapters/facade must parse and combine each format.
        System.out.println("External gender codes: " + externalCodes);
    }
}
