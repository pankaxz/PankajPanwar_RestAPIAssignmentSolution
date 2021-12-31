# PankajPanwar_RestAPIAssignmentSolution
Graded Coding Assignment 6 (Spring Boot - RESTful APIs)

-----
APIs:
-----
	  => UserController	:	This API gives all operations related to users and roles.
		  Mapping = /user

		  Endpoints ->
		
      /list_users : GET  : Lists all available users in the Database

      /add_user    : POST : Adds new user along with its roles. Takes a Request Body of user and a string of role.It checks if role exists, otherwise adds it. Then it adds the user to DB with encrypted password.
      
      /list_roles : GET : Lists all available roles in the Database

      /add_role   : POST : Adds new role to DB. We need to provide name of the role. The server checks if  a role with given name exists. If not, then it adds to the DB.

        ----------------------------------------------------------------------------------------------------------------------------------------------------------------------

	  => EmployeeController  :  This API provides all the endpoints for the CRUD operations.
        Mapping = /employee

        Endpoints ->
    
        /list_employee:GET: Lists all employees in the Database
    
        /add_employee:POST: Adds new employee to Database. Takes a response Body of employee details.

        /{empID}:GET: Get employee data by giving Id. Takes id as a parameter. 

        /update_employee/{empID}:POST:Updates the given record in DB. Takes a response Body of updated employee details and employeeID. 
    
        /delete_employee/{empID}:DELETE:Deletes the record with given Id. Takes id as a parameter. 
    
        /search:GET:Get an employee by giving firstName as a parameter.
  
        /sort:GET: Lists all employees in sorted order. Takes string parameter as order (asc/desc)



------------
Permissions:
------------
	=> The application has one admin data added to the DB at runtime using Commandline runner. 
	(username : admin1, password : 123)
	
	=> All endpoints of UserController require ADMIN role to run.
	
	=> In EmployeeController, add endpoint is accessible to ADMIN only. Other endpoints can be used by 
	both ADMIN and USER.
	

	
------------
Screenshots: 
------------
	> Please find the screenshots in 'Screenshot' folder. They have been divided into three folders based on the entites and their usecases. 
