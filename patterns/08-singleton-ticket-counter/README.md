# Singleton - Shared Parking Ticket Counter

## Problem
Multiple parking gates must issue unique ticket numbers from one shared counter. A naive singleton that increments without synchronization can lose updates under concurrency, so distinct gates can receive duplicate numbers.

## The catch
If each gate owns a separate counter, two cars can receive the same number. Even a shared singleton can issue duplicates when two threads read the current number before either writes its increment; a WebDriver, in contrast, is usually isolated per test thread with `ThreadLocal<WebDriver>`.

## Pattern and roles
**Singleton:** A singleton provides one shared instance through a controlled access point; its state still needs synchronization when shared across threads. `UnsafeTicketCounter` is a deliberately non-thread-safe singleton for the race demonstration; `TicketCounter` is a synchronized singleton; `RaceDemo` simulates concurrent gate callers; `Main` compares results.

## How the pattern solves the catch
- Use a private constructor and one accessor to expose a shared counter.
- In the unsafe example, intentionally separate read and write with a tiny delay to make lost updates observable.
- Run 100 allocations from each of three gate threads and count duplicate issued numbers.
- In the safe implementation, synchronize the entire increment and repeat the same test.
- Use ThreadLocal for independently isolated per-thread WebDriver instances; it is an alternative, not a Singleton.

## Where you'll meet it in test automation
- A test suite can use a synchronized shared ID allocator when concurrent tests require unique fixture IDs.
- A WebDriver-per-test-thread setup can use `ThreadLocal<WebDriver>` to avoid sharing one browser session between parallel tests.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main`): `Unsafe duplicate ticket numbers: <positive number>` (varies by run), followed by `Synchronized duplicate ticket numbers: 0`. The unsafe `Naive` run also reports a positive, variable duplicate count. `Main` additionally explains that per-thread WebDrivers should use `ThreadLocal<WebDriver>`, not a shared Singleton.

## Try this next
Replace synchronized increment with `AtomicInteger.incrementAndGet()` and rerun the same concurrent allocation test.
