public final class WordApplication extends Application {
    @Override
    protected Document createDocument(String title) {
        return new WordDocument(title);
    }
}
