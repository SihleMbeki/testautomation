# Factory and Singleton - Race Tickets

## Problem
The first 1,000 ticket purchasers receive a race number and a free shirt; later purchasers receive a race number only. Concurrent buyers must not receive duplicate race numbers or more than 1,000 shirts.

## The catch
A separate "are shirts left?" check and increment can race: many buyers may all observe that buyer 1,000 has not yet claimed a shirt. The boundary is easy to miss when testing only buyers 999, 1,000, and 1,001 one at a time.

## Pattern(s)
**Singleton** gives all ticket purchases one shared `RaceOffice`, whose `AtomicInteger` issues unique race numbers. **Factory** puts ticket creation and its early-bird package decision in `TicketFactory`; `Ticket` is the created product. The deliberately unsafe and safe `EarlyBirdCounter` implementations let the same factory demonstrate the boundary race and its atomic fix.

## How the pattern solves the catch
- The single-thread demonstration shows buyers 999, 1,000, 1,001, and 1,002 and their package decisions.
- Race numbers come from the thread-safe Singleton's atomic sequence.
- The unsafe counter starts at 999 and uses a barrier so all 20 test threads read the same boundary before updating; its over-give is repeatable.
- The safe counter uses compare-and-set on an `AtomicInteger`; 1,100 simultaneous buyers receive exactly 1,000 shirts.

## Alternatives
Use **Decorator** when perks can be stacked onto tickets, such as a shirt plus a meal voucher. Use **Strategy** when reward rules vary between races; Factory still creates the ticket with the chosen reward behavior.

## Where you'll meet it in test automation
- A synchronized or atomic shared allocator can issue unique fixture IDs to parallel tests.
- A controlled barrier can make a concurrency regression test reproducible at a resource limit.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` starts with these exact boundary lines:

```text
Buyer 999: race number 999, free shirt yes
Buyer 1000: race number 1000, free shirt yes
Buyer 1001: race number 1001, free shirt no
Buyer 1002: race number 1002, free shirt no
```

It then prints `Unsafe concurrent buyers at 1,000 boundary: 20 shirts (expected 1)` and `Safe concurrent buyers: 1000 shirts (expected 1000)`. `Naive` prints `Naive check: a shirt is available` and `Naive local sold count: 1000`.

## Try this next
Return an explicit ticket package type from the factory and add a second perk without changing race-number allocation.
