import java.nio.file.Path;

public final class CustomerTestStep extends TestStep {
    @Override
    protected CsvTestHelper createHelper(Path directory) {
        return new CustomerCsvTestHelper(directory, new CustomerDataFactory());
    }
}
