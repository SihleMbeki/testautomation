# UI automation — Playwright and TypeScript

This suite covers the same local form as the Selenium suite: data-driven
submissions, new-tab results, optional checkbox behavior, and the missing-age
alert. It uses Playwright Test's fixtures, web-first assertions, traces,
screenshots, and HTML report.

## Prerequisites and run

- Node.js 20 or newer
- npm

From this folder:

```powershell
npm install
npx playwright install chromium
npm test
npm run report
```

## Current practices to learn

- Prefer role- and label-based locators; use `data-testid` only when a control
  has no good user-facing semantic locator.
- Playwright locators auto-wait and re-resolve elements. Do not add fixed sleeps.
- Use the built-in isolated `page` fixture; each test gets a clean browser context.
- Wait for a popup with the browser context event before clicking the submit button.
- Use web-first `expect` assertions and retain traces only when useful (here, on failure).
- `resolveWithFallback` demonstrates logged, bounded self-healing as an explicit
  fallback policy. Prefer fixing a broken primary locator over ignoring repeated
  fallback warnings.

The `test:ui` command opens Playwright's interactive runner when a desktop is
available. CI retries are enabled only in CI; retries are diagnostic, not a fix
for flaky tests.
