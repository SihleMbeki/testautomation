# Add missing class capabilities

## Description

When a class lacks a useful operation, add that capability directly if it
belongs to the class and the change is small. This is often clearer than
introducing a design pattern prematurely. Keep the new operation focused; move
it to a collaborator if it grows or serves multiple classes.

## Example

A basic report can gain a CSV export operation:

```java
class Report {
    private final String title;

    Report(String title) {
        this.title = title;
    }

    String toCsv() {
        return "title\n\"" + title.replace("\"", "\"\"") + "\"";
    }
}
```

`toCsv()` is the added capability. If reports later support many formats,
consider extracting a formatter instead of growing this class with unrelated
formatting logic.
