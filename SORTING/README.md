# Sorting Algorithms Demo

This is a Spring Boot application that demonstrates various sorting algorithms. It provides a REST API to sort arrays using different algorithms and compare their performance.

## Features

- Supports 9 sorting algorithms: Bubble, Selection, Insertion, Merge, Quick, Heap, Counting, Radix, Shell
- RESTful API with JSON input/output
- Execution time measurement in nanoseconds
- Input validation
- Global exception handling
- Comprehensive unit tests

## Algorithms Supported

1. **Bubble Sort** - Simple comparison-based sort
2. **Selection Sort** - Finds minimum element and swaps
3. **Insertion Sort** - Builds sorted array one element at a time
4. **Merge Sort** - Divide and conquer algorithm
5. **Quick Sort** - Partition-based sorting
6. **Heap Sort** - Uses heap data structure
7. **Counting Sort** - For positive integers, uses counting
8. **Radix Sort** - For positive integers, digit-by-digit
9. **Shell Sort** - Generalized insertion sort

Note: Counting Sort and Radix Sort do not support negative numbers.

## API Endpoints

### POST /api/sorting/sort
Sort an array using a specified algorithm.

**Request Body:**
```json
{
  "algorithm": "bubble",
  "numbers": [5, 3, 8, 1]
}
```

**Response:**
```json
{
  "algorithm": "bubble",
  "originalNumbers": [5, 3, 8, 1],
  "sortedNumbers": [1, 3, 5, 8],
  "executionTimeInNanos": 12345
}
```

### GET /api/sorting/algorithms
Get list of supported algorithms.

**Response:**
```json
["bubble", "selection", "insertion", "merge", "quick", "heap", "counting", "radix", "shell"]
```

## Running the Application

1. Ensure you have Java 17+ and Maven installed.
2. Clone the repository.
3. Run `mvn spring-boot:run` from the project root.
4. The application will start on port 8081.

## Running Tests

Run `mvn test` to execute all unit tests.

## Sample cURL Commands

### Sort with Bubble Sort
```bash
curl -X POST http://localhost:8081/api/sorting/sort \
  -H "Content-Type: application/json" \
  -d '{"algorithm": "bubble", "numbers": [5, 3, 8, 1]}'
```

### Get Algorithms
```bash
curl http://localhost:8081/api/sorting/algorithms
```

## Error Handling

- **400 Bad Request**: Invalid algorithm name or invalid input data
- **500 Internal Server Error**: Unexpected errors

## Project Structure

- `src/main/java/com/example/sorting/`
  - `SortingApplication.java` - Main application class
  - `controller/` - REST controllers
  - `dto/` - Data transfer objects
  - `service/` - Business logic and sorting algorithms
  - `exception/` - Global exception handlers
- `src/test/java/com/example/sorting/` - Unit tests
