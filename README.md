# testtaskQAIntern

Task:

1) Let imagine that we have system that holds and manages contact directory of many companies. 
   There is one of HTTP endpoints that responsible for retrieving user data by name: 
   GET http://some_domain.com:8080/company/%companyId%/users?name=%someName% 
   Please write test scenarios for this endpoint, as many as you can. 
   Example: Request some_domain.com/company/777/users?name=Izergil where 
   777 is ID of company that does not exist, check that error is returned and HTTP status code is 404

2) Implement following scenario for this endpoint using Java language and one of the test frameworks, 
   for example TestNG, Junit, etc...: Verify that user can search only member of his own company.
