# BankAccount Project

A simple Java project demonstrating a **BankAccount domain model**, a **TransferService**, and an **InMemoryAccountRepository**. This project is part of an 8-week Java development training program, focusing on OOP, service layers, interfaces, and testing.

---

## Features

- **BankAccount**: deposit, withdraw, transferTo  
- **TransferService**: handles money transfers between accounts using a repository  
- **InMemoryAccountRepository**: stores and retrieves accounts  
- **Exceptions**: 
  - `IllegalStateException` for insufficient balance  
  - `AccountNotFoundException` for non-existing accounts  

---

## Project Structure


src/
├── main/java/com/ontwikkelpad/week1 # Domain classes (BankAccount, Counter)
├── main/java/com/ontwikkelpad/week2/service # Service layer (TransferService, TransferServiceImpl)
├── main/java/com/ontwikkelpad/week2/repository # Repository interface & implementation
└── test/java/com/ontwikkelpad/... # Unit tests (BankAccountTest, TransferServiceTest)


---

## Requirements

- Java 17+  
- Maven  
- JUnit 5  

---

## Build & Run

```bash
# Build project and run all tests
mvn clean test

All 19/19 tests pass, covering:

Happy path transfers

Edge cases for non-existing source and target accounts

Domain-level validation for insufficient balance

Quick Start

Clone the repository:

git clone https://github.com/YourUsername/BankAccountProject.git
cd BankAccountProject

Run tests:

mvn clean test

Explore the code in src/main/java for domain, service, and repository layers.

Notes

Follows separation of concerns: domain, service, and repository are clearly separated.

Demonstrates use of interfaces, service layers, and exception handling in a clean OOP design.
