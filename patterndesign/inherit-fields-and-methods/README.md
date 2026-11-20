# Inherit fields and methods

## Description

Inheritance lets a specialized class reuse accessible state and behavior from
a parent class, then add or refine behavior. Use it for a genuine “is a”
relationship where subclasses can stand in for the parent; prefer composition
when the relationship is only code reuse.

## Example

```java
class Test {
    private final String name;

    Test(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    void run() {
        System.out.println("Running " + name);
    }
}

class ApiTest extends Test {
    ApiTest(String name) {
        super(name);
    }

    void verifyStatus(int status) {
        System.out.println("HTTP status: " + status);
    }
}
```

`ApiTest` inherits the test name and `run()` operation, and adds API-specific
behavior.
