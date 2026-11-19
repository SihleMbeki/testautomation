# 17 — Facade: stopping a car

## Problem
A driver must follow several steps to park a manual car safely. The actions involve separate car systems. Callers should not need to coordinate those systems themselves.

## The catch
If each caller performs the steps independently, one can forget an action or run them in the wrong order. The sequence is safety-sensitive and should have one simple entry point.

## Pattern(s)
Facade gives callers a simpler interface to a group of subsystems. `CarStopFacade` coordinates `Brake`, `Gearbox`, `Handbrake`, `Lights`, and `Engine`, hiding the detailed parking sequence behind `stopManualCar()`.

## How the pattern solves the catch
- The facade owns the full stop sequence in one place.
- It applies the brake, selects gear 1, brakes further, selects neutral, engages the handbrake, turns off lights, then switches off the engine.
- Callers invoke one method instead of coordinating five subsystems.

## Alternatives
Template Method could model different stopping workflows for manual and automatic cars. An automatic car would omit the gear-1 action, while the facade here demonstrates the requested manual sequence.

## Where you'll meet it in test automation
- A test setup helper can hide several browser or device setup steps behind one method.
- A facade can expose a clear `stopAndVerify()` operation over lower-level controls.

## How to run
From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints the seven manual-car actions in their required order after its heading. `Naive` prints the same actions, but its caller has to manage each subsystem directly.

## Try this next
Add an automatic-car stop method that preserves the order while omitting gear 1.
