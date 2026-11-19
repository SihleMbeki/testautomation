import java.io.IOException;
import java.nio.file.Path;

public interface CsvOperation {
    void apply(Path csvFile) throws IOException;
}
