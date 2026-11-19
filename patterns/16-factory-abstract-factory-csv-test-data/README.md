# 16 — Factory Method + Abstract Factory: CSV test helpers

## Problem
Automated tests need repeatable CSV fixtures in a temporary directory: clean the file, populate default rows, apply a change, and inspect its contents after each step. Customer and order tests use different but internally consistent cleaner, populator, and modifier implementations.

## The catch
One concrete constructor cannot create both kinds of helper without knowing their details. Independently choosing a customer cleaner and an order populator can also silently mix incompatible fixture formats.

## Pattern and roles
The **Factory Method** is `TestStep.createHelper`: `CustomerTestStep` and `OrderTestStep` decide which concrete `CsvTestHelper` to create, while the base step owns the run lifecycle. The **Abstract Factory** is `DataOperationsFactory`: `CustomerDataFactory` and `OrderDataFactory` each create a matching family of `CsvOperation` products (cleaner, populator, modifier). The two patterns solve different choices: one selects a test helper subtype; the other selects a consistent family of related file operations.

## How the pattern solves the catch
- Each run creates an isolated directory under the system temporary directory and a `data.csv` file.
- Each helper runs clean, populate-default-data, and apply-change operations in order.
- File contents are printed after each clean, populate, and modify step; a test-step factory method selects the customer or order helper.
- A family-specific factory supplies the matching cleaner, populator, and modifier, with typed helper constructors preventing accidental family mixing.
- The test step removes its CSV and temporary directory when finished.

## Where you'll meet it in test automation
- Run the customer step twice and assert each run starts from the same default CSV contents.
- Assert the customer modifier changes `active` to `verified` without changing the header.
- Assert the order family retains its own columns and changes `pending` to `shipped`.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output shows three snapshots (`AFTER CLEAN`, `AFTER POPULATE`, `AFTER MODIFY`) for both customer and order files; the final rows contain `verified` and `shipped` respectively. The naive program manually repeats the file steps for both data types.

## Try this next
Add an invoice family with its own cleaner, populator, and modifier, then add a test step without changing the existing customer and order operations.
