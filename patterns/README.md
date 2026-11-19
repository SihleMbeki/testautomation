# Java design patterns learning project

Each numbered folder is a standalone Java 17 example. It includes a small
before-pattern version (`Naive.java`), a pattern-based version (`Main.java`),
and a README with the scenario, roles, test-automation connections, and an
extension exercise. No build tool or third-party library is required.

## Suggested learning order

Follow the numbered order: start with the object-communication patterns, then
creation and behaviour patterns, and finish with the combined CSV test-data
factories. Compile and run both `Main` and `Naive` in each folder to compare
the solutions.

| Folder | Pattern | Problem |
|---|---|---|
| `01-observer-goal` | Observer | Notify scoreboard, commentator, and fans when a team scores. |
| `02-strategy-payment` | Strategy | Choose card, cash, or EFT payment at checkout. |
| `03-facade-leaving-house` | Facade | Coordinate the steps for safely leaving home. |
| `04-factory-animal` | Factory | Create the animal requested by the user. |
| `05-builder-pizza` | Builder | Build a pizza from readable options and defaults. |
| `06-decorator-coffee` | Decorator | Add stackable extras to a coffee and its price. |
| `07-template-match` | Template Method | Run a match consistently, with penalties for a tied cup match. |
| `08-singleton-ticket-counter` | Singleton (plus thread-safety comparison) | Share unique parking ticket numbers across gates. |
| `09-iterator-playlist` | Iterator | Play a playlist in normal, reverse, or shuffled order. |
| `10-template-netflix-payment` | Template Method | Keep debit and credit card payment steps in a fixed order. |
| `11-decorator-tourist-bus` | Decorator | Add repeatable extras to a tourist bus ticket. |
| `12-observer-bookstore-library` | Observer | Update reminder and expired-loan views as the date advances. |
| `13-observer-channel-subscriptions` | Observer | Notify current channel subscribers about new posts. |
| `14-strategy-employee-bonuses` | Strategy | Calculate and change an employee's bonus method. |
| `15-factory-method-document-app` | Factory Method | Let document applications create and manage their own document types. |
| `16-factory-abstract-factory-csv-test-data` | Factory Method + Abstract Factory | Prepare customer or order CSV test data from matching helper families. |
| `17-facade-car-stop` | Facade | Coordinate the ordered steps for safely stopping and parking a car. |
| `18-state-phone-lock` | State | Change phone key behavior between locked and unlocked states. |
| `19-template-strategy-food-order` | Template Method + Strategy | Keep checkout steps fixed while switching delivery or store collection. |
| `20-state-account-lockout` | State | Lock an account after three failed login attempts. |
| `21-observer-strategy-marathon-leaderboard` | Observer + Strategy | Notify race viewers and filter leaderboard rankings by category. |
| `22-observer-alarm-notifications` | Observer | Notify multiple channels when a sensor detects an object. |
| `23-builder-director-computer` | Builder + Director | Assemble custom computers or use reusable preset recipes. |
| `24-observer-fire-sprinklers` | Observer | Activate the sprinkler associated with a smoke-detecting room. |
| `25-strategy-running-shoe-pricing` | Strategy | Price shoe models by new, demo, or second-hand condition. |
| `26-state-marital-status` | State | Enforce allowed marital-status transitions and reject invalid ones. |
| `27-state-alarm-clock` | State | Model setting, ringing, snoozing, and cancelling an alarm with a fake clock. |
| `28-factory-light-colour` | Factory | Create a coloured light selected by the user. |
| `29-adapter-candle-light` | Adapter | Make a candle work through the room's existing Light interface. |
| `30-adapter-facade-gender-options` | Adapter + Facade | Adapt external options and expose one combined gender display entry point. |
| `31-factory-singleton-race-tickets` | Factory + Singleton | Award early-bird T-shirts correctly while issuing race tickets concurrently. |
| `32-strategy-province-ticket-pricing` | Strategy | Price tickets by normalized departure and destination provinces. |
| `33-strategy-factory-game-weapons` | Strategy + Factory | Create and switch between game-style character weapons. |
| `34-decorator-game-weapon-attachments` | Decorator | Add and remove weapon attachments without combination-specific subclasses. |

## Compare these

- **Factory vs Adapter:** Compare [`28-factory-light-colour`](./28-factory-light-colour) with [`29-adapter-candle-light`](./29-adapter-candle-light). The Factory chooses which compatible `Light` to create; the Adapter translates a candle's different interface so the room can use it unchanged.
- **Factory vs Strategy:** In [`28-factory-light-colour`](./28-factory-light-colour), ask “which light should I create?” In [`25-strategy-running-shoe-pricing`](./25-strategy-running-shoe-pricing) or [`32-strategy-province-ticket-pricing`](./32-strategy-province-ticket-pricing), ask “which pricing rule should this existing context use?”
- **Strategy vs Decorator:** Compare [`33-strategy-factory-game-weapons`](./33-strategy-factory-game-weapons), where a character switches its weapon behavior, with [`34-decorator-game-weapon-attachments`](./34-decorator-game-weapon-attachments), where wrappers add features to a weapon and can be stacked.
- **State:** Compare [`18-state-phone-lock`](./18-state-phone-lock), [`20-state-account-lockout`](./20-state-account-lockout), [`26-state-marital-status`](./26-state-marital-status), and [`27-state-alarm-clock`](./27-state-alarm-clock). Each lets the current state control valid behavior or transitions; the examples range from simple mode changes to guarded transitions and simulated time.

## Run everything

From a Bash-compatible shell with JDK 17 installed, run:

```bash
bash ./run-all.sh
```

The script compiles each folder independently and runs its pattern-based
`Main`. To compare its before-pattern example, enter any numbered folder and
run:

```bash
javac -d out *.java
java -cp out Naive
```
