public class Naive {
    public static void main(String[] args) {
        String appType = "word";
        Document document;
        // Branching construction is repeated wherever the application creates a document.
        if ("word".equals(appType)) {
            document = new WordDocument("Quarterly Report");
        } else {
            document = new SpreadsheetDocument("Travel Budget");
        }
        System.out.println("NAIVE created " + document.getFormat() + ": " + document.getTitle());
        System.out.println("NAIVE save " + document.getTitle());
        System.out.println("NAIVE close " + document.getTitle());
    }
}
