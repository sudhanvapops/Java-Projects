# 📚 Student Management System with Bank & Library Features
---
### About Project (Campus Management System ) CLI
A Java OOP project combining **student records**, **banking simulation**, and **library management** — great for practicing classes, inheritance, composition, and ArrayLists.

---

## 🔑 Main Features

### 1️⃣ Student Management
Each student has:
- 👤 **Details**: ID, Name, Grade
- 💰 **Bank Account** (either Savings or Checking) — *Composition*
- 📖 **List of Borrowed Books**

Operations:
- ➕ Add a Student
- 📝 Update a Student
- ❌ Delete a Student
- 👁️ View Student Details

---

### 2️⃣ Bank Account Simulator
Each student **automatically gets a BankAccount**:
- Can be a **SavingsAccount** or **CheckingAccount**  
  *(via Inheritance from BankAccount)*

Students can:
- 💵 Deposit
- 💸 Withdraw
- 🔁 Transfer Money (between student accounts)

---

### 3️⃣ Library Management
The campus library maintains a **List of Books**

Students can:
- 📚 **Borrow** a Book *(added to their personal list)*
- 📤 **Return** a Book

---

## 🧠 Concepts Covered

| Concept                  | Application                                                                 |
|--------------------------|-----------------------------------------------------------------------------|
| ✅ **Classes/Objects**     | Student, Book, BankAccount, Library, etc.                                  |
| ✅ **Encapsulation**      | Private variables with getters/setters                                     |
| ✅ **Inheritance**        | `BankAccount` → `SavingsAccount`, `CheckingAccount`                         |
| ✅ **Method Overriding**  | Custom `withdraw()` or `transfer()` behavior in account types              |
| ✅ **Composition**        | `Student has-a BankAccount`, `Student has-a list of Books`                 |
| ✅ **ArrayList**          | For storing Students and Books                                             |
| ✅ **CRUD Operations**    | Create, Read, Update, Delete Students, Books, and Bank data                |

---

## 🏗️ Suggested Class Design

- `Student`
  - id (int), name (String), grade (String)
  - bankAccount (BankAccount)
  - borrowedBooks (ArrayList<Book>)

- `Book`
  - title (String), author (String), isbn (String)

- `BankAccount` *(abstract)*
  - accountNumber, balance
  - Methods: deposit(), withdraw(), transfer()

- `SavingsAccount` / `CheckingAccount` *(extends BankAccount)*

- `Library`
  - books (ArrayList<Book>)
  - Methods: addBook(), borrowBook(), returnBook()

- `StudentManager`
  - students (ArrayList<Student>)
  - Methods: addStudent(), deleteStudent(), updateStudent(), viewStudent()

---

## 💡 Ideas for Extensions

- ✅ Save/Load data using file I/O
- ✅ Add UI (Swing / JavaFX)
- ✅ Add penalties for overdue books
- ✅ Apply interest for savings account monthly

---

🎯 **Goal**: Learn Java OOP by applying real-world simulations with CRUD, Collections, and Class Hierarchies.

---


### Building a Proof of Concept Learned

- This project is for building a proof of concept Learned

- The things i have leanrned in java using that buildin a project

- Idea for project took from Chat GPT AI

---