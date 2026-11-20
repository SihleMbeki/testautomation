# State-dependent behavior

## Description

An object's valid operations can depend on its current state. Represent state
explicitly and make transitions visible, so invalid actions can be rejected
instead of silently producing inconsistent data. For a few simple states, an
enum and a switch may be sufficient; more complex behavior may call for
separate state objects.

## Example

```java
enum RunState {
    READY, RUNNING, FINISHED
}

class TestRun {
    private RunState state = RunState.READY;

    void start() {
        if (state != RunState.READY) {
            throw new IllegalStateException("Only a ready run can start");
        }
        state = RunState.RUNNING;
    }

    void finish() {
        if (state != RunState.RUNNING) {
            throw new IllegalStateException("Only a running test can finish");
        }
        state = RunState.FINISHED;
    }
}
```

The methods enforce the allowed `READY -> RUNNING -> FINISHED` transition
sequence.
