public final class SpreadsheetDocument extends AbstractDocument {
    public SpreadsheetDocument(String title) {
        super(title);
    }

    @Override
    public String getFormat() {
        return "Spreadsheet";
    }
}
