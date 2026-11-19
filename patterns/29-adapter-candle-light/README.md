# Adapter - Candle Light

## Problem
A room controls lights through `turnOn()` and `turnOff()`. An existing `Candle` instead offers `light()` and `blowOut()`, and its class cannot be changed.

## The catch
Changing the room to understand each device's different method names couples room behavior to every light type.

## Pattern(s)
**Adapter** translates one interface into another without changing the adapting client or the incompatible class. `Light` is the target interface; `Candle` is the adaptee; `CandleAdapter` translates the calls; `Room` is the client.

## How the pattern solves the catch
- The room continues to call `turnOn()` and `turnOff()`.
- The adapter maps those calls to `light()` and `blowOut()`.
- The candle remains unchanged and can now be supplied wherever `Light` is expected.

## Alternatives
Use **Factory** when the issue is choosing which compatible object to create. Adapter is for making an existing incompatible object fit; Factory is for deciding which object to create.

## Where you'll meet it in test automation
- An adapter can normalize different test-data providers behind one fixture interface.
- A legacy test library can be wrapped to match the methods expected by newer tests.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Both `Main` and `Naive` print:

```text
Candle is lit
Candle is blown out
```

`Main` routes the calls through `Room` and `CandleAdapter`; `Naive` calls the candle methods directly.

## Try this next
Add an adapter for another existing device with a different on/off vocabulary.
