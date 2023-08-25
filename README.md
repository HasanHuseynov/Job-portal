This GitHub repository contains the source code for a comprehensive Job Portal application developed using the Spring framework. The project focuses on creating a robust and user-friendly platform that connects job seekers with potential employers. Leveraging a range of modern technologies, the application offers advanced features such as secure authentication and authorization, seamless job browsing, and efficient communication between job seekers and employers.

Key Features:

Spring Framework: The entire project is built using the Spring framework, ensuring a modular, maintainable, and scalable architecture. Spring's various modules are employed to enhance different aspects of the application.

Spring Boot: The application is powered by Spring Boot, facilitating rapid development and deployment. The embedded server, simplified configuration, and automatic Spring dependency management streamline the development process.

JWT Authentication and Authorization: JSON Web Tokens (JWT) are utilized for secure user authentication and authorization. This ensures that only authorized users can access sensitive parts of the application.

Spring AOP (Aspect-Oriented Programming): Spring AOP is employed for cross-cutting concerns such as logging, auditing, and security. This results in cleaner and more maintainable code by separating concerns.

Spring Security: The application integrates Spring Security to manage authentication, authorization, and protection against common security vulnerabilities.

Hibernate and JPA: Hibernate, an industry-standard Object-Relational Mapping (ORM) framework, combined with Java Persistence API (JPA), is used for efficient database operations. This allows seamless interaction with the underlying PostgreSQL database.

PostgreSQL: The project utilizes PostgreSQL, a powerful open-source relational database, to store and manage user and job data securely.

Liquibase: Database schema management is handled using Liquibase, enabling smooth database versioning and migration as the application evolves.

Mail Sending: The application incorporates email sending functionality to notify users about job application updates, new job listings, and other important events.

Mapper: The Mapper library is used to simplify the conversion of complex data objects, such as DTOs (Data Transfer Objects), between different layers of the application.

Usage:

Clone the repository: git clone https://github.com/HasanHuseynov/Job-portal.git
Configure your PostgreSQL database settings in application.properties.
Build and run the application using your preferred Java IDE or by using the command line: mvn spring-boot:run.
Contributions:

Contributions to this project are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

License:

This project is licensed under the MIT License.
