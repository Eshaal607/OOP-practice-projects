# OOP Practice Projects (C++ & Java)

A collection of small console-based systems written to practice core object-oriented programming concepts such as classes, inheritance, abstraction, and polymorphism across both C++ and Java.

## Projects

### C++

**`BankAccount.cpp`**
A `BankAccount` class with encapsulated account number, holder name, and balance, plus deposit/withdraw operations. `main()` creates a sample account and lets you choose deposit or withdraw from a menu.

**`EmployeeManagemnet.cpp`**
Demonstrates abstraction and inheritance: an `abstractemployee` base class with a pure virtual method, an `employee` class implementing it, and a `programmer` subclass adding a `language` field.

**`rockpaperscissor.cpp`**
Classic Rock-Paper-Scissors against the computer, with randomized computer moves and a play-again loop.

### Java

**`CoffeeMakerApp.java`**
An abstract `Appliance` base class extended into a coffee maker simulation. Uses `ReentrantLock` for thread-safe state changes and logs activity to a file with `FileWriter`.

**`LibrarySystem.java`**
Models a `Library` with `Book` and `Member` classes also supports adding books/members and borrowing.

**`OnlineShoppingSystem.java`**
A `Product` base class extended by `Shoes`, with a `CartItem` wrapper and a shopping cart flow.

**`RobotFactoryManagementSystem.java`**
A `Robot` base class extended by specialized robots (e.g. `PaintingRobot`) that override `Performtask()` demonstrates runtime polymorphism.

**`UniversitySystem.java`**
Models a `University` containing `Department`s, `Professor`s, and `Student`s.

## Getting Started

### C++
Requires a C++ compiler (e.g. `g++`).
```bash
g++ BankAccount.cpp -o bankaccount && ./bankaccount
g++ EmployeeManagemnet.cpp -o employee && ./employee
g++ rockpaperscissor.cpp -o rps && ./rps
```

### Java
Requires a JDK (e.g. `javac`/`java`).
```bash
javac CoffeeMakerApp.java && java CoffeeMakerApp
javac LibrarySystem.java && java LibrarySystem
javac RobotFactoryManagementSystem.java && java RobotFactoryManagementSystem
javac UniversitySystem.java && java UniversitySystem
```


## Author
[Eshaal607](https://github.com/Eshaal607)
