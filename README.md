# AvantikaMishra_RestAPIAssignmentSolution

This is an Employee Management Rest Api based Web application, where you will be experiencing CRUD(Create,Read,Update and Delete) functionality.
Along with Sorting and some concepts of security.
The Rest Api is secure and have different endpoints for different operations.

The various operations are accesssible by the following endpoints:
1. To list all the present employees in the database                                          -- localhost:8081/api/employees/list
2. To add a new employee in the database                                                      -- localhost:8081/api/employees/add
3. To delete an employee already present in the database                                      -- localhost:8081/api/employees/delete
4. To update a present employee in the database                                               -- localhost:8081/api/employees/update
5. To sort all the present employees in the database in either ascending or descending order  -- localhost:8081/api/employees/sort?direction=DESC
6. To search for the specified employee (by the firstName) in the database                    -- localhost:8081/api/employees/search?firstName=Avantika
7. To get the details of an employee with the given "id" from the database                    -- localhost:8081/api/employees/101 
{where 101 is the Id of the Employee}.

We can also add a ROLE and the User for added benefits.

The project has the various dependencies:
--Spring Security
--H2 database
--Web (Tomcat)
--JPA
--Lombok
--DevTools
