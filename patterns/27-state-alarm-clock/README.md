# State - Alarm Clock

## Problem
An alarm can be Off, Set, Ringing, or Snoozed. It should ring when a fake clock reaches its set time, and snoozing should schedule another ring 30 minutes later.

## The catch
Actions such as setting, snoozing, advancing time, and cancelling are only valid in particular states; scattered conditionals can silently permit the wrong action.

## Pattern(s)
**State** keeps each mode's allowed actions and transitions together. `AlarmState` is the state interface; `OffState`, `SetState`, `RingingState`, and `SnoozedState` are concrete states; `AlarmClock` is the context. The clock uses `LocalTime` as a controllable fake clock, so the example never waits.

## How the pattern solves the catch
- Only Off accepts a new alarm time.
- Advancing the fake clock to or past the set time changes Set to Ringing.
- Snooze moves Ringing to Snoozed and schedules the next ring 30 minutes later.
- Cancel turns any active alarm off; invalid actions report why they were rejected.

## Alternatives
Use **Command** instead when alarm actions need undo, replay, or history; commands can record each action and its parameters.

## Where you'll meet it in test automation
- A fake clock makes time-based alarm and reminder tests fast and deterministic.
- State-specific tests can verify that invalid UI actions are rejected.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Alarm set for 07:05
Cannot set another alarm while alarm is Set
Alarm ringing at 07:05
Snoozed until 07:35
Alarm ringing again at 07:35
Alarm cancelled
Cannot cancel while alarm is Off
Final state: Off
```

`Naive` prints `Cannot snooze while alarm is Off`.

## Try this next
Add a stop action for a ringing alarm that returns it to Off without cancelling a scheduled alarm.
