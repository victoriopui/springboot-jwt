-- Migration: Create users table
-- Version: V1__Create_users_table.sql

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    dateofbirth VARCHAR(10),
    gender VARCHAR(10),
    email VARCHAR(255) UNIQUE NOT NULL,
    mobileno VARCHAR(20),
    address TEXT,
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    pin VARCHAR(10),
    password VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Create index on email
CREATE INDEX idx_users_email ON users(email);