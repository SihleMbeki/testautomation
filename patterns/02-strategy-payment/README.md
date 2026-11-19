# Strategy - Payment Methods

## Problem
A checkout must accept card, cash, or EFT payments and print the amount and method-specific fee. Putting every calculation in a growing if/else chain makes checkout harder to extend and test.

## The catch
If payment choices live in one growing if/else block, every new method makes checkout harder to read, change, and test.

## Pattern and roles
**Strategy:** The context delegates an operation to one interchangeable algorithm, so the chosen behavior can change without branching through the checkout logic. `PaymentStrategy` is the strategy interface; `CardPayment`, `CashPayment`, and `EftPayment` are concrete strategies; `Checkout` is the context.

## How the pattern solves the catch
- Give every payment strategy a common `pay(amount)` operation.
- Put each method's fee calculation and receipt output in its own class.
- Inject the selected strategy into Checkout.
- Add new payment behavior by adding a strategy instead of expanding a conditional.

## Where you'll meet it in test automation
- A test suite can inject a fake payment strategy to verify checkout totals without contacting a payment gateway.
- A UI automation flow can select a payment strategy fixture (card, cash, or EFT) for the same checkout steps.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`):

```text
STRATEGY - Payment methods (Rand)
Card payment R250.00 fee R5.00
Cash payment R250.00 fee R0.00
EFT payment R250.00 fee R2.50
```

`Naive` starts with `NAIVE - Growing payment if/else` and prints the card branch.

## Try this next
Add a wallet payment strategy with its own fee and run it through Checkout without editing existing strategies.
