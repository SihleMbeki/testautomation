# UI automation — Java, Selenium, and TestNG

The suite exercises the shared local HTML form. It includes a TestNG data
provider, SLF4J logging, an ordered fallback-locator example, popup/window
switching, and a JavaScript alert assertion.

## Prerequisites and run

- JDK 11 or newer
- Maven
- Google Chrome

From this folder:

```powershell
mvn test
```

Selenium Manager resolves a compatible ChromeDriver. To see the browser while
tests run, use `mvn test "-Dheadless=false"`. Reports are written to
`target/surefire-reports`.

## Locator healing note

`SelfHealingLocator` tries a short, ordered list and logs when it has to use a
fallback. This is a transparent teaching example, not a substitute for stable
accessible locators or a commercial healing service. Keep fallbacks specific,
review every healing log, and fix the underlying locator when the UI changes.

## Practices demonstrated

- Keep browser setup and teardown in TestNG lifecycle hooks.
- Put interaction details behind a small page object.
- Use a data provider for meaningful input variation.
- Wait for observable conditions (new window, alert, URL) rather than sleeping.
- Capture useful test output through the logger and TestNG reports.
