# Spribe Test

# Functionality
This project have multiple endpoints with several access roles.<br/>

### **You can see them here**

GET:
- /products/{id} - roles: user/admin<br/>
- /orders - role: user<br/>
- /shopping-carts/by-user - role: user<br/>
- /users/by-email - role: admin<br/>

POST: 
- /register - all<br/>
- /products - role: admin<br/>
- /orders/complete - role: user<br/>

PUT: 
- /products/{id} - role: admin<br/>
- /shopping-carts/products - role: user<br/>

DELETE:
- /products/{id} - role: admin<br/>

# Technologies Used:
- Java 11
- Maven Checkstyle Plugin
- Spring Framework (Core, Web and Security)
- Hibernate
- REST
- Lombok
- MySQL RDBMS

# Configure Project:

- You need is relational database like MySQL or PostgreSQL, configure DB properties in scr/main/resourses/db.properties.
