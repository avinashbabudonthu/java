# ELB Elastic Load Balancing
------
# What is load Balancing?
![picture](imgs/what-is-load-balancing-1.jpg)
------
# Why load balancing
* Spread load across multiple downstream instances
* Expose single point of access (DNS) to your application
* Seamlessly handle failures of downstream instances
* Do regular health checks to your instances
* Provide SSL termination (HTTPS) to your websites
* Enforse stickiness with cookies
* High availability across zones
* Separate public traffic from private traffic
------
# Why use Elastic Load Balacer
* It is `managed load balancer`
	* AWS guarantees that it will be working
	* AWS takes care of upgrades, maintenance, high availability
	* AWS provides only few configuration knobs
* it costs less to setup own load balancer but it will be lot more effort
* It is integrated with many AWS services
	* EC2, EC2 Auto Scaling Groups, Amazon ECS
	* AWS Certificate Manager (ACM), CloudWatch
	* Route 53, AWS WAF (Web Application Firewall), AWS Global Accelerator
------
# Health checks
* Health checks are crucial for load balancers
* They enable load balancer to know if instance it forwards traffic to are available to reply requests
* Health check is done on `port and route (/health is common)`\
![picture](imgs/health-check-1.jpg)
* If response is not 200 (OK) then instance in unhealthy. Then elastic load balancer do not send traffic to that instance
------
# Types of load balancers
![picture](imgs/001-load-balancer-types.jpg)
------
# Load balancer security Groups
![picture](imgs/001-load-balancer-security-groups.jpg)
------
# CLB Classic Load balancer
* The Classic Load Balancer is deprecated at AWS and will soon not be available in the AWS Console.
* The exam also has removed any references to it
------
# ALB Application Load Balancer
* Application load balancer is layer 7 that is HTTP
* Load balancing to multiple HTTP application across machines (target groups)
* Load balancing to multiple applications on the same machine (Ex: containers)
* Support for HTTP/2 and WebSocket
* Support redirects (Ex: from HTTP to HTTPS)
* Routing tables to different target Groups
	* Routing based on path in URL (Ex: exampe.com/users & /example.com/posts)
	* Routing based on hostname in URL (Ex: one.example.com & two.example.com)
	* Routing based on query string, headers (example.com/users?id=123&order=true)
* Great fit for microservices and container based applications (Ex: Docker & Amazon ECS)
* Has port mapping feature to redirect to dynamic port in ECS
* In case of CLB, we will need one CLB per application. But in case ALB, one ALB for multiple applications\
![pipcture](imgs/01-http-traffic.jpg)

# ALB Target Groups
* EC2 instances (can be managed by auto scaling groups) - HTTP
* ECS tasks (managed by ECS itself) - HTTP
* Lambda functions - HTTP requests translated into JSON event
* IP Addresses - must be private IPs
* ALB can route multiple target groups
* Health checks at target group level\
![picture](imgs/query-string-parameter-routing.jpg)

# ALB Good to know
* Applications should have fixed hostname
* Application servers don't see IP of client directly. Request comes from client to load balancer then route to application using load balancer private IP 
	* True IP of client inserted in the header `X-Farwarded-For`
	* Port in header `X-Forwarded-Port`
	* Proto in header `X-Forwarded-Proto`\
![picture](imgs/good-to-know.jpg)
------
# NLB Network Load Balancer
* Network load balancer is layer 4
	* Forward TCP & UDP traffic to your instance
	* Handle millions of requests per second
	* Less latecy ~100 ms (vs ~400 ms for ALB)
* NLB has `one static IP per AZ`. Supports assigning Elastic IP (helpful for whitellisting specific IP)
* NLB are used for extreme performance, TCP or UDP traffic
* Not included in AWS free tier\
![picture](imgs/001-network-load-balancer.jpg)

## Targer Groups
* EC2 instances
* IP addresses. Must be private IPs
* Application load balancer\
![picture](imgs/nlb-target-groups.jpg)
* Health check support 3 different protocols - TCP, HTTP, HTTPS Protocols
------
# Gateway Load Balancer
* Operates at Layer 3 (Network Layer) - IP Packets
* Combines following functions
	* Transparent Network Gateway - single entry. Exit for all traffic
	* Load Balancer - distributes traffic to virtual appliances
* Deploy, scale, & manage fleet of 3rd party network virtual appliances in AWS
	* Example: Firewalls, Intrusion Detection and Prevention Systems (IDPS), Deep Packet Inspection System (DPIS), Payload manipulation\
![picture](imgs/001-gateway-load-balancer.jpg)
* Uses `GENEVE` protocol on port `6081`

## Target Groups
* EC2 instances
* IP Addresses - must be private IPs\
![picture](imgs/gwlb-target-groups.jpg)
------
# Sticky sessions
* Sticky sessions called `Session Affinity`
* It is possible to implement stickiness so that the same client is always redirected to the same instance behind the load balancer
* This works for Classic load balancer, Application load balancers, Network load balancer
* `Cookie` used for stickiness has `expiration date` that you can control. Means after expiration date, request will be redirected to any available application instance
* Use case: make sure user don't lose session data\
![picture](imgs/001-elb-stickiness.jpg)
* Enabling stickiness may bring imbalance to the load over the backend EC2 instances

## Sticky sssions - cookie names
* Application based cookie
	* Custom cookie
		* Generated by the target (your application)
		* Can include any custom attributes required by application
		* Cookie name must be specified individually for each target group
		* Don't use `AWSALB`, `AWSALBAPP` or `AWSALBTG` (reserved for use by ELB)
	* Application cookie
		* Generated by load balancer
		* Cookie name is `AWSALB`
* Duration based cookie
	* Cookie generated by the load balancer
	* Cookie name is
		* `AWSALB` for ALB
		* `AWSELB` for CLB
------
# Cross zone load balancing
* With cross zone load balancing, all requests evently distributed to all instances across AZs under different load balancers
* Without cross zone load balancer, requests are distributed in the instances of node of the ELB
![picture](imgs/001-cross-zone-load-balancer.jpg)
* Application load balancer
	* Enabled by default (Can be disabled at target group level)
	* No charges for inter AZ data
* Network load balancer and Gateway load balancer
	* Disabled by default
	* Pay charges for inter AZ data if Enabled
* Classic load balancer
	* Disabled by default
	* No charges for inter AZ data
------
# SSL & TLS
## Basics
* SSL refers to `Secure Sockets Layer`. Used to encrypt connections
* TLS refers to `Transport Layer Security`. Newer version of SSL
* Nowadays, TLS certificates are mainly used, but people still refer as `SSL`
* SSL certificates allows traffic between your client and load balancer to be encrypted during transit (in-flight encryption)
* Public SSL certificates are issued by `Certificated Authorities (CA)`. Some CAs are Comodo, Symantec, GoDaddy, GlobalSign, DigiCert, Letsencrypt etc
* SSL certificates have an expiration date (you set) and must be renewed
* Request comes from client to load balancer via `HTTPS` (because it is SSL certificate, encrypted, secure). Internally load balancer does `SSL termination` and in backend it talks to EC2 instance using `HTTP` (not encrypted). Traffic goes over private VPC which is secure
![picture](imgs/ssl-and-load-balancer.jpg)
* Load balancer uses `X.509` certificate (SSL/TLS server Certificate)
* you can manage certificates using `ACM` (AWS Certificate Manager)
* You can create upload own certificates alternatively
* `HTTPS` listener
	* You must specify default certificate
	* Can add optional list of certs to support multiple domains
	* Clients can use SNI (Server Name Indication) to specify hostname they reach
	* Ability to specify security policy to support old version of SSL/TLS (legacy clients)

## SNI - Server Name Indication
* SNI solves the problem of loading multuple SSL certifacates onto one web server (to server multiple websites)
* It is newer protocol and requires client to `indicate the hostname` of targer server in the initial SSL handshake. Server will then find the correct certifacate or return default one
* Only works for ALB, NLB (newer generation), CloudFront
* Does not work for CLB (older gen)\
![picture](imgs/001-sni.jpg)

## Elastic Load Balancers and SSL certificates
![picture](imgs/001-elb-ssl.jpg)
------
# Connection Draining
![picture](imgs/001-connection-draining.jpg)