CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE, 
    password VARCHAR(255) NOT NULL
);
