# 10 — Template Method: card payments

## Problem
Netflix card payments share a required sequence: validate the card, check available balance or credit limit, charge the account, and issue a receipt. A debit card charges the purchase amount, while a credit card adds a small processing fee.

## The catch
If each payment type implements its own complete workflow, the steps can drift, be reordered, or omit a receipt. Only the account check and charge amount need to vary.

## Pattern and roles
`CardPayment` defines the **Template Method** in `pay`, with fixed validation, balance/limit check, charging, and receipt steps. `DebitCardPayment` and `CreditCardPayment` provide the variable account check and amount; the credit subclass adds the processing fee.

## How the pattern solves the catch
- `pay` is `final`, so subclasses cannot reorder the workflow.
- Shared card validation rejects a blank cardholder.
- The debit implementation checks and reduces its balance.
- The credit implementation checks its limit and charges the purchase plus a 2% fee.

## Where you'll meet it in test automation
- Assert an invalid card stops before any charge or receipt.
- Assert a debit purchase lowers its balance by exactly the purchase amount.
- Assert a credit transaction includes the documented 2% fee in its charge and receipt.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output contains `DEBIT charged R100.00`, `CREDIT charged R102.00`, and a receipt for each successful payment. The naive output shows separate workflows.

## Try this next
Add a prepaid card implementation that checks a stored balance and uses the same fixed payment sequence.
