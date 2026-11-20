# Strategy - Province Ticket Pricing

## Problem
A ticket costs R400 for travel within one province and R440 between provinces. Province names can be entered in different forms, such as `KZN` and `KwaZulu-Natal`.

## The catch
Mixing province cleanup, unknown-name handling, and fare rules in a single conditional makes each new province or fare rule harder to maintain.

## Pattern(s)
**Strategy** puts interchangeable fare calculations behind one interface. `FareStrategy` is the strategy interface; `IntraProvinceFare` and `InterProvinceFare` are concrete strategies; `TicketFareCalculator` is the context and selects a strategy after `ProvinceNames` normalizes and validates both names. All fare values use `BigDecimal`; the inter-province strategy applies a 10% rate and rounds to two places with `HALF_UP`.

## How the pattern solves the catch
- Normalize whitespace, case, and the KZN/KwaZulu-Natal aliases before comparing provinces.
- Select the intra-province or inter-province strategy from the normalized route.
- Reject unknown province names with a clear message instead of quoting a guessed fare.
- Keep monetary arithmetic in `BigDecimal` and make the two-decimal rounding rule explicit.

## Alternatives
Two simple fares could be a small conditional. Strategy becomes worthwhile when province-specific rules, discounts, or fare classes multiply and need independent tests.

## Where you'll meet it in test automation
- Parameterized route tests can check each fare strategy with province aliases.
- Tests can assert unknown input produces a clear validation message and no quote.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
KZN to KwaZulu-Natal: R400.00
KZN to Gauteng: R440.00
Cannot quote: Unknown province: Atlantis
```

`Naive` prints `Naive fare: R440.00`. For a custom route, run `java -cp out Main "KZN" "Gauteng"`.

## Try this next
Add a province-specific discount strategy and test that it still returns a two-decimal `BigDecimal`.
