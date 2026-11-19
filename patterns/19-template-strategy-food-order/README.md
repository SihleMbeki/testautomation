# 19 — Template Method + Strategy: food orders

## Problem
Every food order confirms an address, applies a voucher, takes payment, and then fulfils the order. The customer may choose delivery with a PIN or later collection from the store.

## The catch
The first three steps must always happen in the same order, but fulfilment varies. Duplicating the whole workflow for each fulfilment choice risks inconsistent order processing.

## Pattern(s)
Template Method defines the fixed workflow: `FoodOrder.placeOrder()` calls the four steps in order, and `OnlineFoodOrder` provides the fulfilment hook. Strategy makes the variable step swappable: `DeliveryFulfilment` and `CollectionFulfilment` implement `FulfilmentStrategy`.

## How the pattern solves the catch
- `placeOrder()` is the single, fixed order skeleton.
- Address confirmation, voucher application, and payment cannot be skipped or reordered by the caller.
- A fulfilment strategy supplies delivery with PIN or later store collection.
- Another fulfilment option can be added without duplicating the common steps.

## Alternatives
Template Method alone could use subclasses for each fulfilment type, but Strategy allows fulfilment behavior to be selected or replaced at runtime.

## Where you'll meet it in test automation
- A test fixture can keep arrange/act/cleanup steps fixed while varying a test scenario.
- A payment or fulfilment test can swap a strategy without changing the order workflow.

## How to run
From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Each run prints address confirmation, voucher application, and payment in that order, followed by delivery/PIN and collection fulfilment respectively. `Naive` repeats the workflow manually.

## Try this next
Add courier collection as a new strategy while keeping the same template steps.
