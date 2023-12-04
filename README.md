# MIDI to Score Converter Web Application

This web application allows users to convert MIDI files into musical scores using the Flat.io Create Score API. The project is built with React for the frontend, Java 17 and Spring Boot for the backend. Gradle is used as the build tool, and IntelliJ IDEA and VSCode serve as the Integrated Development Environments (IDEs). Postman is utilized for testing the API endpoints.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Run](#setup-and-run)
  - [Backend](#backend)
  - [Frontend](#frontend)
- [Usage](#usage)
- [Testing](#testing)


## Overview

The application accepts MIDI files from users, converts them into base64-encoded format, and sends this data to the Flat.io API, which then creates a musical score. The Flat API responds with a URL, allowing users to view and play the generated score on the Flat website.

## Technologies Used

- **Frontend:**
  - [React](https://reactjs.org/)

- **Backend:**
  - [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Gradle](https://gradle.org/)

- **API:**
  - [Flat.io API](https://flat.io/developers/docs/api/)

- **IDEs:**
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
  - [VSCode](https://code.visualstudio.com/download)

- **Testing:**
  - [Postman](https://www.postman.com/downloads/)

## Project Structure

The project is organized into frontend and backend components:

- **Backend (Java/Spring Boot):**
  - Source code is located in the `backend` directory.
  - Gradle is used for dependency management and building.
  - IntelliJ IDEA is the recommended IDE for backend development.

- **Frontend (React):**
  - Source code is located in the `frontend` directory.
  - VSCode is the recommended IDE for frontend development.

## Setup and Run

### Backend

1. Open the `backend` directory in IntelliJ IDEA.
2. Ensure that [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html) is installed on your machine.
3. Build and run the Spring Boot application.
4. The backend will be hosted on [http://localhost:8080](http://localhost:8080).

### Frontend

1. Open the `frontend` directory in VSCode.
2. Ensure that [Node.js](https://nodejs.org/) is installed on your machine.
3. Install dependencies using `npm install`.
4. Start the React development server with `npm start`.
5. The frontend will be accessible at [http://localhost:3000](http://localhost:3000).

## Usage

1. Access the web application at [http://localhost:3000](http://localhost:3000).
2. Upload a MIDI file using the provided interface.
3. The application will convert the MIDI file to base64 and send it to the Flat.io API.
4. The Flat.io API will respond with a URL containing the generated musical score.
5. Application will automatically redirect to the URL to view and play the score on the Flat website.

## Testing

Postman is used for testing the backend API endpoints. Import the provided Postman collection to get started with testing.

URL - http://localhost:8080/notes 
It is a POST request.
Input - In body - select body as form data. In key - select file instead of text.
Authorization - Type Bearer Token - ENTER THE TOKEN PROVIDED BY FLAT.
