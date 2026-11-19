import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class CustomerPopulator implements CsvOperation {
    @Override
    public void apply(Path csvFile) throws IOException {
        Files.write(csvFile, Arrays.asList("id,name,status", "1,Ada,active"),
                StandardCharsets.UTF_8);
    }
}
