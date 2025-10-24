
# 🧮 Inventory REST API (Clojure)

A simple **Clojure REST API** for managing an inventory of products using **Ring**, **Compojure**, and **Atoms** for in-memory storage.  
This project demonstrates clean routing, CRUD operations, and JSON-style responses.

---

## 🚀 Features

- 🧾 **CRUD API** for product management  
- 💾 **In-memory data storage** using Clojure atoms  
- ⚙️ Built with **Leiningen**, **Ring**, and **Compojure**  
- 🧱 RESTful routes for clean structure  
- 🧠 Easy to extend for database integration (PostgreSQL, MongoDB, etc.)

---

## 🧩 Tech Stack

| Component | Description |
|------------|-------------|
| **Language** | Clojure |
| **Build Tool** | Leiningen |
| **Web Framework** | Ring + Compojure |
| **Data Store** | In-memory via `atom` |
| **Port** | 3000 (default) |

---

## 📦 Project Structure


```
inventory-api/
├── src/
│   └── inventory_api/
│       ├── core.clj        # Starts the server
│       └── routes.clj      # All REST API endpoints
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

### 2️⃣ Run the project

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
    "id": 1,
    "name": "Notebook",
    "qty": 5,
    "price": 45.0
  },
  {
    "id": 2,
    "name": "Pen",
    "qty": 10,
    "price": 5.5
  }
]
```

---

## 🧱 Future Improvements

* Connecting Mongodb and Streaming data in real-time
* Add JSON parsing middleware for real JSON requests
* Replace in-memory storage with a database (PostgreSQL / MongoDB)
* Add request validation and error handling middleware
* Add unit and integration tests with `clojure.test`


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