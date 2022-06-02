# Overview of Google Cloud Platform - GCP 
* GCP has
	* 20 Regions
	* 61 zones
	* 134 network edge locations
	* available in 200+ countries and territories
	* Still expanding
	* For most recent updates on regions, locations etc refer [https://cloud.google.com/about/locations](https://cloud.google.com/about/locations)
	* 1537 (approximately) services
* Zone
	* Data center
	* High availability, reliability, redundancy
	* When application is launched we generally make it available in multiple zones to make application highly available
* Region
	* Collection of multiple data centers
	* 1 Region will have atleast 2 zones
* Network edge locations
	* Delivers static content to enhance user experience
	
# Building blocks of GCP
* Core
	* Compute
	* Storage
	* Network
		* Enables communication across multiple applications and services offered by google
* Databases
	* Sql
	* NoSql
* Data & Analytics
	* Business Intelligence and Data warehouse
* AI & Machine Learning
* Hybrid & Multi-cloud
* API Management
* Migration
	* To migrate work loads from on premises to cloud
* Security
* Devops Tools
* Management Tools
	* Services through which customers can interact and manage their deployments\
![picture](pictures/building-blocks.jpg)

# Key GCP services
* Compute
	* Compute Engine - GCE - Google Compute Engine
		* IaaS - Infrastructure as a Service
		* Similar to AWS EC2
	* App Engine - GAE - Google App Engine
		* PaaS - Platform as a Service
	* Kubernetes Engine - GKE - Google Kubernetes Engine
		* CaaS - Container as a Services
	* Google Container Registry - GCR
		* Manages docker container images
	* Cloud Functions
		* Similar to AWS Lambda
* Storage and databases
	* Cloud storage
	* Cloud datastore
	* Persistent disk
	* Cloud Bigtable
	* Cloud spanner
	* Cloud Sql
	
* Network
	* Cloud virtual network
		* Hybrid and isolated network capabilities within the public cloud
	* Cloud load balancing
		* Routes the traffic across multiple instance of the application
	* Cloud CDN
	* Cloud interconnect
	* Cloud DNS
* Security & Identity
	* Cloud IAM
	* Cloud resource manager
	* Cloud security scanner
	* Cloud platform security
* AI & Machine Learning
	* Cloud machine learning
	* Vision API
	* Speech API
	* Natural language API
	* Translation API
	* Jobs API
* Devops tools - provides automation capabilities
	* Cloud SDK
	* Deployment manager
	* Cloud source repositories
	* Cloud tools for android studio
	* Cloud tools fo IntelliJ
	* Powershell cloud tools
	* Virtual studio cloud tools
	* Plugin for eclipse
	* Cloud test lab
* Management tools - provides insights to existing deployments
	* Stackdriver
	* Monitoring
	* Logging
	* Error reporting
	* Trace
	* Debuggger
	* Deployment manager
	* Cloud endpoints
	* Cloud console
	* Cloud shell
	* Cloud machine app
	* Billing app
	* Cloud APIs

# Other GCP services
* API analytics
* IOT core
* VPN
* AutoML
* Transfer appliance
* Beyond corp
* File store
* Memory store

# Get started with GCP
* Open url - [https://cloud.google.com/free](https://cloud.google.com/free)
* Click on `Get started for free` button
* We need to give credit card information for signup
* Google charges minimal amount on credit card and that will be refunded
* Once signup, we will be navigated to `Google cloud platform console`

# Set an alert on billing
* Click on menu icon on top left
* Click `Billing` link
* Click on `Budgets & alerts` link in left menu
* Click on `CREATE BUDGET` link
* Follow the instruction to create alert

# GCP platform resources
* Anything we launch is creation of resource like
	* GCE VMs
	* Cloud pub/sub topics
	* cloud storage buckets
	* etc
* Reources belong to project
* In GCP project directly represents the billable unit. Any resource we launch is associated with project. Every resource under project is directly billed
* Projects may be organized into folders
	* We can have multiple projects under Dev, Test, Prod
* Each project can be associated with different credit card
* Folder may belong to one and only one organization. This is optional
* Organization is top level entity in GCP hierarchy
* Organization will be available only if we have `GSuite` account
* GCP resources hierarchy - (OFPR)\
![picture](pictures/gcp-resources-hierarchy.jpg)

# Interactive with GCP
* Web console
	* Front end GUI
* Cloud shell, cloud SDK
	* For devops engineers
	* comes with `CLI`
	* Cloud SDK can be installed in windows, linux, mac machines
	* Cloud shell is terminal built into the browser. Without installing anything we can quickly interact with GCP
* Mobile App
* REST API\
![picture](pictures/interacting-with-gcp.jpg)

# Accesing GCP cloud shell
* Interactive shell environment for GCP
* Accessible from web browser
* Comes preloaded with `IDE, gcloud SDK` and other tools
* Backed by GCE VM comes with 5 GB of disk storage
* In-built web preview functionality
	* If we launch an application on any port. we will be able to access that by clicking button in cloud shell environment

# Interacting with GCP using cloud shell
* Signin to GCP console - [https://cloud.google.com/free](https://cloud.google.com/free)
* Click `Actiave Cloud Shell` icon on top right corner\
![picture](pictures/activate-cloud-shell.jpg)
* Cloud shell display below popup\
![picture](pictures/cloud-shell-1.jpg)
* Click `Continue` button
* Execute following command
```
gcloud compute regions list
```
* GCP shell commands - refer [commands.md#gshell-commands](commands.md#gshell-commands)

# Google compute services
* Code is deployed and executed in one of the compute services
* GCP offers following compute services
	* Compute Engine - GCE
		* IaaS - Infrastructure as a Service
	* App Engine - GAE
		* PaaS - Platform as a Service
	* Kubernetes Engine - GKE
		* Orchestration platform
		* To manage containers
	* Cloud Functions
		* FaaS - Functions as a Service
		* Serverless environment to execute where we don't need to launch VM or package our code

# App Engine
* PaaS - Platform as a Service
* First service lauched by Google
* Fully managed platform for deploying web app at scale
	* When traffic increases App Engine automatically scale the application
* Supports to multiple languages, frameworks and libraries
* Available in 2 environments
	* Standard
	* Flexible
* Application deployed in `standard` environment run in a sandbox. There are some limitations in standard environment
* If we want more control, decide what configurations for our application, what dependencies need to be installed and have complete control on packaging and deployment then we have to use `Flexible` environment.
	* This environment uses Docker containers
* App engine environments dos - [https://cloud.google.com/appengine/docs/the-appengine-environments](https://cloud.google.com/appengine/docs/the-appengine-environments)

# GCE Google Compute Engine
* IaaS - Infrastructure as a Service
* Enables to lauch Linux and windows virtual machines
* VMs are based on machine types with various CPU and RAM configurations

# GKE Google Kubernetes Engine
* CaaS - Container as a Service
* Managed environment for deploying containerized applications managed by kubernetes
* Bring in container images, package them as kubernetes artifacts, deploy them, scale them through GKE
* Kubernetes has control panel and worker node
* GKE provisions worker node as GCE VMs
* This service is tightly integrated with GCP resources such as storage, network and monitoring
	* For example if we expose service using GKE it will be using load balancer
	* GKE infrastructure is monitored by `stackdriver`
* Auto scaling
* Automatic upgrades
* Auto repair of nodes

# Google Cloud Functions
* Serverless executing environment for connecting and building cloud services
* Serverless compute environments excute code in response to an event
* We write code as function which has entry point and exit point
* Cloud Functions supports Javascript, Python 3, Go
* GCP events fire cloud functions through a trigger
	* Trigger connects external resource to cloud function
* One classic example of cloud function is
	* Creating a thumbnail whenever image uploaded to cloud storage
	* Uploading image to cloud storage is an event. This triggers cloud function which generates thumbnail using image library/API
* Triggers connect event to function
	* Define an event
	* Connect it to the funciton
	* Every time event occured Trigger will invoke a function

# Launching GCE instance
* Sign in to GCP console
* Left menu
	* Compute Engine
		* click `VM instances`
* Click `Create` button
* Give instance name. Ex: `instance-1`
* Select Region. Ex: `asia-south1(Mumbai)`
* Select Zone. Ex: `asia-south1-a`
* Machine configuration
	* Select `Machine type` - `e2-micro` to be in free limit
* Firewall
	* Check `Allow HTTP traffic`
* Click `Create` button
* This will take some time. Once VM is launched we can see Green tick\
![picture](pictures/launching-gce-instance.jpg)
* Check list of compute instances using gcp shell
```
gcloud compute instances list
```
* Connect to GCE VM instance via SSH
```
gcloud compute ssh <instance-name> --zone <zone-name>

gcloud compute ssh instance-1 --zone asia-southeast1-c
```
* Update the packages in linux VM
```
sudo apt-get update
```
* Install apache2
```
sudo apt-get install -y apache2
```
* Start apache2
```
sudo systemctl start apache2
```
* Click `External IP`\
![picture](pictures/launching-gce-instance-2.jpg)
* Result\
![picture](pictures/launching-gce-instance-3.jpg)

# Use cases for GCP compute services
![picture](pictures/compute-services-use-cases.jpg)

# Storage Services
* Storage services are classified into three types
	* Object storage
	* Block storage
	* Cloud Filestore
* GCP storage services
	* Cloud Storage - GCS - Google cloud storage
	* Persistent disk
	* Cloud Filestore

# Google Cloud Storage GCS
* Object storage in GCP environment
* Applications store and retrieve objects through API
* GCS is designed 99.99% durability
	* Chance of loosing is nill
* Data can be stored in single region, dual region or multi region

# Google cloud storage - storage classes
* Standard
	* Low latancy
	* High frequency access
* Nearline
	* Low frequency access
* Coldline
	* Lowest frequency access
* High performance object storage
	* Standard
* Backup and archival storage
	* Nearline
	* Coldline
	
# Persistent disk PD
* Block storage service
* Attached to GCE VMs
* Disks are independent of compute engine VMs. Can retain it even after VM is terminated
* Each disk can scale up to 64TB in size
* Persistent disks have one writer and multiple readers
	* we can attach one PD to multiple VMs where 1 VM act as writer and all other will act as readers
* Supports both SSD and HDD storage options
* SSD is best for I/O intensive applications
* PD available in 3 storage types
	* Zonal
	* Regional
	* Local
	
# Cloud Filestore
* File system as a service
* Centralized, highly available filesystem for GCE and GKE
* Filestore has built-in zonal storage redundancy for high availability
	* When we store data that will be replicated to multiple zone automatically
* Data always encrypted while in transit

# Demo google cloud storage
* Sign in to GCP console
* Left menu
	* Storage
	* Browser
* Click `+ CREATE BUCKET` button
* Follow the instructions to create bucket
* Once bucket is created, click `CREATE FOLDER` button
	* Give folder name
	* Click `CREATE` button
* Once folder is created, click on folder name
	* Click `UPLOAD FILES` button
	* Upload any file into folder\
![picture](pictures/cloud-storage-upload-file-1.jpg)

# Use cases of GCP storage services
* Use cases of google cloud storage services\
![picture](pictures/cloud-storage-use-cases.jpg)

# GCP network services
* One of the key building blocks of GCP
* Leverages Google's global network for connectivity
	* Advantages of GCP is customers will be using same global network where google services like Youtube, Gmail etc are running on
* GCP offers `standard` and `premium` tiers
* Load balancers route traffic evenly to multiple instances of applications
* `Virtual Private Cloud (VPC)` provides private and hybrid networking
* Customers can extend their data center to GCP through hybrid connectivity

# GCP network service tiers
* Network service tiers choice of traffic optimization
* There are 2 service tiers
	* Standard
	* Premium
* Premium tier delivers traffic via Google's premium backbone that powers rest of Google services like Google search, Youtube, Gmail etc
* Standard tier regular connectivity based on ISP network
	* This is based on 3rd party connectivity
	* Does not use high throughput, high performance network backbone
	* Cheaper than premium tier
* GCP uses premium tier as default option
* Network services docs - refer [https://cloud.google.com/network-tiers/docs/overview](https://cloud.google.com/network-tiers/docs/overview)

# Google cloud load balancing
* Distributes traffic across multiple GCE VMs in a single or multiple regions
* When load balancers are put in front of GCE VMs, can route the traffic across multiple instances
* There are 2 types of load balancers
	* HTTP(S) load balancer
	* Network load balancer
* HTTP(S)
	* Global load balancing
	* Used for routing traffic to web apps that are deployed in more than one zone/region
* Network load balancer
	* Routing the traffic across multiple TCP and UDP endpoints within the same region
* Both types can be used as internal or external load balancers. check the image below how we can use external and internal load balancers
	* When request comes based on user location external load balancer will route the request to nearest region
	* Once  request reaches web tier we have to use internal load balancer to route the request to one of the instances of application. In below image `Internal Tier` is application\
![picture](pictures/load-balancers-1.jpg)

# Virtual private cloud
* Software defined network to enable private networking for VMs within the public cloud
* VPC network is global resource with regional subnets
	* global resource means we can create VPC that is visible from any of the regions
	* After that we can create subnet per region which is attached to same VPC
* Each VPC is isolated from each other
	* One VPC cannot see the resources deployed in another VPC
	* If we are creating multiple VPC then we need to explicitely allow communiation between these VPCs by creating Firewall rules
* Firewall rules - allow or restrict traffic within subnets
* General practice is to create 1 public subnet and multiple private subnets, keep sensetive resources within the private subnets. Private subnets are never exposed to the outside world. Only those resources deployed in public subnets are visible to outside world. Public subnets act as channel to access resources in private subnets
* Resources with VPC communicate via IPV4 address. There is DNS service within VPC that provides name resolution
* VPC networks can be connected to other VPC networks through `VPC Peering`
* VPC networks are securely connected in hybrid environment using `Cloud VPN` or `Cloud Interconnect`

# GCP hybrid connectivity
* Extends local data center to GCP
* 3 GCP services enable hybrid connectivity
	* Cloud VPN
	* Cloud Interconnect
	* Peering
* Cloud Interconnect extends on-premises network to GCP via Dedicated or Partner Interconnect
* Cloud VPN connectes on-premises to GCP securely over public internet
	* Economical mechanism to extend data center 
* Peering enable direct access to Google cloud resources with reduced internet egress fee
	* egress fee - bandwidth charged for outbound connectivity
	* When we are making request to GCP from on-premises there is egress free. In peering this egree fee is much lower when compared to cloud interconnect

# Instance Template
* When we are launching multiple VMs, instead of creating them independently and configuring them exactly with same settings and softwares, we can create `Instance Template`
* So `Instance Template` act as blue print for launching multiple GCE VMs
* Go to 
	* Compute Engine
	* Intance Templates\
![picture](pictures/instance-templates-1.jpg)
* Click `Create instance template` button
* Select the approprivate values for each section
* Select `Allow HTTP traffic`
* If we want to run any script automatically after launching GCE VM, then we need to put that script in `Automation > Startup script`. Following is sample script to install apache, create default index.html and displays hello from hostName
```
#! /bin/bash
apt-get update
apt-get install -y apache2
cat <<EOF > /var/www/html/index.html
<html><body><h1>Hello from $(hostname)</h1>
</body></html>
EOF
```
* Click `Create` button

# Demo on configuring load balancing
* Requirement
	* Create 2 VMs deployed in a region connected to a load balancer
	* Traffic is routed evenly across the instances
* Create [Instance Template](#instance-template)
* Click `Instance groups` in `Compute Engine` left menu
* Click `CREATE INSTANCE GROUP` button
* Enter following details
	* Name
	* Description
	* Location - select `Multiple zones`
	* Select `Region`
	* Select `Instance Template` created above
	* Turn off `Auto-scaling > Auto-scaling mode`
	* Number of instances - 2
	* Maximum number of instances - 2
	* Create `Autohealing/Health check`
	* Initial Delay - 120 seconds
	* Click `Create` button
	* This will take time. Once instances created we will see green ticks\
* Below image is not created yet.. take screen shot once instances are created
* Once instances are created, go to `VM instances`. We can see 2 instances

# Use cases of GCP network services
![picture](pictures/gcp-network-services-use-cases.jpg)

# Identity and Access Management - IAM
* Defines `who`(identity) has `what` access(role) to `which` resources
	* who == Members
	* what == Roles
	* which == Permissions
* Cloud IAM is based on principle of `least privilege`. Means by default all resources are `denied access` and we need to open access explicitely. 
* IAM policy binds identity to roles which contains permissions
* Permissions are grouped together into role and that role is assigned to a member. Then member will inherit all permissions associated with the role
* Policy binds `Member identity` and `Roles` together\
![picture](pictures/iam-1.jpg)

# Google cloud database services
* Cloud Sql
* Cloud Bigtable
* Cloud Spanner
* Cloud Memorystore

# Cloud Sql
* Fully managed RDBMS service that simplifies setup, maintain, manage, administration of database instances
* Supports 3 types of RDBMS
	* MySql
	* PostgreSql
	* Microsoft Sql Server
* Advantages
	* Scalability
	* Availability
	* Reliability
	* Security

# Cloud Bigtable
* Petabyte-scale, managed NoSql database service
* Scale to billions of rows and thousands of column
* Large scale, low latency applications
* Alternative to running apache HBase column oriented database in VMs

# Cloud Spanner
* Managed, scalable, relational database service for regional and global application data
* Scales horizontally across regions and continents
* Brings best of relational and NoSql databases
* Supports ACID transactions and ANSI SQL queries
* Data is replicated synchronously with globally strong consistency
	* If we are running 2 instances of cloud spanner, As soon as we write in 1 instance, data will be replicated in other instances
* Cloud spanner instances run in one of the three types:
	* Read-Write
	* Read-Only
	* Witness

# Cloud Memorystore
* Fully managed in-memory data store service based on Redis
* Idea for application caches
* Can support up to 300 GB and network throughput of 12 Gbps
* Fully compatible with Redis protocol
	* Any application integrated with Redis can migrated to Memorystore without any changes
* Integrated with `Stackdriver` for monitoring

# Use cases
![picture](pictures/database-services.jpg)

# Google Cloud Sql Instance demo