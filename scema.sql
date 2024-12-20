create database chatbotdb;

use chatbotdb;


-- Table for Users
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100)unique,
    country varchar(50) not null,
    passwd varchar(20) not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Conversations
CREATE TABLE Conversations (
    conversation_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Table for Messages (for both user and bot messages)
CREATE TABLE Messages (
    message_id INT PRIMARY KEY AUTO_INCREMENT,
    conversation_id INT,
    sender ENUM('user', 'bot') NOT NULL,
    content TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conversation_id) REFERENCES Conversations(conversation_id) ON DELETE CASCADE
);

-- Table for Responses (possible bot responses to user inputs)
CREATE TABLE Responses (
    response_id INT PRIMARY KEY AUTO_INCREMENT,
    input_pattern VARCHAR(255) NOT NULL,
    response_text TEXT NOT NULL
);

-- Table for storing message-response relationship
CREATE TABLE MessageResponse (
    message_response_id INT PRIMARY KEY AUTO_INCREMENT,
    message_id INT,
    response_id INT,
    FOREIGN KEY (message_id) REFERENCES Messages(message_id) ON DELETE CASCADE,
    FOREIGN KEY (response_id) REFERENCES Responses(response_id) ON DELETE CASCADE
);
