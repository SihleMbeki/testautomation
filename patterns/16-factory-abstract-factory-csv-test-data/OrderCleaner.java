import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class OrderCleaner implements CsvOperation {
    @Override
    public void apply(Path csvFile) throws IOException {
        Files.deleteIfExists(csvFile);
        Files.createFile(csvFile);
    }
}
