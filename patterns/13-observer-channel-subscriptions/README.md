# 13 — Observer: channel subscriptions

## Problem
A channel needs to publish messages to its current subscribers. People must be able to subscribe and unsubscribe, and an unsubscribed person must stop receiving notifications.

## The catch
Keeping a fixed list of recipients in publishing code makes membership changes awkward and risks notifying people who have left.

## Pattern and roles
The Observer pattern lets a channel broadcast each post to the listeners that currently subscribe, without knowing their concrete implementation. `Channel` is the subject; `ChannelSubscriber` is the observer interface; `Subscriber` is a concrete observer. The channel manages subscriptions and notifies only the observers currently registered.

## How the pattern solves the catch
- `subscribe` registers a subscriber once.
- `publish` sends the message to a snapshot of registered subscribers.
- `unsubscribe` removes a subscriber.
- Later publications no longer notify removed subscribers.

## Where you'll meet it in test automation
- Subscribe two users and assert both receive the first publication.
- Unsubscribe one user and assert only the remaining subscriber receives the next publication.
- Publish with no subscribers and assert no notification is emitted.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output shows Ava and Ben receiving the first message, then only Ben receiving the second. The naive output has to call each recipient directly.

## Try this next
Add a subscriber preference that filters messages by topic while keeping channel publishing independent of subscriber types.
