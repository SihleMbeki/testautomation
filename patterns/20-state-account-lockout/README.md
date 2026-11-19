# 20 — State: account lockout

## Problem
An active account allows up to three failed logins. Each failure shows how many attempts remain, and the third failure locks the account; later logins on a locked account are rejected.

## The catch
Login rules become scattered conditionals when every caller must track failures, success resets, and lock status. In particular, a correct password must not reopen an account after it has locked.

## Pattern(s)
State gives `Account` an `AccountState` object that handles login behavior. `ActiveState` counts failures, reports attempts remaining, locks after the third failure, and resets the counter after a successful login; `LockedAccountState` rejects every login.

## How the pattern solves the catch
- The active state reports two, one, then zero remaining attempts as failures accumulate.
- On the third failure the account changes to `LockedAccountState`.
- Further logins in the locked state always report `Account locked.`
- A successful active login resets the counter; the example demonstrates this on a separate fresh account.

## Alternatives
A straightforward boolean and counter can work for this small example, but state-specific behavior avoids repeating account-status branches as rules grow.

## Where you'll meet it in test automation
- Test authentication flows with locked, active, and reset account fixtures.
- Verify that retry actions are unavailable after a lockout transition.

## How to run
From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints two then one attempts remaining, locks on the third failure, rejects the next login, and then shows a fresh account's failure followed by a successful login and counter reset. `Naive` demonstrates equivalent behavior with inline conditionals.

## Try this next
Add an administrator unlock operation that transitions a locked account back to active.
