
# Online library service

Online library service contains books and users, each user can subscribe to the library in order to borrow books. Each user can borrow two books every 7 days. The user can extend borrowing the book once. [The implementation of the system.](https://github.com/amohd63/Exalt-Training/tree/master/Library-system/Library/src/main/java/com/example/demo)


## Operations

- Subscribe to the library
- Renew subsciption
- List all books
- Get user's subscription infromation
- Get user's borrow history
- Add new user to the system
- Add new book to the system
- Borrow a book
- Extend borrowing a book
- Search for a book by serial number


## ER Diagram

![LibraryERD](https://raw.githubusercontent.com/amohd63/Exalt-Training/master/Library-system/ERD.png)


## API Reference

### Subscribe to the library

```http
  POST /subscribe
```

`Request Body`:
```yaml
{
        "userID": 1,
        "startDate": "2023-04-05",
        "endDate": "2023-12-31"
}
```

`Response`:
```yaml
User subscribed to the library!

```

### Renew subsciption

```http
  POST /renew_subscription
```

`Request Body`:
```yaml
{
        "userID": 1,
        "startDate": "2023-04-05",
        "endDate": "2024-12-31"
}
```

`Response`:
```yaml
User subscribed to the library!

```

### List all books

```http
  GET /books
```

`Response`:
```yaml
[
    {
        "serialNumber": "SN123",
        "name": "The Great Novel",
        "numOfPages": 300,
        "genre": "NOVEL",
        "author": "Author A",
        "availableCopies": 5,
        "totalCopies": 10
    },
    {
        "serialNumber": "SN456",
        "name": "Science Explained",
        "numOfPages": 250,
        "genre": "SCIENCE",
        "author": "Author B",
        "availableCopies": 3,
        "totalCopies": 5
    },
    {
        "serialNumber": "SN789",
        "name": "Fiction Adventures",
        "numOfPages": 400,
        "genre": "FICTION",
        "author": "Author C",
        "availableCopies": 7,
        "totalCopies": 7
    }
]

```

### Get user's subscription infromation

```http
  GET /user_subscription/${userID}
```

`Response`:
```yaml
{
    "subscriptionID": 2,
    "userID": 2,
    "startDate": "2023-02-15",
    "endDate": "2023-08-15"
}

```

### Get user's borrow history

```http
  GET /borrow_history/${userID}
```

`Response`:
```yaml
[
    {
        "borrowID": 3,
        "userID": 3,
        "serialNumber": "SN789",
        "startDate": "2023-08-11",
        "endDate": "2023-08-18"
    }
]

```

### Add new user to the system

```http
  POST /add_user
```

`Request Body`:
```yaml
{
        "userName": "user5",
        "userPassword": "password5",
        "firstName": "Ali",
        "lastName": "Mohammed"
}
```

`Response`:
```yaml
User added successfully!

```

### Add new book to the system

```http
  POST /add_book
```

`Request Body`:
```yaml
{
        "serialNumber": "SN323",
        "name": "Test book",
        "numOfPages": 50,
        "genre": "NOVEL",
        "author": "Test user",
        "availableCopies": 5,
        "totalCopies": 10
}
```

`Response`:
```yaml
Book added successfully!

```

### Borrow a book

```http
  POST /borrow/{userID}/{serialNumber}
```

`Response`:
```yaml
Borrowed the book successfully!

```

### Extend borrowing a book

```http
  POST /extend_borrow/{userID}/{serialNumber}
```

`Response`:
```yaml
Borrow extended successfully!

```

### Search for a book by serial number

```http
  GET /book/{serialNumber}
```

`Response`:
```yaml
[
    {
        "serialNumber": "SN123",
        "name": "The Great Novel",
        "numOfPages": 300,
        "genre": "NOVEL",
        "author": "Author A",
        "availableCopies": 5,
        "totalCopies": 10
    }
]

```
