ATM Console Application
A simple Java console application simulating basic ATM operations, including user authentication, balance inquiries, cash withdrawal, deposits, fund transfers, PIN management, and transaction history tracking.

Features
User authentication with username and PIN (masked input where supported)

Check account balance

Withdraw cash with balance validation

Deposit cash

Transfer funds between accounts

Change account PIN securely

View full transaction history

View mini statement (last 5 transactions)

Create new user accounts with PIN and initial deposit

Basic input validation and error handling

Getting Started
Prerequisites
Java JDK 8 or higher installed on your machine

An IDE like IntelliJ IDEA, Eclipse, or command line setup

Running the Application
Clone the repository or download the source code.

Open the project in your IDE.

Compile and run the ATMApp.java file.

Log in using one of the sample accounts:

Username	PIN	Initial Balance
user1	1234	R1000.00
user2	4321	R500.00

Use the console menu to interact with the ATM system.

Usage
Once logged in, you can:

Check your account balance

Withdraw funds (with sufficient balance)

Deposit funds

Transfer funds to other accounts

Change your PIN securely

View your full transaction history or mini statement (last 5 transactions)

Exit the application

Project Structure
Account class: Represents a bank account, storing PIN, balance, and transaction history.

ATMApp class: Contains the main method and manages user interface, authentication, and operations.

Future Improvements
Mask PIN input for enhanced security

Add data persistence (file or database storage) to save account data between sessions

Expand functionality with support for more complex banking operations

Develop a graphical user interface (GUI) for better usability

Implement multi-user concurrency and session management

Author
Mxolisi Masina

License
This project is open source and free to use.

Contribution
Contributions and feedback are welcome! Feel free to open issues or submit pull requests to improve the application.

