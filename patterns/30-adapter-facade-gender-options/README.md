# Adapter and Facade - Gender Options

## Problem
A form displays native Male and Female options and options from an external provider that cannot be changed. The provider returns codes `X` and `Y`, rather than the labels the form displays.

## The catch
Without a common format, display code must understand each source's representation and repeat the work of combining those sources.

## Pattern(s)
**Adapter** translates the external provider's codes into the application's `GenderOption` format: `ExternalGenderProvider` is the adaptee and `ExternalGenderAdapter` is its adapter. `NativeGenderSource` supplies the native Male and Female options. **Facade** provides one simple access point: `GenderFacade.getAllGenders()` combines both sources; `GenderDisplay.displayGender()` displays all four options in the same way. Here `X` is shown as Neutral and `Y` as Prefer not to say.

## How the pattern solves the catch
- Both sources supply the same `GenderOption` type.
- The adapter maps `X` and `Y` without modifying the external provider.
- The facade combines native and adapted options in one `getAllGenders()` call.
- One `displayGender()` method renders every option, including the neutral choice.

## Alternatives
If only one source is ever needed, call its adapter directly and omit the facade. The facade is useful here because the client needs a unified list from multiple sources.

## Where you'll meet it in test automation
- A facade can give tests one setup method over multiple identity or fixture providers.
- An adapter can normalize third-party data formats before assertions compare them.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Gender option: Male
Gender option: Female
Gender option: Neutral
Gender option: Prefer not to say
```

`Naive` prints `External gender codes: [X, Y]`.

## Try this next
Add a third external code and map it to a display label without changing `GenderDisplay`.
