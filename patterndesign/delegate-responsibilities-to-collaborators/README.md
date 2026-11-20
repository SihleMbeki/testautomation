# Delegate responsibilities to collaborators

## Description

Let a class pass a focused responsibility to another object instead of
implementing every operation itself. The owning class remains the entry point
while collaborators handle their assigned work.

## Example

```java
class ScreenshotWriter {
    void save(String fileName, byte[] image) {
        System.out.println("Saving " + image.length + " bytes to " + fileName);
    }
}

class BrowserTest {
    private final ScreenshotWriter screenshotWriter;

    BrowserTest(ScreenshotWriter screenshotWriter) {
        this.screenshotWriter = screenshotWriter;
    }

    void captureFailure(String testName, byte[] image) {
        screenshotWriter.save(testName + "-failure.png", image);
    }
}
```

`BrowserTest` chooses when and what to capture; `ScreenshotWriter` owns the
save operation.
