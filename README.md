# Frontend Mentor | Job listings with filtering challange

Job listing backend application for the Angular application to get data. Implemented using Spring Boot and MySQL database.
UI repository: https://github.com/czBalazs98/job-listings-ui

The challange: https://www.frontendmentor.io/challenges/job-listings-with-filtering-ivstIPCt

To run the application locally with the default config you will need:
- a MySQL database server running on **localhost:3306**
- a database named **job_listings** created
- a user that can reach the database with **username: job-listings** and **password: job-listings**

You can make your own configuration too, just add the following to the **application.yml** file:

    spring:
        config:
            activate:
                on-profile: any_profile_name_you_want

after this you can add some more configs you need, and run the application with the profile you created.

The application can use MySQL or PostgreSQL databases.
