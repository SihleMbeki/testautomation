# Factory - Light Colour

## Problem
A room needs to create a light chosen by colour. Red and green are available now, and orange may be added later.

## The catch
If room logic constructs concrete light classes directly, adding a colour spreads creation decisions into the room.

## Pattern(s)
**Factory** centralizes object creation behind a common type. `Light` is the product interface; `RedLight`, `GreenLight`, and `OrangeLight` are concrete products; `LightFactory` creates the requested product; `Main` acts as the room client.

## How the pattern solves the catch
- The room asks the factory for a `Light` instead of constructing a colour-specific class.
- The factory validates the requested colour and returns its matching light.
- Adding orange required one new product class and one factory branch.

## Alternatives
Use **Strategy** when an already-created object must swap its behavior. Rule of thumb: choose Factory to decide which object to create; choose Strategy to change the behavior of an existing object's collaborator.

## Where you'll meet it in test automation
- A factory can create named browser or test-data configurations from a scenario argument.
- Tests can request a particular light fixture without knowing its concrete class.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Red light is on
Green light is on
Orange light is on
```

`Naive` prints `Red light is on`. To try an argument, run `java -cp out Main green`.

## Try this next
Add a blue light and test both the default demonstration and `java -cp out Main blue`.
