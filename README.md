# Test automation learning workspace

This workspace contains three independent automation tracks and a small HTML form
used by the browser tests:

| Track | Stack | Purpose |
|---|---|---|
| `c#api` | C# / NUnit | One API smoke test against `https://http.cat/100` |
| `java-selenium` | Java / Selenium / TestNG | Data-driven UI tests, logs, locator fallback, tabs, and alerts |
| `Playwright` | TypeScript / Playwright Test | Equivalent browser coverage with auto-waiting, traces, and data-driven tests |

The shared form opens its results in a new tab. Submitting without choosing Yes
or No displays an alert and keeps the form open.

## Test-automation roles in practice

- **Test analyst:** start with the scenarios and risks in each track's `docs/test-plan.md`.
- **Automation engineer:** maintain focused, repeatable tests and useful failure diagnostics.
- **Quality engineer:** use the smoke tests as a fast signal, then expand coverage from risk and requirements.

Run each track from its own folder; the track READMEs list prerequisites and
commands. The browser suites use the local HTML file, so no web server is needed.
