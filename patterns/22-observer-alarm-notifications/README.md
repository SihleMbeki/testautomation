# 22 — Observer: alarm notifications

## Problem
An alarm sensor detects an object and notifies the owner. The owner wants a phone notification, an email, and a phone call, and may want to add SMS later.

## The catch
Hard-coding owners and notification channels into the sensor couples detection to delivery. Adding a channel should not require changing sensor detection behavior.

## Pattern(s)
Observer lets `AlarmSensor` notify registered `AlarmObserver` objects when it detects something; `AlarmOwner` receives the event. The owner delegates delivery to `NotificationChannel` implementations: `PhoneNotification`, `EmailNotification`, and `PhoneCallNotification`.

## How the pattern solves the catch
- The sensor reports detection to observers without knowing notification details.
- The owner independently chooses its channels.
- Each channel handles one delivery type.
- SMS can be added as another channel without editing `AlarmSensor`.

## Alternatives
An event bus or message broker can be useful when notifications cross process boundaries or require durable delivery. Direct observers keep this example small.

## Where you'll meet it in test automation
- Observe application notifications and assert that subscribers receive the expected event.
- Add a test-only observer to record alarm events without changing the sensor.

## How to run
From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Both programs print a movement detection followed by phone notification, email, and phone call messages in that order. `Main` connects the owner as an observer.

## Try this next
Implement an `SmsNotification` channel and register it with the owner.
