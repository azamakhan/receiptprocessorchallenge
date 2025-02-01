# Receipt Processor

This Spring Boot application processes receipts and calculates points based on specific rules.

## Getting Started

### Prerequisites

- Docker
- cURL (for testing)

### Running the Application

To start the application using Docker, run the following command in the project root directory:
# Receipt Processor - Dockerized Setup

This guide explains how to **build**, **run**, and **test** the Receipt Processor application using **Gradle** and **Docker**.

---

## Build and Run the Docker Container

### **Step 1: Build the JAR File**
Before building the Docker image, package your application using **Gradle**:
```sh
./gradlew clean build
This will start the application and any required services defined in the `docker-compose.yml` file.
```
### **Step 2: Build the Docker Image**
Run the following command inside the root folder to build the Docker image:
```
docker build -t receipt-processor . 
```

### **Step 3: Run the Docker Container**
Run the following command inside the root folder to run the Docker image:
```
docker run -p 8080:8080 receipt-processor
```

This will:
Start the Spring Boot application inside a container.
Expose the application on http://localhost:8080.


### **Step 4: Verify the Running Container**
Run the following command to check if the container is running:
```
docker ps
```

To stop the container:
```
docker stop receipt-processor
```

## API Usage

### Endpoint: POST /receipts/process

Process a receipt and return an ID.

**Success Scenario:**
curl -X POST -H "Content-Type: application/json" -d '{
"retailer": "Target",
"purchaseDate": "2022-01-01",
"purchaseTime": "13:01",
"items": [
{
"shortDescription": "Mountain Dew 12PK",
"price": "6.49"
}
],
"total": "6.49"
}' http://localhost:8080/receipts/process


**Error Scenario (Missing Required Field):**
curl -X POST -H "Content-Type: application/json" -d '{
"purchaseDate": "2022-01-01",
"purchaseTime": "13:01",
"items": [
{
"shortDescription": "Mountain Dew 12PK",
"price": "6.49"
}
],
"total": "6.49"
}' http://localhost:8080/receipts/process

### Endpoint: GET /receipts/{id}/points

Retrieve the points for a processed receipt.

**Success Scenario:**
curl -X GET http://localhost:8080/receipts/7fb1377b-b223-49d9-a31a-5a02701dd310/points
