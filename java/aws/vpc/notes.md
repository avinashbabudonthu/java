# VPC Virtual Private Cloud
* Provides private, isolated virtual network on AWS cloud
* High level view\
![picture](imgs/high-level-view.jpg)

# Connection
* AWS Hardware VPN
* AWS Direct Connect
* AWS VPN Cloubhub
* Software VPN

# Notes
* allows secure the resources into groups that follow access rules. VPC contains subnets called public and private subnets. VPCs control routing with Route Table and Network Access Control List (ACL)
* Why VPC
	* Security resources and groups and follow logical spaces to share resources
	* VPC allow developers to create virtual network where they can launch resources and have them logically isolated from other VPCs and outside world. 
	* With VPC our resource can have IP addresses with which they communicate with other VPCs
	* We can control access to all the resources inside VPCs
	* VPCs are Free service by AWS. But we can have maximum of 5 VPCs per account
* VPC structure	
	* Virtual Private Cloud subnets
* Types of Subnets
	* public subnet
	* private subnet
* public subnet	
	* access to internet
	* use security groups to make it secure
	* contains NAT, Jump Box, Load Balancer etc
* private subnet
	* contains DB and EC2 instances
	* no access to internet
	* can use NAT gatway to access internet in public gateway
* VPC security tools
	* Routing Tables
	* Network ACL (Access Control Level)
* One of the widely used tools in VPC
	* Security Groups
	* Network Access Control list
* Security Group
	* Collection of IPs that are allowed to connect to your instance, and IPs that instance allowed to connect to
	* Security groups are attached at the instance level and can be shared among many instances
	* We can configure security groups to allow other security groups instead of IP addresses
* VPCs use Routing Tables
	* to configure routing destination for traffic coming out of the VPC
	* Each VPC has one routing table which declared attempted destination Ips and where they should be routed to
* Network Access Control List
	* Each VPC will have one access control list which acts as IP filtering table
* Subnet
	* Sub set of VPC
	* EC2 instances will be launched in subnets

# Creating Virtual Private Cloud
* AWS Console
* click VPC
* VPC dashboard will load
* click Start VPC Wizard button
* left side we will see type of VPCs we want to launch
* click "VPC with Single public subnet"
* click Select button
* IP CIDR Block (available IP addresses, we can choose any)
* VPC Name = Appliction name
* Public subnet is subset of VPC block
* Select Availability Zone from drop down
* Give Subnet name (ex: test-subnet-a)
* keep other options default
* click Create VPC button
* Once process done we are ready to launch EC2 instances in this VPC
* The routing table that was created with this VPC currently doesn't have any way for instances to connect to internet. So we do need to add entry to routing table to allow all traffic to go through internet gateway into the public internet. Intenet gateway is just a connection to the internet

# Confguring Routing Table
* Click Your VPCs link on left side menu
* In the VPC list select our VPC
* Click Summary tab
* click on the link next to Route Table
* We will navigate to a screen where we can see route table entry
* click route table entry
* click Routes tab
* click Edit button
* click Add Another Route button
* In the Destination enter 0.0.0.0/0 (means any IP)
* On clicking Target we can see auto suggestion select it
* Click Save button
* Now our VPC configured to reach outside world

# Configuring to add another Subnet from another availability zone
* click Subnets on left side menu
* click Create Subnet button
* Enter `test-subnet-a` in Name Tag
* Select VPC we created in the VPC drop down
* In the availability zone drop down select a different zone than subnet-a -> Give 10.0.1.0/24 in CIDR block
* Click `Yes, Create` button