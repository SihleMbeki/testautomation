# Facade - Leaving Home

## Problem
Leaving home requires several subsystem operations: switch off lights, close windows, lock the door, and arm the alarm, in that order. Clients should not need to understand or coordinate all four systems for this routine.

## The catch
Remembering four separate operations makes it easy to forget one or perform them in the wrong order. Duplicating that sequence at every call site also spreads the coordination logic around the program.

## Pattern and roles
**Facade:** A facade offers one simple operation that coordinates a group of more detailed subsystem operations. `LeavingHomeFacade` is the facade; `Lights`, `Windows`, `DoorLock`, and `Alarm` are subsystem classes; `Main` is the client.

## How the pattern solves the catch
- Keep each home subsystem responsible for its own operation.
- Construct the facade with the subsystems it coordinates.
- Expose one `leaveHome()` operation.
- Run the subsystem operations in the required sequence inside the facade.

## Where you'll meet it in test automation
- A test-automation setup facade can start a browser, seed data, and sign in behind one setup call.
- A page-object workflow can offer one `completeCheckout()` operation that coordinates address, payment, and confirmation steps.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`):

```text
FACADE - Leaving home
Lights: off
Windows: closed
Door: locked
Alarm: armed
```

`Naive` starts with `NAIVE - Client coordinates every subsystem` and prints the same operations in order.

## Try this next
Add a thermostat subsystem and set it to away mode in the facade's leaving sequence.
