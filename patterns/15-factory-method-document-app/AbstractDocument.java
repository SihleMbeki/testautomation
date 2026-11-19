public abstract class AbstractDocument implements Document {
    private String title;

    protected AbstractDocument(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
