import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class OrderPopulator implements CsvOperation {
    @Override
    public void apply(Path csvFile) throws IOException {
        Files.write(csvFile, Arrays.asList("order_id,item,status", "101,Book,pending"),
                StandardCharsets.UTF_8);
    }
}
