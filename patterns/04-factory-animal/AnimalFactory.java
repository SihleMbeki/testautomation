public class AnimalFactory {
    public static Animal create(String name) {
        switch (name.toLowerCase()) {
            case "dog": return new Dog();
            case "cat": return new Cat();
            case "cow": return new Cow();
            default: throw new IllegalArgumentException("Unknown animal: " + name);
        }
    }
}
