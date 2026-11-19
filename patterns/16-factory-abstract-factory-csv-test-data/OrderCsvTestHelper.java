import java.nio.file.Path;

public final class OrderCsvTestHelper extends CsvTestHelper {
    public OrderCsvTestHelper(Path directory, OrderDataFactory factory) {
        super(directory, factory, "ORDER");
    }
}
