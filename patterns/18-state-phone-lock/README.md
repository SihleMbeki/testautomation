# 18 — State: phone lock

## Problem
A locked phone ignores a pressed key. After unlocking, a key can dial a number, and the phone can be locked again.

## The catch
Scattering locked-versus-unlocked conditionals across every phone action makes behavior hard to extend and easy to contradict. The action should depend on the phone's current state.

## Pattern(s)
State represents each mode as an object with its own behavior. `Phone` delegates to its `PhoneState`; `LockedState` ignores keys and unlocks, while `UnlockedState` dials keys and locks the phone.

## How the pattern solves the catch
- `Phone` forwards actions to its current state.
- A key press while locked is ignored.
- Unlocking changes behavior so a key press dials.
- Locking changes behavior back without conditionals in `Phone`.

## Alternatives
For only two simple states, a small conditional may be sufficient. State becomes more useful as states and state-specific actions grow.

## Where you'll meet it in test automation
- Model an application workflow such as logged-out, authenticated, and expired sessions.
- Model a device's readiness state before sending input.

## How to run
These examples target Java 17 and use only the standard library. From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Both programs print that the first key is ignored, unlock the phone, dial `555-0100`, and lock it again. `Main` delegates each behavior to a state object.

## Try this next
Add a muted state that accepts keys but produces no dial output.
