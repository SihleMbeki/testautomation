# Strategy and Factory - Game Weapons

## Problem
A friendly arcade game lets a player choose between a rifle and a pistol. Either choice must support the same aim-and-fire actions, and the player can switch during the game.

## The catch
If the player's actions contain a branch for every weapon, adding another choice makes the player harder to change and test.

## Pattern(s)
**Strategy** makes the equipped weapon interchangeable: `Weapon` is the strategy interface; `Rifle` and `Pistol` are concrete strategies; `Player` is the context and can switch its current weapon. **Factory** is optional here: `WeaponFactory` turns a typed choice into the matching strategy. This is a friendly arcade simulation only; its output has no real-world weapon instructions.

## How the pattern solves the catch
- Give each game weapon the same `aim()` and `fire()` operations.
- Let the player switch strategies without changing the player's action code.
- Use the optional factory to validate and create the player's typed selection.

## Alternatives
The player can receive a `Weapon` directly when a game already constructs its choices. Keep the factory when a menu, save file, or command-line choice needs to select a concrete game weapon.

## Where you'll meet it in test automation
- A game test can swap a fake strategy to verify player actions without rendering a level.
- A factory can turn a test's selected character loadout into reusable test objects.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Player switched to rifle
Rifle: aiming at the arcade target
Rifle: friendly ping!
Player switched to pistol
Pistol: aiming at the arcade target
Pistol: friendly pop!
```

`Naive` prints `Rifle: friendly ping!`.

## Try this next
Add a harmless third arcade weapon strategy and switch to it without adding a branch to `Player`.
