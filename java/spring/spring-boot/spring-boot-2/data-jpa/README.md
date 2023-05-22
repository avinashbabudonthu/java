# Spring Boot 2 Data JPA Practice Examples

## Requirement
* Spring Boot 2 Data JPA Practice Examples

## Maven command
```
mvn archetype:generate -DgroupId=data.jpa -DartifactId=data-jpa -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## Dependencies
* Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)

## Active Profiles
* To connect to MySQL, update [application.properties](src/main/resources/application.properties) with following property
```
spring.profiles.active=mysql
```
* To connect to in memory H2, update [application.properties](src/main/resources/application.properties) with following property
```
spring.profiles.active=h2
```

## SQL Files
* [Create DB](https://github.com/avinashbabudonthu/sql/blob/master/mysql/create-db-and-user.sql)
* [Create tables scripts](https://github.com/avinashbabudonthu/sql/blob/master/mysql/practice-tables.sql)
* [Data scripts](https://github.com/avinashbabudonthu/sql/blob/master/mysql/insert-queries.sql)
* [Delete scripts](https://github.com/avinashbabudonthu/sql/blob/master/mysql/delete-queries.sql)
* [Drop scripts](https://github.com/avinashbabudonthu/sql/blob/master/mysql/drop-queries.sql)
* [Select queries](https://github.com/avinashbabudonthu/sql/blob/master/mysql/select-queries.sql)
* [Stored Procedures](https://github.com/avinashbabudonthu/sql/blob/master/mysql/stored-procedures.sql)
	* find_all_employees()
	* find_employee_by_dept_id(in dept_id_in int)

## Examples
* [Execute stored procedure - 0 in params, n out params](#execute-stored-procedure-returns-multiple-columns-and-return-model-list)
* [Execute stored procedure - 1 in param, n out params](#execute-stored-procedure-with-one-in-param-multiple-out-params)
* [Spring Data JPA Native Query Resultset Mapping](#spring-data-jpa-native-query-resultset-mapping)
* [Find All Employee By Pagination](#find-all-employee-by-pagination)
* [Sort By More Than One Property](#sort-by-more-than-one-property)
* [Delete multiple records by id list](#delete-multiple-records-by-id-list)

### Execute stored procedure returns multiple columns and return model list
* Create stored procedure **[find_all_employees](https://github.com/avinashbabudonthu/sql/blob/master/mysql/stored-procedures.sql)**
* Declare **javax.persistence.NamedStoredProcedureQueries** annotation on **Employee.java** and define stored procedure details
* Declare **javax.persistence.SqlResultSetMapping** annotation on **Employee.java** and define target resultset class name
* Define custom repository interface - **data.jpa.mysql.repository.CustomEmployeeRespository**
* Create implementation class - **data.jpa.mysql.repository.EmployeeRepositoryImpl**
* Inject **EntityManager** to **data.jpa.mysql.repository.EmployeeRepositoryImpl** using annotation **javax.persistence.PersistenceContext**
* Execute stored procedure - **data.jpa.mysql.repository.EmployeeRepositoryImpl.findAllEmployees()**

### Execute Stored Procedure With One In Param Multiple Out Params
* Create stored procedure **[find_employee_by_dept_id](https://github.com/avinashbabudonthu/sql/blob/master/mysql/stored-procedures.sql)**
* Declare **javax.persistence.NamedStoredProcedureQueries** annotation on **Employee.java** with name **Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_NAME**
* Result set mapping with name **Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_RESULT_SET_MAPPING**. This is used to return **List&lt;EmployeeModel&gt;**
* Refer API
```
/employees/dept/{id}
```
* API Method
```
EmployeeController.findAllEmployeesByDeptId(@PathVariable("id") Integer deptId)
```

### Spring Data JPA Native Query Resultset Mapping
* Write native query in Repository. Refer **findEmployeeAndDept()** method in [EmployeeEntityRepository](src/main/java/data/jpa/repository/EmployeeEntityRepository.java)
* Create an interface [EmployeeDepartmentEntity](src/main/java/data/jpa/entity/EmployeeDepartmentEntity.java)
* Declare getters in interface as per getter naming conventions of columns
* Execute query, we should get result set as proxy object of above interface

### Find All Employee By Pagination
* Get `page`, `size` as request parameters
* Validate and assign default value if any value is passed as null
* Create `Pageable` object
* Query DB
* Refer `findEmployeeModelListAllByPagination` method in [EmployeeService](src/main/java/data/jpa/service/EmployeeService.java)

### Sort By More Than One Property
* Prepare multiple `Sort.Order` objects
* Add them to list
* Create `Pageable` object
* Query DB
* Refer `findEmployeeModelListAllSortByENameAscAndSalaryDesc` method in [EmployeeService](src/main/java/data/jpa/service/EmployeeService.java)

### Delete multiple records by id list
* Refer `deleteStudentEntityListByIdList` method in [StudentService](src/main/java/data/jpa/service/StudentService.java)

## Postman Collection
* [data-jpa.postman_collection.json](postman-collection/data-jpa.postman_collection.json)

## Materials
* [Spring data examples jpa](https://github.com/spring-projects/spring-data-examples/tree/master/jpa/jpa21)
### Pluralsight
* Getting Started with Spring Data JPA