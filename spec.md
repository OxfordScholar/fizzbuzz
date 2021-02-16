# Application spec

Brief: To create a number of API services which work in combination to access user data from multiple sources and deliver them in a RESTful API format.

**1. REST Api**
- Return user information (contained within the LDAP + a few other things)
- Endpoint GET /rest/v3/users/<DN>

**2. REST Api**
- Pull information from first endpoint but also add extra information on from local MySql db
- This local DB will have groups the user is in (eg. "groups":"group1")
- This extra info will be added to the JSON response


## Technology being used
- **Docker**: to run the Java servlets within containerised environments
- **AWS**: for development of the APIs as well as hosting of the final products
- **Java**: the development language for the project
- **Jersey**: a Java REST framework which provides an implementation to JAX-RS (JSR-370) used within the REST apis
- **Tomcat**: used to run the first REST API
- **Jetty**: used to run the second API as well as the SQL docker container
- **MySQL**: used as the local database for the second API
