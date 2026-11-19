# Factory - Animal Sounds

## Problem
The program accepts `dog`, `cat`, or `cow` and should create the matching animal and print its sound. If client code directly constructs concrete animals in several places, adding goat means those callers need edits.

## The catch
Centralize the choice of concrete product in one factory, keeping callers dependent on the Animal abstraction.

## Pattern and roles
**Simple Factory (creation centralized in one factory):** The client asks for an animal by name while one factory handles the choice of concrete class. `Animal` is the product interface; `Dog`, `Cat`, and `Cow` are concrete products; `AnimalFactory` owns the creation choice; `Main` is the client.

## How the pattern solves the catch
- Define a common `Animal` interface with `speak()`.
- Implement one concrete class for each supported animal.
- Use `AnimalFactory.create(name)` to validate input and create the right class.
- Keep Main and callers independent of concrete constructors.

## Where you'll meet it in test automation
- A UI test factory can create a page object for a named page while test cases use the common page contract.
- A test-data factory can return a chosen fixture type (such as guest or member) behind one creation method.

## How to run
Run these commands from this folder:

```bash
javac -d out *.java
java -cp out Main
java -cp out Naive
```

**Expected output** (`Main` with no arguments):

```text
FACTORY - Animal sounds
dog: Woof!
```

`java -cp out Main cat` prints `cat: Meow!`; `java -cp out Main cow` prints `cow: Moo!`. `Naive` starts with `NAIVE - Caller chooses concrete class` and prints `dog: Woof!` by default.

## Try this next
Add a `Goat` product and register it in the factory; verify `java -cp out Main goat` works without changing `Main`.
