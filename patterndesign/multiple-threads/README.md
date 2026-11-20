# Multiple threads

## Description

Multiple threads can execute code at the same time and access the same
objects. Protect shared mutable state so concurrent operations do not lose
updates or observe inconsistent values. Use the simplest synchronization that
fits the workload, and avoid sharing mutable state when possible.

## Example

```java
class TicketCounter {
    private int nextTicket = 1;

    synchronized int issueTicket() {
        return nextTicket++;
    }
}
```

The synchronized method ensures concurrent callers receive distinct ticket
numbers. Synchronization does not automatically make other shared fields or
operations thread-safe.
