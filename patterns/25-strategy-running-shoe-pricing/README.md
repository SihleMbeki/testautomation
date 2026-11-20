# 25 — Strategy: running shoe pricing

## Problem
A shop sells two running shoe models in full-price, demo, and second-hand condition. Demo shoes are 15% off and second-hand shoes are 40% off the listed price.

## The catch
Putting all discounts into growing conditionals makes pricing logic harder to extend and test. Monetary calculations must also avoid binary floating-point rounding errors.

## Pattern(s)
Strategy encapsulates each pricing rule behind `PricingStrategy`. `FullPrice`, `DemoPrice`, and `SecondHandPrice` calculate the amount for a `Shoe`, allowing the shoe's pricing behavior to be selected without a condition chain. Prices are represented with `BigDecimal`.

## How the pattern solves the catch
- Each condition has one small, independently testable pricing class.
- Demo pricing multiplies the listed amount by 0.85; second-hand pricing uses 0.60.
- Both shoe models can be sold under each condition without duplicating pricing rules.
- `BigDecimal` stores and calculates money, and output formats amounts in Rand with two decimal places.

## Alternatives
An enum with a discount rate can suit a fixed, very small set of rules. Strategy is useful when pricing rules may gain their own behavior or need to be exchanged independently.

## Where you'll meet it in test automation
- Test each pricing strategy with representative listed prices and exact decimal expectations.
- Select a pricing strategy in a test fixture to cover condition-specific checkout behavior.

## How to run
These examples target Java 17 and use only the standard library. From this directory, compile and run:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Both programs print:

```text
Swift — Full price: R 1,000.00
Pace — Full price: R 1,200.00
Swift — Demo (15% off): R 850.00
Pace — Demo (15% off): R 1,020.00
Swift — Second hand (40% off): R 600.00
Pace — Second hand (40% off): R 720.00
```

## Try this next
Add a clearance strategy and test that each model keeps its listed price while applying the new rule.
