# Playwright test plan

## Scenarios

| ID | Priority | Scenario | Expected result |
|---|---|---|---|
| PW-001 | High | Submit each data-driven form case | A second page opens with the submitted values encoded as query parameters |
| PW-002 | High | Submit without choosing Yes or No | The expected alert is raised and the original form remains open |

## Analysis notes

- Data rows exercise both age answers, all interests, and both checkbox states.
- The alert is only for a missing age answer; selecting No is valid.
- The local HTML file keeps the exercise independent of a web server.

## Risks

Chromium must be installed with Playwright's browser installer. Traces,
screenshots, and video help triage failures but should be reviewed before
classifying an intermittent failure as an application defect.
