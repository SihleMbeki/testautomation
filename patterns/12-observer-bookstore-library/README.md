# 12 — Observer: bookstore due-date views

## Problem
A bookstore lends books to accounts, each with a due date. As the library date advances, due-soon and overdue views should refresh automatically; the expired-loans view should show only overdue books.

## The catch
If the lending model directly refreshes each view, it needs to know which views exist and how they work. Adding a fines calculator or another view would require changing the lending system.

## Pattern and roles
The Observer pattern broadcasts date changes to views that subscribe, without the lending system knowing their display logic. `Bookstore` is the subject and `LibraryObserver` is the observer interface. `NotificationView` and `ExpiredView` are concrete observers; `LendingAccount` groups its `BookLoan` books and due dates. `FineCalculator` is an independent extension point used by the expired view, not a dependency of the bookstore subject.

## How the pattern solves the catch
- Views register and unregister with the bookstore.
- Advancing the library date notifies observers, which query current account loans.
- The notification view reminds accounts about loans due within three days and loans already overdue.
- The expired view filters strictly to dates before today.
- A replaceable `FineCalculator` computes and formats example overdue fines in Rand.

## Where you'll meet it in test automation
- Advance the date and assert a loan due within three days appears in notifications.
- Advance past the due date and assert notifications still remind the account while the expired view shows only overdue loans.
- Unregister a view and assert later date changes do not cause its update message.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output first shows `REMINDERS` for the book due in two days, then shows the overdue reminder plus `EXPIRED` and a Rand fine after the date advances. The naive version manually calls both views.

## Try this next
Add a `FineCalculator` implementation with a grace period, then inject it into the overdue view without modifying `Bookstore`.
