# Library Management System

A Java-based Library Management System designed using Object-Oriented Programming principles, SOLID principles, and common Design Patterns.
# Class Diagram
<img width="6231" height="2263" alt="mermaid-diagram" src="https://github.com/user-attachments/assets/c512cf83-948f-4340-9b93-0b67989659c9" />



## Features

### Book Management
- Add books to the library
- Remove books from the library
- Update book details
- Search books by:
  - Title
  - Author
  - ISBN
- Track book availability using book status

### Patron Management
- Add patrons to the library
- Store patron information
- Maintain borrowing history for each patron

### Lending
- Checkout books
- Return books
- Track borrowing and return dates
- Prevent unavailable books from being borrowed

### Reservation & Notifications
- Patrons can reserve books
- Patrons are registered as observers for reserved books
- Patrons are notified when a reserved book becomes available

## Design Patterns

### 1. Strategy Pattern

The Strategy Pattern is used for book searching.

Different search strategies are implemented for:
- Search by Title
- Search by Author
- Search by ISBN

```text
SearchStrategy
      |
      |-- SearchByTitle
      |-- SearchByAuthor
      |-- SearchByISBN

      SearchType
   |
   v
SearchStrategyFactory
   |
   |-- TITLE  -> SearchByTitle
   |-- AUTHOR -> SearchByAuthor
   |-- ISBN   -> SearchByISBN

   Book
  |
  v
NotificationManager
  |
  +-- Patron
  +-- Patron
