public class Main {
    public static void main(String[] args) {
        Application wordApp = new WordApplication();
        Document report = wordApp.newDocument("Quarterly Report");
        Document minutes = wordApp.openDocument("Meeting Minutes");
        wordApp.saveDocument(report);
        wordApp.closeDocument(report);
        System.out.println("Word documents still open: " + wordApp.getOpenDocuments().size());

        Application spreadsheetApp = new SpreadsheetApplication();
        Document budget = spreadsheetApp.newDocument("Travel Budget");
        spreadsheetApp.saveDocument(budget);
        spreadsheetApp.closeDocument(budget);
    }
}
