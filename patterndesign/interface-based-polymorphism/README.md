# Interface-based polymorphism

## Description

Define a capability as an interface and let a class use any implementation of
that interface. Implementations can vary without changing the class that
depends on the capability.

## Example

```java
interface Browser {
    void open(String url);
}

class ChromeBrowser implements Browser {
    public void open(String url) {
        System.out.println("Chrome opens " + url);
    }
}

class FirefoxBrowser implements Browser {
    public void open(String url) {
        System.out.println("Firefox opens " + url);
    }
}

class LoginCheck {
    private final Browser browser;

    LoginCheck(Browser browser) {
        this.browser = browser;
    }

    void run() {
        browser.open("https://example.test/login");
    }
}
```

`LoginCheck` works with either browser implementation through the same
interface.
