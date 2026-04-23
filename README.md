# ShopSphere 🛒

A Production-Ready E-Commerce REST API 
built with Spring Boot, JPA, MySQL & AI.

## 🚀 Features

- ✅ User Registration & Login
- ✅ JWT Authentication & Security
- ✅ Product Management (CRUD)
- ✅ Cart System
- ✅ Order Management
- ✅ AI Customer Service Chatbot (Groq API)
- ✅ MySQL Database (Auto Tables via JPA)
- ✅ Spring Security

## 🛠️ Tech Stack

| Technology | Use |
|---|---|
| Spring Boot 3.2 | Backend Framework |
| Spring Data JPA | Database ORM |
| Spring Security | Authentication |
| MySQL | Database |
| JWT | Token Auth |
| Groq AI (Llama) | AI Chatbot |
| Lombok | Clean Code |

## 📋 API Endpoints

### Auth
| Method | URL | Description |
|---|---|---|
| POST | /api/auth/register | Register User |
| POST | /api/auth/login | Login + JWT Token |

### Products
| Method | URL | Description |
|---|---|---|
| GET | /api/products/all | Get All Products |
| POST | /api/products/add | Add Product |
| PUT | /api/products/update/{id} | Update Product |
| DELETE | /api/products/delete/{id} | Delete Product |
| GET | /api/products/search | Search Products |

### Cart
| Method | URL | Description |
|---|---|---|
| POST | /api/cart/add | Add to Cart |
| GET | /api/cart | View Cart |
| DELETE | /api/cart/remove/{id} | Remove Item |

### Orders
| Method | URL | Description |
|---|---|---|
| POST | /api/orders/place | Place Order |
| GET | /api/orders/my | My Orders |
| GET | /api/orders/all | All Orders |

### AI Chatbot
| Method | URL | Description |
|---|---|---|
| POST | /api/chat/ask | Ask AI Assistant |

## ⚙️ Setup

### Prerequisites
- Java 25
- MySQL
- Maven

### Steps
1. Clone the repo
2. Create MySQL database:
   `CREATE DATABASE shopsphere_db;`
3. Set environment variables:
   `DB_PASSWORD=your_password`
   `GROQ_API_KEY=your_groq_key`
4. Run the application

## 👨‍💻 Developer

**Mo Ashif**
BIT Gorakhpur | CSE 2024-28

---
⭐ Star this repo if you found it helpful!
