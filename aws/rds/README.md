# RDS Relational Database Services
* Collection of AWS services to manage relational databases
* Managed database aspects and benefits
	* AWS will take care of
		* Scheduled automated backups
		* Software Updates
		* Managed infrastructure
		* configure security groups for database security
* RDS database options
	* Oracle
	* SQL Server
	* MySQL
	* Postgre SQL
	* Maria DB
	* Amazon Aurora
* RDS pricing depends on
	* type of database
	* region
	* EC2 instance type
* No SQL Database
	* DynamoDB
* Data warehouse
	* Red Shift

# Create PostgreSQL database instance
* AWS web console
* RDS
* Left side we can see dashboard menu
* If we are coming here for the first time, we can see Get Started Now button
* click on Get Started Now button
* Select the database engine we want to create (I am selecting PostgreSQL)
* click on Select button 
* select the purpose for creating this DB instance (production - for creating Multy A(vailibility)-Z(one) database, Dev/Test - single instance), i am selecting Dev/Test
* click on Next Step button
* Fill the details appropriately
* click Next Step button
* VPC drop down: select our VPC created before. Check [here](https://github.com/avinashbabudonthu/aws/tree/master/vpc) to know how to create VPC
* Publicly Accessable: yes
* Database Name: any user defined name
* keep the rest of options to defaults
* click Launch DB Instance button
* This will take some time

# Security group created for the database created above
* AWS web console
* RDS
* click on Instances on left menu
* Expand database row
* click on magnifying glass document icon
* click on link available for Security Groups
* click on Inbound tab
* here we can see port for connecting to PostGre SQL DB
* IP Address will be default to our system IP address. If we want to change IP Address
* click on Edit button
* change Source to Anywhere
* click Save button

# Connecting to PostGre database created above
* We need to use any of the below tools
	* Postico
	* pgAdmin
* Open Postico
	* click on New Favorite button
	* Nickname: local nick name for DB
	* Host: expland database row in AWS RDS web console, copy End point
	* Port: port our database is running
	* enter username and password
	* enter database name what we gave while creating DB
	* click Connect button
	* now connected to DB
	
# create table in PostGre database created above
* After connecting to database
* click on `+Table` button
* give table name, column names etc
* click Save Changes button