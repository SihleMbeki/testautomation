import java.util.ArrayList;
import java.util.List;

public class ExternalGenderAdapter implements GenderSource {
    private final ExternalGenderProvider provider;

    public ExternalGenderAdapter(ExternalGenderProvider provider) {
        this.provider = provider;
    }

    public List<GenderOption> getAllGenders() {
        List<GenderOption> options = new ArrayList<GenderOption>();
        for (String code : provider.codes()) {
            if ("X".equals(code)) options.add(new GenderOption("Option X"));
            else if ("Y".equals(code)) options.add(new GenderOption("Option Y"));
            else options.add(new GenderOption("Other (" + code + ")"));
        }
        return options;
    }
}
