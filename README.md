
# 🧮 Inventory REST API (Clojure)

A simple **Clojure REST API** for managing an inventory of products using **Ring**, **Compojure**, and **Atoms** for in-memory storage.  
This project demonstrates clean routing, CRUD operations, and JSON-style responses.

---

## 🚀 Features

- 🧾 **CRUD API** for product management  
- 💾 **Persistent data storage** using MongoDB
- ⚙️ Built with **Leiningen**, **Ring**, and **Compojure** and **Monger**
- 🧱 RESTful routes for clean structure  
- 🧠 UUID-based product IDs for uniqueness

---

## 🧩 Tech Stack

| Component         | Description      |
|-------------------|------------------|
| **Language**      | Clojure          |
| **Build Tool**    | Leiningen        |
| **Web Framework** | Ring + Compojure |
| **Database**      | `Monger`         |
| **Port**          | 3000 (default)   |

---

## 📦 Project Structure

```
inventory-api/
├── src/
│   └── inventory_api/
│       ├── core.clj        # Starts the server
│       ├── routes.clj      # All REST API endpoints
        └── db.clj          # MongoDB connection and CRUD functions
├── project.clj              # Leiningen dependencies & entry point
├── README.md
└── resources/
```
## ⚙️ Setup & Run

### 1️⃣ Clone the repository

```bash
  git clone https://github.com/<your-username>/inventory-api.git
  cd inventory-api
````

### 2️⃣ Start MongoDB
```
mongod
If using authentication or a custom port, update db.clj accordingly.
```

### 3️⃣ Run the project

```bash
  lein run
```

The server will start at **[http://localhost:3000](http://localhost:3000)**

---

## 🧮 API Endpoints

| Method     | Endpoint        | Description                | Example                                                                                                                    |
| ---------- | --------------- | -------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| **GET**    | `/products`     | Get all products           | `curl http://localhost:3000/products`                                                                                      |
| **GET**    | `/products/:id` | Get product by ID          | `curl http://localhost:3000/products/1`                                                                                    |
| **POST**   | `/products`     | Add a new product          | `curl -X POST -H "Content-Type: application/json" -d '{"name":"Pen","qty":10,"price":5.5}' http://localhost:3000/products` |
| **PUT**    | `/products/:id` | Update an existing product | `curl -X PUT -H "Content-Type: application/json" -d '{"qty":20}' http://localhost:3000/products/1`                         |
| **DELETE** | `/products/:id` | Delete a product           | `curl -X DELETE http://localhost:3000/products/1`                                                                          |

---

## 🧠 Example Response

**GET /products**

```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Notebook",
    "qty": 5,
    "price": 45.0
  },
  {
    "id": "550e8400-e29b-41d4-a716-446655440001",
    "name": "Pen",
    "qty": 10,
    "price": 5.5
  }
]
```

---

## 🧱 Future Improvements

* Kafka integration for real-time inventory updates and messaging
* Add request validation and better error handling middleware
* Add unit and integration tests with clojure.test
* Add Swagger/OpenAPI documentation for the API
* Support bulk inserts and query filtering

---

## 💬 Author
```
Suraj Giri
Clojure Developer | Java + Spring Boot + Kafka Engineer
🔗 GitHub: [@suraj-giri](https://github.com/surajgiri974)
```


## 🪪 License

```
Copyright © 2025 Suraj Giri

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
https://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
 
```