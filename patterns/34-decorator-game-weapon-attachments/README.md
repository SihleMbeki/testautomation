# Decorator - Game Weapon Attachments

## Problem
A friendly arcade game lets a player attach or remove a scope from a rifle while playing. Attachments can also be stacked, such as a silencer around a scoped rifle. The examples use fictional arcade effects rather than real-world weapon details.

## The catch
Creating classes such as `RifleWithScope` and `PistolWithScopeAndSilencer` for every combination makes the class count grow quickly.

## Pattern(s)
**Decorator** wraps a `Weapon` with another `Weapon` that adds behavior while keeping the same interface. `Weapon` is the component, `Rifle` and `Pistol` are concrete components, `WeaponDecorator` is the abstract decorator, and `Scope` and `Silencer` are concrete decorators. `Scope` changes aiming and passes firing through; `Silencer` changes the firing message and passes aiming through.

## How the pattern solves the catch
- Each decorator wraps any `Weapon`, so it works with either concrete weapon.
- The scope adds its zoom message before delegating the aim action.
- The silencer changes the fire message without changing the wrapped weapon.
- Reassigning the base rifle removes the scope at runtime; wrappers can also be stacked.

## Alternatives
Use **Builder** if attachments are selected once during setup and do not need to be added or removed later. Decorator fits runtime composition of independent features.

## Where you'll meet it in test automation
- Wrap an API client with logging or metrics while preserving its client interface.
- Compose optional test hooks around a reusable fixture or driver abstraction.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

`Main` prints:

```text
Base rifle:
Rifle: aiming at the arcade target.
Rifle fires: arcade target tagged!

Scope attached:
Scope: aiming with 4x zoom.
Rifle: aiming at the arcade target.
Rifle fires: arcade target tagged!

Scope removed:
Rifle: aiming at the arcade target.
Rifle fires: arcade target tagged!

Silencer and scope attached:
Scope: aiming with 4x zoom.
Rifle: aiming at the arcade target.
Silencer: quiet arcade sound.
Rifle fires: arcade target tagged!
```

`Naive` prints `Rifle: aiming at the arcade target.` and `Rifle fires: arcade target tagged!`.

## Try this next
Add a harmless second scope type and wrap the pistol with it without creating a combination-specific weapon class.
