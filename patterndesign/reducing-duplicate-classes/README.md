# Reduce duplicate classes

## Description

When several classes differ only by a small, fixed option, one class with
explicit configuration can be simpler than maintaining near-identical
classes. Keep distinct types when their rules or behavior genuinely differ;
avoid replacing duplication with a large conditional full of special cases.

## Example

Instead of separate short and long timeout classes:

```java
class RequestTimeout {
    private final int seconds;

    RequestTimeout(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("seconds must be positive");
        }
        this.seconds = seconds;
    }

    int seconds() {
        return seconds;
    }
}

RequestTimeout quickCheck = new RequestTimeout(5);
RequestTimeout fullRun = new RequestTimeout(60);
```

One class represents the same concept with different values, rather than
duplicating its fields and accessors.
