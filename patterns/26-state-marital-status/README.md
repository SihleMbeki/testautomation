# State - Marital Status

## Problem
A person can be Single, Married, or Divorced. Marriage and divorce change the person's status, but not every action is valid in every status.

## The catch
Putting all the rules in a growing conditional makes it easy to allow an impossible transition or give the wrong rejection.

## Pattern(s)
**State** lets the current state own the behavior and next-state rules. `MaritalStatus` is the state interface; `Single`, `Married`, and `Divorced` are concrete states; `Person` is the context and holds the current state.

## How the pattern solves the catch
- Each status handles marriage and divorce according to its own rules.
- Valid transitions are Single to Married, Married to Divorced, and Divorced to Married.
- Invalid actions print a clear rejection and leave the status unchanged.

## Alternatives
A small enum and a single transition method can be simpler when the state rules are few and unlikely to grow.

## Where you'll meet it in test automation
- A workflow test can check allowed and rejected transitions in an order or account lifecycle.
- State-specific tests can verify each transition without driving a full UI.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Status: Single
Cannot divorce: person is Single
Married: Single -> Married
Cannot marry: person is already Married
Divorced: Married -> Divorced
Cannot divorce: person is Divorced
Married: Divorced -> Married
Final status: Married
```

`Naive` prints `Cannot divorce: person is Single`.

## Try this next
Add an action such as `separate()` and decide which statuses should accept it.
