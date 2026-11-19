public final class SpreadsheetApplication extends Application {
    @Override
    protected Document createDocument(String title) {
        return new SpreadsheetDocument(title);
    }
}
