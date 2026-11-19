import java.util.ArrayList;
import java.util.List;

public class GenderFacade {
    private final List<GenderSource> sources;

    public GenderFacade() {
        sources = new ArrayList<GenderSource>();
        sources.add(new NativeGenderSource());
        sources.add(new ExternalGenderAdapter(new ExternalGenderProvider()));
    }

    public List<GenderOption> getAllGenders() {
        List<GenderOption> all = new ArrayList<GenderOption>();
        for (GenderSource source : sources) all.addAll(source.getAllGenders());
        return all;
    }
}
