import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class TestStep {
    protected abstract CsvTestHelper createHelper(Path directory);

    public final void run() throws IOException {
        Path directory = Files.createTempDirectory("csv-test-helper-");
        Path csvFile = directory.resolve("data.csv");
        try {
            createHelper(directory).runSteps();
        } finally {
            Files.deleteIfExists(csvFile);
            Files.deleteIfExists(directory);
        }
    }
}
