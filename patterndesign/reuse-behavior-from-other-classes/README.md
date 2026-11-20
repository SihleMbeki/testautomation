# Reuse behavior from other classes

## Description

Reuse behavior by asking an existing object that already owns the relevant
responsibility to do the work. This composition-based approach avoids copying
implementation and does not require the requesting class to inherit from the
helper.

## Example

```java
class RetryPolicy {
    boolean shouldRetry(int attempts) {
        return attempts < 3;
    }
}

class ApiClient {
    private final RetryPolicy retryPolicy = new RetryPolicy();

    boolean shouldRetry(int attempts) {
        return retryPolicy.shouldRetry(attempts);
    }
}
```

`ApiClient` reuses the retry decision by delegating it to `RetryPolicy`.
