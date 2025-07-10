# 🚆 Train Ticket Booking System

A Java-based IRCTC-style train reservation system — built fully with OOP principles, Collections, and Streams.  
Supports user login, train search, booking, cancellation, and history — all in-memory, no DB required!

<p align="center">
  <img src="https://img.shields.io/badge/Built%20With-Java-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/OOP-Design-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Postman-Tested-orange?style=for-the-badge" />
</p>

---

## 💡 Features

- 👤 **User Login & Registration**
- 🚆 **Train Search by Source/Destination**
- 🎟️ **Ticket Booking** with passenger details & seat limits
- ❌ **Ticket Cancellation**
- 🧾 **Booking History per user**
- 🛑 **Session persistence** using custom file-based saving
- 🔁 **In-memory data** handled via Java Collections (`Map`, `List`)
- 💻 **Stream API** used for filtering/searching/sorting

---

## 🔧 Tech Stack

- **Java 17+**
- **OOP Design Patterns**
- **Collections Framework**
- **Streams & Lambdas**
- **File I/O for data persistence**
- **Postman for testing flows**
- **Git for version control**

---

## 🧠 How It Works

- All data (users, trains, bookings) is stored in-memory via `HashMap` and `ArrayList`
- On exit, data is saved to file (custom serialization)
- On start, data is restored from file
- Clean modular design: `UserService`, `BookingService`, `TrainService`, etc.
- Bookings tied to authenticated users with auto-generated PNRs

---

## 🛠️ How to Run

1. **Clone the repo**
```bash
git clone https://github.com/hemantgarg1452/IRCTC-RailReserve.git
cd IRCTC-RailReserve
```
2. **Run the main class**
   
-> Open in any IDE (e.g., IntelliJ, VS Code)
-> Run Main.java

3. **Use CLI menu to interact**

-> Register/Login
-> Search trains
-> Book or cancel tickets
-> View booking history

Welcome to Train Booking System
1. Register
2. Login
3. Exit

Logged in as: Hany

Choose:
1. View All Trains
2. Search Train
3. Book Ticket
4. Cancel Ticket
5. Booking History
6. Logout


## 📁 Project Structure

📦 IRCTC-RailReserve  
├── 📁 model           # POJOs: User, Train, Booking  
├── 📁 service         # Business logic: BookingService, UserService  
├── 📁 utils           # Data persistence, validation helpers  
├── 📄 Main.java       # Entry point  
├── 📄 trains.txt      # Sample train data (if added)  
└── 📄 README.md       # You're here!



## 🤝 Connect with Me
