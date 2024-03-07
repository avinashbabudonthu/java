# VPC Virtual Private Cloud
* Provides private, isolated virtual network on AWS cloud
* High level view\
![picture](imgs/high-level-view.jpg)

# Connection
* AWS Hardware VPN
* AWS Direct Connect
* AWS VPN Cloudhub
* Software VPN

# what is cidr
* CIDR stands for Classless Inter-Domain Routing. It's a method for allocating IP addresses and routing data packets on the internet. It replaced the older system of using IP address classes (A, B, and C), which was inefficient and limited.
* Here's a breakdown of how CIDR works:
	* IP addresses: These are unique numerical labels assigned to devices on a network. They consist of four sets of numbers separated by periods, like 192.168.1.1.
	* Subnet mask: This defines the network portion of an IP address and the host portion. It's like a mask that you overlay on the IP address to separate these parts. Traditionally, subnet masks were based on fixed class ranges.
	* CIDR notation: This combines the IP address and subnet mask into a single, more flexible notation. It uses a forward slash (/) followed by a number that specifies the number of leading 1s in the subnet mask. For example, 192.168.1.0/24 is equivalent to the traditional subnet mask 255.255.255.0.
* Benefits of CIDR:
	* More efficient allocation of IP addresses: CIDR allows for subnetting IP addresses into smaller, more specific blocks, which reduces wasted address space.
	* Improved routing: Routers can use CIDR to determine the best path for data packets to travel, based on the network portion of the IP address.
	* Scalability: CIDR can be easily adapted to accommodate growing networks.
* Understanding CIDR Notation:
* CIDR uses a special notation to represent both the IP address and the network prefix length. This notation takes the form:
* IP address / number of prefix bits
	* For example, consider the address 192.168.1.0/24:
		* 192.168.1.0: This is the base IP address.
		* /24: This indicates that the first 24 bits represent the network prefix, while the remaining 8 bits are used for identifying individual hosts within the network.
	* Breaking Down the Network and Host Bits:
		* In an IP address, each byte consists of 8 bits. Therefore, a total of 32 bits make up an entire IPv4 address. With CIDR, the prefix length specifies how many of these bits are dedicated to identifying the network itself, leaving the remaining bits for assigning unique addresses to devices within that network.
* Here's how the example translates:
	* Network address: The first 24 bits (192.168.1) identify the network itself. All devices sharing this prefix belong to the same network.
	* Broadcast address: The last address in the network is obtained by flipping all the remaining host bits to 1. In this case, the broadcast address would be 192.168.1.255.
	* Usable host addresses: Since 2 bits are used for the network and broadcast addresses, the remaining 254 addresses (2^8 - 2) can be assigned to individual devices within the network.

# AWS CIDR IP address allocation
* In AWS, CIDR plays a crucial role in managing IP addresses for your Virtual Private Clouds (VPCs) and subnets. Here's a breakdown of its key aspects
* What is it?
	* AWS uses CIDR blocks to define the range of IP addresses available for your resources within a VPC and its subnets.
	* Each CIDR block consists of an IP address and a subnet mask represented by a slash notation (e.g., 10.0.0.0/16).
	* The subnet mask determines how many IP addresses are usable within the block. Smaller subnet masks (larger CIDR blocks) provide more addresses but less granularity, while larger masks (smaller CIDR blocks) offer finer control but fewer addresses.
* Allocation Methods:
	* Manual allocation: You choose the CIDR block size and specify it when creating your VPC or subnet.
	* Amazon VPC IP Address Manager (IPAM): This centralized service allows you to manage and track IP addresses across your VPCs and subnets. You can create pools of CIDR blocks and allocate them to specific resources.
* Key Considerations:
	* Planning: Decide on the necessary number of IP addresses for your workloads to avoid running out or wasting space.
	* Security: Choose private IP address ranges defined in RFC 1918 for your VPCs.
	* Scalability: Select CIDR blocks large enough to accommodate future growth.
	* Subnet design: Plan subnet sizes based on your network segmentation needs and desired level of control.
* Additional Resources:
	* AWS documentation on VPC CIDR blocks: https://docs.aws.amazon.com/vpc/latest/userguide/configure-your-vpc.html
	* AWS documentation on IPAM: https://docs.aws.amazon.com/vpc/latest/ipam/getting-started-ipam.html
	* Blog post on best practices for CIDR allocation: https://docs.aws.amazon.com/vpc/latest/userguide/configure-your-vpc.html

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
	* Network ACL (Access Control List)
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