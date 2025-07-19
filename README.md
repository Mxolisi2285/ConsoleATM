# SimpleATMJava

A simple console-based ATM application built with Java. This project simulates basic ATM functionalities including user authentication via PIN, balance enquiry, cash withdrawal, cash deposit, and transaction history — all running in the console without any database.

---

## Features

- User login with username and PIN authentication (3 attempts max)
- View current account balance
- Withdraw cash with balance validation
- Deposit cash
- View transaction history
- Simple input validation and error handling
- Supports multiple user accounts (hardcoded)

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher installed on your machine
- An IDE like IntelliJ IDEA, Eclipse, or use command line

### Running the Application

1. Clone the repository or download the source code.
2. Open the project in your IDE.
3. Compile and run the `ATMApp.java` file.
4. Login using one of the sample accounts:

| Username | PIN  | Initial Balance |
| -------- | ---- | --------------- |
| user1    | 1234 | R1000.00        |
| user2    | 4321 | R500.00         |

5. Use the console menu to interact with the ATM system.

---

## Usage

After logging in, you can:

- Check your account balance
- Withdraw funds (if sufficient balance)
- Deposit funds
- View a history of your transactions
- Exit the application

---

## Project Structure

- `Account` class: Represents a bank account with PIN, balance, and transaction history.
- `ATMApp` class: Contains the main method and handles user interface and authentication.

---

## Future Improvements

- Mask PIN input for security
- Add data persistence (file/database storage)
- Support more complex banking operations (transfer, account creation)
- Improve user interface with a GUI

---

## Author

Mxolisi Masina

---

## License

This project is open source and free to use.

---

Feel free to contribute or open issues for improvements!

