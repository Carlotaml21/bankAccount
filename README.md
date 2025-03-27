# Bank Account Modeling Program

## Description
This program models a basic bank account system with support for savings and checking accounts. It is designed using object-oriented programming principles in Java, featuring protected attributes, method overriding, and inheritance.

## Features

### Main Class: `BankAccount`

#### Protected Attributes:
- `balance` (`float`): the current account balance.
- `depositCount` (`int`): number of deposits made. Initialized to 0.
- `withdrawalCount` (`int`): number of withdrawals made. Initialized to 0.
- `annualRate` (`float`): the annual interest rate as a percentage.
- `monthlyFee` (`float`): monthly fee charged. Initialized to 0.

#### Constructor:
- Initializes the `balance` and `annualRate` based on input parameters.

#### Methods:
- `deposit(float amount)`: Adds the given amount to the balance and updates the deposit count.
- `withdraw(float amount)`: Deducts the given amount from the balance if sufficient funds exist, and updates the withdrawal count.
- `calculateMonthlyInterest()`: Calculates monthly interest and adds it to the balance.
- `monthlyStatement()`: Applies the monthly fee, calculates and adds monthly interest.
- `printAccountInfo()`: Returns all attribute values of the account.

---

## Subclasses

### 1. `SavingsAccount`

Adds an attribute `isActive` (`boolean`). The account is considered active if the balance is $10,000 or more; otherwise, it is inactive.

#### Overridden Methods:
- `deposit(float amount)`: Only allowed if the account is active. Inherits functionality from the parent.
- `withdraw(float amount)`: Only allowed if the account is active. Inherits functionality from the parent.
- `monthlyStatement()`: If withdrawals exceed 4 in a month, each additional withdrawal incurs a $1,000 fee. Re-evaluates the active status based on the updated balance.

#### Additional Method:
- `printDetailsInfo()`: Returns the current balance, monthly fee, and total number of transactions (deposits + withdrawals).

---

### 2. `CheckingAccount`

Adds an attribute `overdraft` (`float`), initialized to 0, to track any overdraft.

#### Overridden Methods:
- `withdraw(float amount)`: Allows withdrawals beyond the current balance. The overdraft amount is tracked.
- `deposit(float amount)`: Inherits functionality and reduces the overdraft if one exists.
- `monthlyStatement()`: Inherits functionality from the parent class.

#### Additional Method:
- `printDetailsInfo()`: Returns the balance, monthly fee, number of transactions, and the overdraft amount.

---

## How to Use

1. Instantiate a `BankAccount`, `SavingsAccount`, or `CheckingAccount`.
2. Use the provided methods to perform operations like deposit, withdraw, print account status, or generate the monthly statement.

---

## Example

```java
SavingsAccount mySavings = new SavingsAccount(15000.0f, 2.5f);
mySavings.withdraw(5000.0f);
mySavings.deposit(1000.0f);
mySavings.monthlyStatement();
System.out.println(mySavings.printDetails());
