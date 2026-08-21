# JPA P2 - Full Solution

Spring Boot 3 + Spring Data JPA + H2. Java 17.

## Run
```bash
mvn spring-boot:run
```

Or build:
```bash
mvn clean package
java -jar target/jpa-p2-solution-1.0.0.jar
```

## Main endpoints
- POST/GET `/students`
- POST `/courses`
- POST/GET/GET by id/PUT/DELETE `/products`
- POST `/categories`, POST `/categories/{id}/products`, GET `/categories/{id}/products`
- POST `/books`, GET `/books/search?author=ABC`, GET `/books/search?minPrice=100&maxPrice=300`
- POST `/employees`, GET `/employees?page=0&size=5&sort=salary,desc`
- POST `/users` with validation
- POST `/orders`, GET `/orders/search?from=...&to=...`, GET `/orders/top`
- POST/GET `/customers` (GET hides email via CustomerDTO)

H2 console: `/h2-console`
JDBC URL: `jdbc:h2:file:./data/jpap2`
User: `sa`
Password: empty
