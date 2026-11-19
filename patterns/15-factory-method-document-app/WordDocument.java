public final class WordDocument extends AbstractDocument {
    public WordDocument(String title) {
        super(title);
    }

    @Override
    public String getFormat() {
        return "Word";
    }
}
