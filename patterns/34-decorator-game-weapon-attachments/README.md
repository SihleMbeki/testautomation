# Decorator - Game Weapon Attachments

## Problem
A friendly arcade blaster can be customized with optional visual and sound effects. Players should be able to combine attachments without creating a separate class for every possible loadout.

## The catch
Putting all attachment combinations into the base weapon or a growing conditional creates many combinations and couples the base behavior to every add-on.

## Pattern(s)
**Decorator** wraps an object with another object that keeps the same interface and adds behavior. `GameWeapon` is the component interface; `ArcadeBlaster` is the concrete component; `WeaponAttachment` is the abstract decorator; `GlowCharm`, `ConfettiTrail`, and `SoundBadge` are concrete decorators. The examples add only friendly arcade effects and no real-world weapon details.

## How the pattern solves the catch
- Each attachment wraps any existing `GameWeapon` and delegates the operations it does not change.
- Add-ons can be combined in different orders at runtime.
- The base blaster stays independent of optional visual and sound effects.

## Alternatives
Use **Strategy** when one behavior should be selected instead of composed with others. Decorator is useful when several independent add-ons need to stack.

## Where you'll meet it in test automation
- A test fixture can wrap a base client with logging, retries, or metrics without changing its interface.
- UI test setups can compose optional capabilities around a shared page or driver abstraction.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Loadout: Arcade blaster + sound badge + confetti trail + glow charm
Glow charm: target sparkles
Arcade blaster: aiming at the target
Arcade blaster: friendly ping!
Sound badge: cheerful arcade chime!
Confetti trail: colorful confetti!
```

`Naive` prints `Arcade blaster: aiming at the target` and `Arcade blaster: friendly ping!`.

## Try this next
Add a harmless color-shift attachment that decorates the loadout description and one action.
