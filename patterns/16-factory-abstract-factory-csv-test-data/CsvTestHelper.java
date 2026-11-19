import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class CsvTestHelper {
    private final Path directory;
    private final DataOperationsFactory operationsFactory;
    private final String familyName;

    protected CsvTestHelper(Path directory, DataOperationsFactory operationsFactory, String familyName) {
        this.directory = directory;
        this.operationsFactory = operationsFactory;
        this.familyName = familyName;
    }

    public final Path getCsvFile() {
        return directory.resolve("data.csv");
    }

    public final void runSteps() throws IOException {
        Path csvFile = getCsvFile();
        System.out.println("TEST HELPER: " + familyName + " (" + csvFile + ")");
        operationsFactory.createCleaner().apply(csvFile);
        printSnapshot("AFTER CLEAN", csvFile);
        operationsFactory.createPopulator().apply(csvFile);
        printSnapshot("AFTER POPULATE", csvFile);
        operationsFactory.createModifier().apply(csvFile);
        printSnapshot("AFTER MODIFY", csvFile);
    }

    private void printSnapshot(String label, Path csvFile) throws IOException {
        System.out.println(label + ":");
        for (String line : Files.readAllLines(csvFile, StandardCharsets.UTF_8)) {
            System.out.println("  " + line);
        }
    }
}
