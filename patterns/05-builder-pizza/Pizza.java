import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private final String size, base; private final boolean cheese; private final List<String> toppings;
    private Pizza(Builder b) { size=b.size; base=b.base; cheese=b.cheese; toppings=Collections.unmodifiableList(new ArrayList<>(b.toppings)); }
    public String describe() { return size + " pizza, " + base + " base, cheese " + (cheese ? "yes" : "no") + ", toppings: " + (toppings.isEmpty() ? "none" : String.join(", ", toppings)); }
    public static class Builder {
        private String size="medium", base="classic"; private boolean cheese=true; private final List<String> toppings=new ArrayList<>();
        public Builder size(String value) { size=value; return this; }
        public Builder base(String value) { base=value; return this; }
        public Builder cheese(boolean value) { cheese=value; return this; }
        public Builder addTopping(String value) { toppings.add(value); return this; }
        public Pizza build() { return new Pizza(this); }
    }
}
