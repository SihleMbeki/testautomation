import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Naive {
    public static void main(String[] args) throws IOException {
        Path customerDirectory = Files.createTempDirectory("naive-customer-");
        Path orderDirectory = Files.createTempDirectory("naive-order-");
        try {
            // Both file workflows must be edited independently when setup steps change.
            runCustomer(customerDirectory.resolve("data.csv"));
            runOrder(orderDirectory.resolve("data.csv"));
        } finally {
            Files.deleteIfExists(customerDirectory.resolve("data.csv"));
            Files.deleteIfExists(customerDirectory);
            Files.deleteIfExists(orderDirectory.resolve("data.csv"));
            Files.deleteIfExists(orderDirectory);
        }
    }

    private static void runCustomer(Path file) throws IOException {
        Files.createFile(file);
        print("NAIVE CUSTOMER AFTER CLEAN", file);
        Files.write(file, Arrays.asList("id,name,status", "1,Ada,active"), StandardCharsets.UTF_8);
        print("NAIVE CUSTOMER AFTER POPULATE", file);
        List<String> rows = Files.readAllLines(file, StandardCharsets.UTF_8);
        rows.set(1, rows.get(1).replace(",active", ",verified"));
        Files.write(file, rows, StandardCharsets.UTF_8);
        print("NAIVE CUSTOMER AFTER MODIFY", file);
    }

    private static void runOrder(Path file) throws IOException {
        Files.createFile(file);
        print("NAIVE ORDER AFTER CLEAN", file);
        Files.write(file, Arrays.asList("order_id,item,status", "101,Book,pending"), StandardCharsets.UTF_8);
        print("NAIVE ORDER AFTER POPULATE", file);
        List<String> rows = Files.readAllLines(file, StandardCharsets.UTF_8);
        rows.set(1, rows.get(1).replace(",pending", ",shipped"));
        Files.write(file, rows, StandardCharsets.UTF_8);
        print("NAIVE ORDER AFTER MODIFY", file);
    }

    private static void print(String label, Path file) throws IOException {
        System.out.println(label + ":");
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            System.out.println("  " + line);
        }
    }
}
