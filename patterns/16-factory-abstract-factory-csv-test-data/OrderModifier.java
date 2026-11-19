import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class OrderModifier implements CsvOperation {
    @Override
    public void apply(Path csvFile) throws IOException {
        List<String> rows = Files.readAllLines(csvFile, StandardCharsets.UTF_8);
        rows.set(1, rows.get(1).replace(",pending", ",shipped"));
        Files.write(csvFile, rows, StandardCharsets.UTF_8);
    }
}
