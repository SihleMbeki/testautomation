# 11 — Decorator: tourist tickets

## Problem
A tourist needs a ticket whose price can include a base entry, an optional business-class or VIP upgrade, and any combination of meal, insurance, and luggage extras. The ticket should report its description and total without requiring a separate class for every combination.

## The catch
Inheritance for every combination (for example, VIP plus meal plus luggage) quickly creates a large class hierarchy. Business-class and VIP upgrades are alternatives to one another; the extras are the options that clearly benefit from stacking.

## Pattern and roles
`Ticket` is the component interface and `BasicTicket` is the concrete component (R150). `TicketDecorator` is the decorator base. `BusinessClassDecorator` (+R10) and `VipDecorator` (+R30) are alternative upgrade decorators; `MealDecorator` (+R25), `InsuranceDecorator` (+R15), and `LuggageDecorator` (+R20) are stackable extras and can be repeated.

## How the pattern solves the catch
- Each decorator wraps a `Ticket` and delegates its description and price.
- Add-ons compose at runtime without a class per combination.
- The base entry costs R150.
- Repeated extras contribute their price each time; the example adds two meals.
- Business and VIP are shown independently as alternative base options, not as a recommended stack.

## Where you'll meet it in test automation
- Assert a basic ticket costs R150.
- Assert a ticket with meal and insurance costs R190 and describes both extras.
- Assert two luggage decorators add R40; verify business and VIP prices independently.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output includes `R215.00` for the base ticket plus two meals and insurance, `R160.00` for business, and `R180.00` for VIP. The naive output prints a hard-coded combination.

## Try this next
Add a priority-boarding decorator and test it both alone and with multiple stackable extras.
