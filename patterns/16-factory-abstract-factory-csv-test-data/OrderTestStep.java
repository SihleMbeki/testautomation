import java.nio.file.Path;

public final class OrderTestStep extends TestStep {
    @Override
    protected CsvTestHelper createHelper(Path directory) {
        return new OrderCsvTestHelper(directory, new OrderDataFactory());
    }
}
