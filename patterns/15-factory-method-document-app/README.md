# 15 — Factory Method: document applications

## Problem
Word-processing and spreadsheet applications need the same actions for creating, opening, saving, and closing documents, but each application creates a different document type. An application must also keep track of multiple documents that are open at once.

## The catch
If shared application workflows directly construct concrete documents, every new document type changes that workflow and couples the application to product classes.

## Pattern and roles
The Factory Method lets a base workflow use a product without choosing its concrete class; a subclass supplies that choice. `Application` is the creator and declares the factory method `createDocument`. `WordApplication` and `SpreadsheetApplication` are concrete creators. `Document` is the product interface; `WordDocument` and `SpreadsheetDocument` are concrete products. The base application owns the common document lifecycle and open-document list.

## How the pattern solves the catch
- Shared `newDocument` and `openDocument` call the factory method.
- The concrete application decides which document implementation is created.
- Shared save and close operations work with the `Document` interface.
- The application tracks multiple open documents and removes a document when it closes.

## Where you'll meet it in test automation
- Assert a Word application creates a `WordDocument` and a spreadsheet application creates a `SpreadsheetDocument`.
- Open several documents and assert all are tracked before closing one.
- Assert a closed document is no longer in the application's open-document list.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output shows both application types creating documents, saving them, and closing one while the other remains open. The naive example directly constructs products in branching code.

## Try this next
Add a presentation application and document by supplying a creator and product without changing the base `Application` lifecycle.
