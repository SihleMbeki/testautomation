# Template Method - Match Day

## Problem
Every match follows the same sequence: kick off, play two halves with half time between them, then full time. A cup match follows that sequence but adds penalties if tied.

## The catch
Copying the full match routine for league and cup matches duplicates the shared steps. A correction to half-time or full-time handling can then be missed in one of the copies.

## Pattern and roles
**Template Method:** A base class defines the steps and their order, while subclasses customize only the parts that vary. `Match` is the abstract template; `LeagueMatch` and `CupMatch` are concrete implementations; `Main` runs them. The `playMatch()` method fixes the sequence.

## How the pattern solves the catch
- Define `playMatch()` as the non-varying sequence of match steps.
- Provide hooks for first-half, second-half, and tied-score handling.
- Keep kick-off, half-time, and full-time messages in the template.
- Override only the cup-specific tied-game behavior and use deterministic scores.

## Where you'll meet it in test automation
- A test base class can define setup, test execution, and teardown while subclasses provide test-specific steps.
- A UI automation workflow template can fix login, action, and verification order while tests customize the action.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`): The league and cup matches each print kick off, first half, half time, second half, and full time. The cup score is tied at 1-1, so it additionally prints `Cup: Penalties - Home wins 4-3`. `Naive` starts with `NAIVE - Duplicated match sequence` and prints both manually duplicated schedules.

## Try this next
Add a friendly match that overrides the score steps while reusing the same match-day sequence.
