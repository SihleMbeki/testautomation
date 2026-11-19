# Decorator - Coffee Add-ons

## Problem
Coffee starts at R20, and customers can add milk, sugar, or cream in any combination, including double milk. A subclass for every combination would multiply classes and still make new add-ons awkward.

## The catch
Creating a subclass for every combination quickly produces classes such as `CoffeeWithMilkAndSugar` and `CoffeeWithDoubleMilkAndCream`. Supporting one more extra multiplies the combinations again.

## Pattern and roles
**Decorator:** A decorator wraps an object with the same interface to add behavior or cost, and multiple wrappers can be stacked at runtime. `Coffee` is the component interface; `PlainCoffee` is the concrete component; `CoffeeDecorator` is the abstract wrapper; `Milk`, `Sugar`, and `Cream` are concrete decorators.

## How the pattern solves the catch
- Define common `description()` and `cost()` operations.
- Represent plain coffee as the base component at R20.
- Wrap a coffee with one decorator per add-on and sum its cost.
- Allow decorators to stack repeatedly, including Milk(Milk(coffee)).

## Where you'll meet it in test automation
- A test request builder can wrap a base HTTP request with authentication and logging concerns independently.
- A test report output can be decorated with timestamps or formatting without changing the report producer.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`):

```text
DECORATOR - Coffee add-ons (Rand)
Plain coffee: R20.00
Plain coffee, milk, milk, sugar, cream: R40.00
```

`Naive` starts with `NAIVE - Flags and combination arithmetic` and prints the same R40.00 combination.

## Try this next
Add a cinnamon decorator costing R3 and verify it can be stacked with existing add-ons.
