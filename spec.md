# Application spec

Brief: To create two API services which work in combination to access user data from multiple sources and deliver them in a RESTful API format.

**1. REST Api**
- Return user information (contained within the LDAP + a few other things)
- Endpoint GET /rest/v3/users/<DN>
- This will be used to model an existing endpoint

**2. REST Api**
- Pull information from first endpoint but also add extra information on from local MySql db
- This local DB will have groups the user is in (eg. "groups":"group1")
- This extra info will be added to the JSON response
- This API will feature a number of endpoints which 


## Technology being used
- **Docker**: to run the Java servlets within containerised environments as well as the MySQL DB
- **AWS**: for development of the APIs as well as hosting of the final products
- **Java**: the development language for the project
- **Jersey**: a Java REST framework which is used in the construction of the APIs
- **Tomcat**: used to run the first REST API
- **Jetty**: used to run the second API
- **MySQL**: used as a database to store group information run as a container
