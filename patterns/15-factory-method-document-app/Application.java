import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Application {
    private final List<Document> openDocuments = new ArrayList<Document>();

    protected abstract Document createDocument(String title);

    public Document newDocument(String title) {
        Document document = createDocument(title);
        openDocuments.add(document);
        System.out.println("NEW " + document.getFormat() + " document: " + title);
        return document;
    }

    public Document openDocument(String title) {
        Document document = createDocument(title);
        openDocuments.add(document);
        System.out.println("OPEN " + document.getFormat() + " document: " + title);
        return document;
    }

    public void saveDocument(Document document) {
        requireOpen(document);
        System.out.println("SAVE " + document.getFormat() + " document: " + document.getTitle());
    }

    public void closeDocument(Document document) {
        requireOpen(document);
        openDocuments.remove(document);
        System.out.println("CLOSE " + document.getFormat() + " document: " + document.getTitle());
    }

    public List<Document> getOpenDocuments() {
        return Collections.unmodifiableList(openDocuments);
    }

    private void requireOpen(Document document) {
        if (!openDocuments.contains(document)) {
            throw new IllegalArgumentException("Document is not open in this application");
        }
    }
}
