import java.util.ArrayList;
import java.util.List;

public class NativeGenderSource implements GenderSource {
    public List<GenderOption> getAllGenders() {
        List<GenderOption> options = new ArrayList<GenderOption>();
        for (Gender gender : Gender.values()) {
            options.add(new GenderOption(gender.label()));
        }
        return options;
    }
}
