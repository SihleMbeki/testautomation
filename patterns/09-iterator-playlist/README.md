# 09 — Iterator: playlist

## Problem
A playlist has songs, and callers should be able to request them in normal, reverse, or seeded-shuffle order without knowing how the order is stored. Callers should only need to ask for the next song; they should not manage indexes or ordering logic themselves.

## The catch
Returning the mutable song list leaks playlist internals and makes callers responsible for traversal. A shuffle must also be reproducible when given the same seed.

## Pattern and roles
The **Iterator** pattern separates traversal from the collection. `Playlist` is the aggregate and implements `Iterable<Song>`; `PlaylistIterator` is the custom iterator; `Song` is the item. `Playlist` creates iterators for forward, reverse, and seeded-shuffle traversal.

## How the pattern solves the catch
- `Playlist` keeps its song list private.
- Its `iterator()` returns a custom iterator in insertion order.
- `reverseIterator()` creates an iterator over a reversed copy.
- `shuffledIterator(seed)` shuffles a copy with `Random(seed)`, leaving the playlist unchanged.

## Where you'll meet it in test automation
- Iterate through a playlist and assert the emitted song titles match the expected order.
- Verify that two shuffle iterators with the same seed emit the same sequence.
- Verify reverse iteration does not change the order of the next normal iteration.

## How to run
From this directory:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

Expected output includes `FORWARD: ...`, `REVERSE: ...`, and two identical `SHUFFLE (seed 7): ...` lines, followed by the naive loop's manually indexed titles.

## Try this next
Add a filtered iterator that skips songs shorter than a requested duration, without exposing the playlist's backing list.
