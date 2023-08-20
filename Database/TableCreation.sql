-- drop table Users, Books, Borrow, Subscription;
-- User table
CREATE TABLE Users (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL UNIQUE,
    user_password VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);
ALTER TABLE Users AUTO_INCREMENT=1;

-- Book table
CREATE TABLE Books (
	serial_number VARCHAR(20) NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    num_of_pages INT NOT NULL,
    genre VARCHAR(20) NOT NULL,
    author VARCHAR(100) NOT NULL,
    available_copies INT NOT NULL,
    total_copies INT NOT NULL
);

CREATE TABLE Subscription (
	subscriptionID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    borrow_limit INT,
    dtype VARCHAR(80), -- Discriminator
    FOREIGN KEY (userID) REFERENCES Users(userID) ON DELETE CASCADE
);
ALTER TABLE Subscription AUTO_INCREMENT=1;

-- Borrowed Books table
CREATE TABLE Borrow (
    borrowID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    serial_number VARCHAR(20),
    borrow_date DATE NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users(userID) ON DELETE CASCADE,
    FOREIGN KEY (serial_number) REFERENCES Books(serial_number) ON DELETE CASCADE
);
ALTER TABLE Borrow AUTO_INCREMENT=1;
SET FOREIGN_KEY_CHECKS=0; -- to disable them