# 23 — Builder + Director: computer configurations

## Problem
A computer configuration has a CPU, GPU, RAM, storage, power supply, and cooling. The same parts can be assembled into gaming, professional, mining, or custom computers.

## The catch
Long constructors and repeated part assignment make presets difficult to read and easy to mix up. Preset assembly steps should be reusable while custom configurations remain possible.

## Pattern(s)
Builder creates a complex object step by step: `ComputerBuilder` defines part-setting operations, and `StandardComputerBuilder` collects and validates them into a `Computer`. `ComputerDirector` supplies gaming, professional, and mining recipes; callers can also use the builder directly for a custom configuration.

## How the pattern solves the catch
- Each named setter makes the part being assigned explicit.
- The director centralizes repeatable preset recipes.
- `build()` checks that all six components were supplied.
- Direct builder use supports a custom mix of parts.

## Alternatives
Abstract Factory is a fit only when the parts form compatible families that must be selected together, such as a vendor-specific set of CPU, motherboard, and memory. This example focuses on building configurations from explicit parts, so Builder is clearer.

## Where you'll meet it in test automation
- Build test fixtures with only the options relevant to a scenario.
- Use a director for repeatable browser, device, or environment presets.

## How to run
These examples target Java 17 and use only the standard library. From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints gaming, professional, and mining configurations with all six parts, followed by a custom configuration. `Naive` prints three configurations created through long constructors.

## Try this next
Add a low-power office preset and reject configurations that pair incompatible parts.
