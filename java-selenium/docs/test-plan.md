# UI test plan

## Scenarios

| ID | Priority | Scenario | Expected result |
|---|---|---|---|
| UI-001 | High | Submit a valid form for each TestNG data row | A new results window opens and shows the submitted name, age choice, interest, and checkbox state |
| UI-002 | High | Submit without selecting Yes or No | An alert explains the missing selection; accepting it leaves the form open |

## Analysis notes

- The age question allows either answer; only omitting a choice triggers the alert.
- The robot checkbox is optional. An unchecked checkbox is absent from GET
  parameters and is shown as “Not selected” on the results page.
- `UI-001` covers both radio answers, all interests, and checked/unchecked
  checkbox states through its data provider.

## Risks

The suite needs Chrome and a compatible driver. Browser startup or local file
access issues should be distinguished from actual form regressions using the
Maven report and test logs.
