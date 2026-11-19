import java.util.Locale;

public class ProvinceNames {
    public static String normalize(String value) {
        if (value == null) return null;
        String cleaned = value.trim().toLowerCase(Locale.ROOT);
        if ("kzn".equals(cleaned) || "kwa zulu natal".equals(cleaned)
                || "kwazulu-natal".equals(cleaned)) return "KwaZulu-Natal";
        if ("gauteng".equals(cleaned)) return "Gauteng";
        if ("western cape".equals(cleaned) || "western-cape".equals(cleaned)) {
            return "Western Cape";
        }
        return null;
    }
}
