# Builder - Pizza Orders

## Problem
A pizza has required and optional choices: size, base, cheese, and many toppings. A long constructor full of positional values is hard to read and becomes error-prone when optional choices are added.

## The catch
With a long positional constructor, callers must remember what each boolean or string means. Adding another optional topping makes every call harder to read and easier to get wrong.

## Pattern and roles
**Builder:** A builder creates a complex object through clear, named steps and can supply sensible defaults for optional choices. `Pizza` is the product; `Pizza.Builder` is the builder; `Main` is the client that selects options and builds it.

## How the pattern solves the catch
- Give the builder sensible defaults for size, base, and cheese.
- Use named fluent methods for size, base, cheese, and toppings.
- Allow any number of toppings by accumulating them in a collection.
- Build a final Pizza with a readable description.

## Where you'll meet it in test automation
- A test fixture builder can supply defaults for a user while allowing each test to override only relevant fields.
- A browser-options builder can name browser, headless mode, and timeout settings rather than relying on positional arguments.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`):

```text
BUILDER - Pizza orders
Default: medium pizza, classic base, cheese yes, toppings: none
Custom: large pizza, thin base, cheese yes, toppings: mushroom, olive, pepper
```

`Naive` starts with `NAIVE - Long positional constructor` and prints the large thin pizza with three toppings.

## Try this next
Add an optional stuffed-crust setting with a sensible default and include it in the order description.
