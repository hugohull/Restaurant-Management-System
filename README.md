# Restaurant Management System

This project is a web-based management system for handling a restaurant's information, including chefs and their orders. Built with Java, Spring Boot, JPA, and JSPs, the system connects to a MySQL database to manage entities such as restaurants, chefs, and orders, and supports CRUD operations for each.

## Project Features

### 1. Project Setup & Configuration
- Configured dependencies to support MySQL database connections and JSPs.
- Configured the application to connect to a MySQL database with credentials and log SQL statements to the console.

### 2. Domain Classes
- **`Restaurant`**: Represents a restaurant entity with fields for `id`, `name`, a list of `Chef` objects, and a `headChef`.
- **`Chef`**: Represents a chef entity with fields for `firstName`, lists of `Restaurant` and `Order` objects, and a `nextOrder`.
- **`Order`**: Represents an order entity with fields for `id` and `guests`.
- Generated getters, setters, and `toString()` methods for each class to output relevant information.

### 3. JPA Annotations
- Annotated `Restaurant`, `Chef`, and `Order` classes to create corresponding tables in the database.
- Primary keys:
  - `Restaurant`: `id` (auto-generated)
  - `Chef`: `firstName`
  - `Order`: `id` (auto-generated)
- Defined relationships:
  - **Restaurant-Chef**: Many-to-many bidirectional.
  - **Chef-Order**: One-to-many with a join column.
  - **Chef-nextOrder**: One-to-one.
  - **headChef**: Many chefs may have one headChef, who can manage multiple chefs.
- Configured cascading and eager loading:
  - Saving a `Restaurant` will save all associated `Chef` objects.
  - Deleting a `Chef` will delete all related `Order` objects.
- Created CRUD repositories:
  - `RestaurantRepository`, `ChefRepository`, and `OrderRepository`.

### 4. CRUD Repository Methods
- **RestaurantRepository**:
  - Find restaurants by `name`.
  - Find restaurants by the `firstName` of their headChef.
- **ChefRepository**:
  - Find chefs by `firstName`.
- **OrderRepository**:
  - Find orders by `guests`.

### 5. Displaying Data (Model, View, and Controller)
- **Data Initialization**: 
  - In `HW2Application`, a CommandLineRunner was implemented to initialize one instance of each class in the database with no null or empty records.
- **ListController**:
  - Displays a JSP view (`/src/main/webapp/WEB-INF/views/list.jsp`) for listing all restaurants with their associated data, accessible via `/list`.
  - The model attribute for restaurants is called `restaurants`.
- **DeleteController**:
  - Provides endpoints for deleting individual instances:
    - **Restaurant**: `/deleteRestaurant?id={id}`
    - **Chef**: `/deleteChef?firstName={firstName}`
    - **Order**: `/deleteOrder?id={id}`
  - Deletes the specified entity and removes related references to maintain data integrity.

---

This system offers a robust, structured approach to managing restaurant data, with user-friendly controllers, view templates, and validation for each entity. The repository methods and data persistence ensure efficient and scalable database management.  
