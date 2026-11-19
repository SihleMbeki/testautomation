# 24 — Observer: fire sprinklers

## Problem
Smoke sensors monitor rooms 1 and 2. When smoke is detected in a room, only the sprinkler in that room should activate.

## The catch
Hard-wiring each sensor to its sprinkler makes the system brittle when rooms or response devices change. A sensor should report smoke without knowing which devices are attached.

## Pattern(s)
Observer lets `SmokeSensor` notify registered `FireObserver` objects when smoke is detected. Each `Sprinkler` observes the event and activates only when the event's room number matches its own.

## How the pattern solves the catch
- Sprinklers register with sensors rather than being directly called by sensor logic.
- A room-1 event activates only the room-1 sprinkler.
- A room-2 event activates only the room-2 sprinkler.
- Other response devices can observe the same sensor without modifying it.

## Alternatives
A Mediator, such as a central fire panel, can coordinate more complex building-wide rules and device interactions. Direct observers are sufficient for this matching-room example.

## Where you'll meet it in test automation
- Verify that an event from one device reaches only the matching subscribed component.
- Use observers to capture emitted events while testing sensors in isolation.

## How to run
From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Both programs print smoke detection for rooms 1 and 2 and activate only the corresponding room's sprinkler.

## Try this next
Add a building alarm observer that activates for smoke in either room.
