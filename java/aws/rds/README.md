# RDS Relational Database Services
* Collection of AWS services to manage relational databases
* Managed database aspects and benefits
	* AWS will take care of
		* Scheduled automated backups
		* Software Updates
		* Managed infrastructure
		* configure security groups for database security
* RDS databases managed by AWS
	* Oracle
	* Microsoft SQL Server
	* MySQL
	* Postgres
	* Maria DB
	* IBM DB2
	* Aurora (AWS Proprietary database)
* RDS pricing depends on
	* type of database
	* region
	* EC2 instance type
------
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
------
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
------
# Connecting to PostGre database created above
* We need to use any of the below tools
	* Postico
	* pgAdmin
* Open Postico
	* click on New Favorite button
	* Nickname: local nick name for DB
	* Host: expand database row in AWS RDS web console, copy End point
	* Port: port our database is running
	* enter username and password
	* enter database name what we gave while creating DB
	* click Connect button
	* now connected to DB
------
# create table in PostGre database created above
* After connecting to database
* click on `+Table` button
* give table name, column names etc
* click Save Changes button
------
# Advantages of using RDS versus deploying DB in EC2
* RDS managed Services
	* Automated provisioning, OS patching
	* Continuous backups and restore to specific timestamp (Point in Time Restore)
	* Monitoring Dashboard
	* Read replicas for improved read performance
	* Multi AZ setup for DR (Disaster Recovery)
	* Maintenance window for upgrades
	* Scaling capability (Horizontal and Vertical)
	* Storage backed by EBS (gp2 or IO1)
* BUT we can't SSH into your RDS running instances
------
# RDS Storage Auto Scaling
* Helps you increase storage on your RDS DB instance dynamically
* When RDS detects that you are running out of storage, it scales automatically
* Avoid manual scaling your database Storage
* You have to set `Maximum storage threshold` (Maximum storage limit for DB storage)
* automatically modify Storage if
	* Free storage is `< 10%` of allocated Storage
	* Low storage lasts atleast 5 min
	* 6 hours have passed since last modification
* Useful for application with unpredictable work loads
* Supports all RDS database engines\
![picture](imgs/001-rds-storage.jpg)
------
# RDS Read Replicas vs Multi AZ
* Upto 15 Read replicas
* Within AZ, Cross AZ, Cross region
* Replication is ASYNC, so reads are eventually consistent
* Replicas can be promoted to their own DB. Means we can make read replica as main db, then it will be out from read replicas list and have it's own database life cycle
* Applications must update the connection string to leverage read replicas\
![picture](imgs/001-read-replicas.jpg)
------
# RDS Read Replicas Use Cases
* You have production database taking normal load
* You want to run some reporting application to run some analytics
* You create `Read Replica` to run new workload
* The production application is unaffected
* Read replicas are used for `SELECT` only kind of statements (not INSERT, UPDATE, DELETE)\
![picture](imgs/001-read-replica-use-case.jpg)
------
# Read replica network cost
* In AWS there is network cose when data goes from one AZ to another
* For RDS Read Replicas with in same region (means different AZ with in same region) then it is free
* Pay only if read replica is in another region\
![picture](001-read-replica-network-cost.jpg)
------
# RDS Multi AZ DR - Disaster Recovery
* Sync replicas - instant replication to standby instance
* One DNS name - automatic app failover to standby
* Increase availability
* Failover in case of loss of AZ, loss of network, instance or storage failure
* No manual intervention in apps
* Not used for scaling
* Read replicas can be setup as Multi AZ for DR\
![picture](imgs/001-multi-az-dr.jpg)
------
# RDS - from single Az to multi AZ
* Zero downtime operation (no need to stop DB)
* Just click on `modify` for the Database
* Following steps happens internally
	* Snapshot is taken
	* New DB is restored from Snapshot in new AZ
	* Synchronization is established between two databases\
![picture](imgs/001-rds-from-one-az-to-multi-az.jpg)
------
# RDS Custom
![picture](imgs/001-rds-custom.jpg)
------
# Amazon Aurora
* Properietary technilogy from AWS (not open sourced)
* Postgres and MySQL both supported as Aurora DB (that means your driver will work as if Aurora was MySQL or Postgres)
* Aurora is cloud optimized. Claims 5x performance improvement over MySQL on RDS, 3x performance improvement over Postgres on RDS
* Aurora storage automatically grows in increments of 10 GB, up to 128 TB
* Aurora can have upto 15 replicas. Replication process is faster than MySQL (sub 10 ms replica lag)
* Failover in Aurora in instantaneous. It's HA (High availability) native
* Aurora costs more than RDS (20% more), but more efficient

# Aurora High Availability and read scaling
![picture](imgs/001-aurora-high-availability-read-scaling.jpg)

# Aurora DB Cluster
![picture](imgs/001-aurora-db-cluster.jpg)

# Features of Aurora
* Automatic fail over
* Backup and Recovery
* Isolation and security
* Industry Compliance
* Push button scaling
* Automatic patching withzero downtime
* Advanved Monitoring
* Routine Maintenance
* Backtrack: restore data at any point of time without using backups

# Aurora Replicas Auto scaling
![picture](imgs/001-aurora-replicas-auto-scaling.jpg)

# Aurora Custom Endpoints
* Define subset of aurora instances as customg Endpoints
* Example: In the picture below we have 2 read replicas which are big in size. Because we can define custom endpoints to those replicas and run analytical queries on specific replicas\
![picture](imgs/001-cutom-endpoints.jpg)

# Serverless
* Automated database instantiation and auto-scaling based on actual usage
* Good for infrequent and unpredictable work loads
* No capacity planning needed
* Pay per second, can be very cost effective\
![picture](imgs/001-serverless.jpg)

# Global Aurora
![picture](imgs/global-aurora.jpg)

# Machine Learning
![picture](imgs/machine-learning.jpg)

# Database Cloning
![picture](imgs/cloning.jpg)
------
# Backup and Monitoring

# RDS Backup
* ![picture](imgs/rds-backups.jpg)

# Aurora Backup
* Automatec backups
	* 1 to 35 days. Cannot be disabled
	* point in time recovery in that timeframe
* Manual DB Snapshots
	* Manually triggered by user
	* Retention of backup for as long as you want

# RDS Aurora restore options
![picture](imgs/rds-aurora-restore-options.jpg)

