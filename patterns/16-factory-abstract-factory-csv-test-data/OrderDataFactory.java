public final class OrderDataFactory implements DataOperationsFactory {
    @Override
    public CsvOperation createCleaner() {
        return new OrderCleaner();
    }

    @Override
    public CsvOperation createPopulator() {
        return new OrderPopulator();
    }

    @Override
    public CsvOperation createModifier() {
        return new OrderModifier();
    }
}
