import java.util.Arrays;
import java.util.List;

public class ExternalGenderProvider {
    // This external API cannot be changed and returns compact codes.
    public List<String> codes() {
        return Arrays.asList("X", "Y");
    }
}
