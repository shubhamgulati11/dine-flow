# DineFlow – Restaurant Table Ordering Backend

**DineFlow** is a Spring Boot backend application that allows customers to view a restaurant menu, place orders using a table QR code, and enables kitchen staff to manage orders in real time.

---

## Table of Contents

* Features
* Tech Stack
* Getting Started
* Database Setup
* API Endpoints
* Docker Setup
* Future Enhancements

---

## Features

* View restaurant menu
* Place an order linked to a table
* Order items with quantity and price
* Kitchen can view pending orders (`PLACED`, `IN_PROGRESS`)
* Update order status (`IN_PROGRESS`, `COMPLETED`)
* Maintains relationships between `User`, `Orders`, `OrderItem`, and `RestaurantTable`

> Note: User login and JWT-based authentication are **not yet implemented**. All APIs are currently unsecured.

---

## Tech Stack

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* MySQL 8
* Docker & Docker Compose
* Lombok
* Maven

---

## Getting Started

1. **Clone the repository**

```bash
git clone https://github.com/shubhamgulati11/dine-flow.git
cd dine-flow
```

2. **Build the project using Maven**

```bash
mvn clean install
```

3. **Run the application using Docker Compose**

```bash
docker-compose up --build
```

---

## Database Setup

The project uses **MySQL**. Tables are auto-created using JPA.

### Entities

1. **User** – Stores customers’ information (no login implemented yet).
2. **RestaurantTable** – Represents tables in the restaurant with unique codes.
3. **Orders** – Stores order details, linked to `User` and `RestaurantTable`.
4. **OrderItem** – Line items of an order (menu item, quantity, price).

### Example Test Data

```sql
INSERT INTO users (id, name, phone_number, password) VALUES (1, 'Test User', '1234567890', 'password');
INSERT INTO restaurant_tables (id, table_code) VALUES (1, 'T1');
```

---

## API Endpoints

### Menu

* `GET /menu` – Returns the list of menu items.

### Orders

* `POST /orders/create` – Create a new order (JSON body required).
* `GET /orders/all?customerId={id}` – Fetch all orders for a customer.

### Kitchen

* `GET /kitchen/orders` – Fetch pending orders (`PLACED` and `IN_PROGRESS`).
* `PUT /kitchen/orders/{orderId}/status?status={status}` – Update order status.

> All APIs are currently unsecured.

---

## Docker Setup

* **MySQL Service**

```yaml
mysql-db:
  image: mysql:8
  environment:
    MYSQL_ROOT_PASSWORD: root
    MYSQL_DATABASE: restaurant_app
    MYSQL_USER: appuser
    MYSQL_PASSWORD: apppass
  ports:
    - "3306:3306"
```

* **Backend Service**

```yaml
backend:
  build: .
  depends_on:
    - mysql-db
  environment:
    SPRING_DATASOURCE_URL: jdbc:mysql://mysql-db:3306/restaurant_app?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    SPRING_DATASOURCE_USERNAME: appuser
    SPRING_DATASOURCE_PASSWORD: apppass
  ports:
    - "8080:8080"
```

* **Run:**

```bash
docker-compose up --build
```

---

## Future Enhancements

* Implement user login with phone number
* Add JWT-based authentication for secure API access
* Move menu items to a separate `MenuItem` table
* Add payment processing APIs

---

**Repository:** \[http
