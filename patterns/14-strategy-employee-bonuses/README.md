# 14 — Strategy: employee bonus

## Problem
An employee bonus can be calculated from either a merit rating or an employee grade. Each employee should use a selected rule, and that rule should be changeable at runtime.

## The catch
Putting all bonus rules in a growing `if/else` block couples employee data to every policy and makes policy changes harder to test independently.

## Pattern and roles
The Strategy pattern puts interchangeable bonus algorithms behind one contract so an employee can change its calculation rule at runtime. `BonusStrategy` is the strategy interface. `MeritRatingBonus` and `GradeBonus` are concrete strategies. `Employee` is the context and delegates its bonus calculation to its currently selected strategy.

## How the pattern solves the catch
- The employee holds one `BonusStrategy`, not a policy-specific conditional tree.
- Merit rating maps a 1–5 rating to a 2%-per-point salary bonus.
- Grade maps A, B, or C to 10%, 5%, or 2%.
- `setBonusStrategy` changes the calculation at runtime.

## Where you'll meet it in test automation
- Assert rating 4 on salary R50,000 produces a R4,000 merit bonus.
- Assert grade B on salary R50,000 produces a R2,500 bonus.
- Change an employee from merit to grade strategy and assert the next calculation uses the new rule.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output shows the merit bonus `R4000.00`, the grade-B bonus `R2500.00`, and the first employee's changed bonus after switching strategy.

## Try this next
Add a tenure-based bonus strategy and switch an employee to it without changing `Employee`.
