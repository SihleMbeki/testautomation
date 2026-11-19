# Observer - Match Scoreboard

## Problem
The match score changes over time, and the scoreboard, commentator, and fans all need the same update. Hard-wiring those reactions into Match makes it know every display and audience; adding a radio station would require changing Match.

## The catch
If `Match` directly updates the scoreboard and calls the commentator and fans, it must know every listener. Adding a radio station then means editing match logic and risks changing the scoring behavior.

## Pattern and roles
**Observer:** A subject broadcasts updates to listeners that subscribe, without depending on the concrete listeners. `Match` is the subject; `MatchListener` is the observer interface; `Scoreboard`, `Commentator`, and `Fans` are concrete observers.

## How the pattern solves the catch
- Define a listener interface for score updates.
- Let Match maintain a list of listeners and notify them after a score changes.
- Implement scoreboard, commentator, and fans as independent listeners.
- Register a radio listener without changing Match.

## Where you'll meet it in test automation
- A Selenium test subscribes a screenshot/report listener and an event log listener to the same test lifecycle event source.
- A UI automation harness notifies assertions and diagnostics when a page-state change event occurs.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`):

```text
OBSERVER - Match updates
Scoreboard: Home 1 - Away 0
Commentator: GOAL! Home scored.
Fans: We are cheering!
Radio: Breaking goal update - Home scored.
```

`Naive` starts with `NAIVE - Match with hard-wired reactions` and prints the score and hard-coded audience reactions.

## Try this next
Add a referee observer that prints the scorer and minute; subscribe it without changing Match.
