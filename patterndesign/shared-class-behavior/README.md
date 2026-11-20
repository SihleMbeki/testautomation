# Share behavior across related classes

## Description

Put genuinely common state and implementation in a shared base class when
related types have a stable common contract. Subclasses can inherit that
behavior while implementing their own details. Avoid a base class created
only to save a few lines, or one that forces unrelated classes into the same
hierarchy.

## Example

```java
abstract class TestStep {
    private final String description;

    TestStep(String description) {
        this.description = description;
    }

    void logStart() {
        System.out.println("Starting: " + description);
    }

    abstract void execute();
}

class LoginStep extends TestStep {
    LoginStep() {
        super("log in");
    }

    @Override
    void execute() {
        System.out.println("Submitting login form");
    }
}
```

All test steps share their description and start logging; each supplies its
own execution behavior.
