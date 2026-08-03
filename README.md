# 🏦 Banking Transaction System

A **Spring Boot REST API** application that simulates a banking system for managing **Customers**, **Accounts**, and **Bank Transactions**. The application supports secure fund transfers, deposits, withdrawals, account management, and transaction history while ensuring data integrity through transaction management and custom exception handling.

---

## 🚀 Features

### 👤 Customer Management
- Create Customer
- View Customer Details
- Update Customer
- Delete Customer

### 💳 Account Management
- Create Bank Account
- View Account Details
- Update Account Status
- Delete Account

### 💰 Banking Transactions
- Deposit Money
- Withdraw Money
- Transfer Money Between Accounts
- View Transaction History
- Track Transaction Status

### ⚙️ Additional Features
- Layered Architecture
- DTO Pattern
- Spring Data JPA
- Hibernate ORM
- Global Exception Handling
- Custom Business Exceptions
- MySQL Database Integration

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok
- Postman
- IntelliJ IDEA

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.selva.banking_transaction_system
│   │
│   │       ├── Controller
│   │       │      ├── CustomerController.java
│   │       │      ├── AccountController.java
│   │       │      └── BankTransactionController.java
│   │       │
│   │       ├── Dto
│   │       │
│   │       ├── Entity
│   │       │
│   │       ├── Enum
│   │       │      ├── AccountStatus.java
│   │       │      ├── AccountType.java
│   │       │      ├── TransactionStatus.java
│   │       │      └── TransactionType.java
│   │       │
│   │       ├── Exception
│   │       │      ├── ApiErrorResponse.java
│   │       │      ├── DuplicateEmailException.java
│   │       │      ├── GlobalExceptionHandler.java
│   │       │      ├── InsufficientBalanceException.java
│   │       │      ├── InvalidAmountException.java
│   │       │      ├── ResourceNotFoundException.java
│   │       │      └── SameAccountTransferException.java
│   │       │
│   │       ├── Repository
│   │       │      ├── CustomerRepository.java
│   │       │      ├── AccountRepository.java
│   │       │      └── BankTransactionRepository.java
│   │       │
│   │       ├── Service
│   │       │      ├── CustomerService.java
│   │       │      ├── AccountService.java
│   │       │      └── BankTransactionService.java
│   │       │
│   │       ├── ServiceImpl
│   │       │      ├── CustomerServiceImpl.java
│   │       │      ├── AccountServiceImpl.java
│   │       │      └── BankTransactionServiceImpl.java
│   │       │
│   │       └── BankingTransactionSystemApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── pom.xml
```

---

## 🗄️ Database

Create a MySQL database:

```sql
CREATE DATABASE banking_transaction_db;
```

Configure the database credentials in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_transaction_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

### Clone the Repository

```bash
git clone https://github.com/<YOUR_USERNAME>/banking-transaction-system.git
```

### Navigate to the Project

```bash
cd banking-transaction-system
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Or run the `BankingTransactionSystemApplication` class directly from IntelliJ IDEA.

---

## 🌐 REST API Modules

### 👤 Customer APIs

- Create Customer
- Get Customer by ID
- Get All Customers
- Update Customer
- Delete Customer

### 💳 Account APIs

- Create Account
- Get Account Details
- Update Account
- Delete Account

### 💰 Transaction APIs

- Deposit Money
- Withdraw Money
- Transfer Funds
- View Transaction History

> **Note:** API endpoint paths depend on your controller mappings.

---

## ⚠️ Custom Exceptions

The application includes custom exception handling for:

- Duplicate Email
- Resource Not Found
- Invalid Amount
- Insufficient Balance
- Same Account Transfer
- Global Exception Handling

---

## 📚 Concepts Covered

- Spring Boot
- Spring Data JPA
- Hibernate ORM
- RESTful Web Services
- CRUD Operations
- Transaction Management
- DTO Pattern
- Layered Architecture
- Enum Mapping
- Exception Handling
- MySQL Integration

---

## 🔮 Future Enhancements

- JWT Authentication
- Role-Based Authorization
- Account Statement (PDF)
- Email Notifications
- Swagger/OpenAPI Documentation
- Pagination & Sorting
- Transaction Reports

---

## 👨‍💻 Author

**Selva Deepak**

- 🎓 BE – Electronics and Communication Engineering
- 💻 Java Full Stack Developer
- 🌱 Passionate about Java, Spring Boot, Hibernate, and Backend Development

---

## ⭐ Support

If you found this project useful, consider giving it a **⭐ Star** on GitHub.
