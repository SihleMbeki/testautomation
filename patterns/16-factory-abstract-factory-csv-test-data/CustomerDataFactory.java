public final class CustomerDataFactory implements DataOperationsFactory {
    @Override
    public CsvOperation createCleaner() {
        return new CustomerCleaner();
    }

    @Override
    public CsvOperation createPopulator() {
        return new CustomerPopulator();
    }

    @Override
    public CsvOperation createModifier() {
        return new CustomerModifier();
    }
}
