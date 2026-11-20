# 21 — Observer + Strategy: marathon leaderboard

## Problem
A marathon feed receives runner time updates while several viewers follow the live leaderboard. Viewers need the top 10 for male, female, and combined categories.

## The catch
If the feed directly updates each display and computes each category itself, adding viewers or ranking rules changes the feed. A result should reach interested viewers without the feed knowing who they are.

## Pattern(s)
Observer lets `MarathonLeaderboard` notify registered `LeaderboardObserver` viewers whenever a runner update arrives; `LeaderboardViewer` displays updates. Strategy delegates ranking to `RankingStrategy` implementations, here `CategoryRankingStrategy` instances for Male, Female, and Combined. The feed publishes runner data without knowing its viewers or their categories.

## How the pattern solves the catch
- Viewers register with the leaderboard and receive each deterministic update.
- The leaderboard does not depend on specific viewer classes.
- A ranking strategy selects and orders each category, limiting output to ten.
- The same feed can notify new viewers without changing ranking code.

## Alternatives
An event bus could distribute updates when the application needs broader, asynchronous delivery. This small example uses direct observer notifications for clarity.

## Where you'll meet it in test automation
- Subscribe multiple test listeners to application events and assert each receives the event.
- Swap ranking strategies to test category-specific sorting independently.

## How to run
These examples target Java 17 and use only the standard library. From this directory, compile and run:

```text
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Each of three runner updates prints all three category leaderboards to both viewers. The combined order is Ben, Cara, then Ava; category output contains only matching runners.

## Try this next
Add a strategy that breaks equal-time ties by runner bib number.
