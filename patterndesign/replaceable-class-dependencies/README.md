# Replaceable class dependencies

## Description

Pass a class the objects it needs rather than creating those dependencies
internally. This makes implementations easier to replace, configure, and test.

## Example

```java
interface Clock {
    long currentTimeMillis();
}

class Session {
    private final Clock clock;

    Session(Clock clock) {
        this.clock = clock;
    }

    boolean isExpired(long expiresAt) {
        return clock.currentTimeMillis() >= expiresAt;
    }
}
```

Production code can pass a system clock; a test can pass a predictable clock
to check expiration without waiting for real time to pass.
