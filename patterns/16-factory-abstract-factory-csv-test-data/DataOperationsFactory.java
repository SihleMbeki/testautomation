public interface DataOperationsFactory {
    CsvOperation createCleaner();

    CsvOperation createPopulator();

    CsvOperation createModifier();
}
