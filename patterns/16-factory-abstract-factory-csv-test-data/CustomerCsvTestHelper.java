import java.nio.file.Path;

public final class CustomerCsvTestHelper extends CsvTestHelper {
    public CustomerCsvTestHelper(Path directory, CustomerDataFactory factory) {
        super(directory, factory, "CUSTOMER");
    }
}
