# Install Kubectl in windows using scoop
* Install using scoop: scoop install kubectl
* [Refer documentation](https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl-on-windows)
* Check version: kubectl version

# Install Kubectl in windows using chocolatey
* Install chocolatey. Refer cerebro for steps
* choco install minikube
* choco install kubernetes-cli
* If you have previously installed minikube, and run: minikube start
* And this command returns an error: machine does not exist
* You need to clear minikube’s local state: minikube delete
* [Installation documentation](https://kubernetes.io/docs/tasks/tools/install-minikube/)

# Certifications on Kubernetes
* Certified Kubernetes Application Developer
* Certifications Kubernetes Administrator

# Container Orchestration
* What if one container depend on other containers
* Platform orchestrate the connectivity between the containers and automatically scale up/down based on the load
* Process of automatically deploying and managing containers is called `container orchestration`
* container orchestration tools
	* Docker swarm by Docker
	* Kubernetes by Google
	* Mesos from apache

# Kubernetes architecture
* Node
	* physical or virtual machine where kubernetes is installed
	* worker machine that is where containers will be launched by kubernetes
	* Also called `Minion` previously
* Cluster
	* Set of nodes grouped together
* Master
	* Manages cluster
	* Maintains information about the cluster nodes
	* Monitors nodes
	* Move the load of failed node to another worker node
	* Master is another node where kubernetes installed in it and is configured as a master
	* Master watches the nodes in cluster and responsibile for orchestration of containers on worker nodes
* When installing kubernetes on system, we are installing following components:
	* API servers
	* etcd service
	* kubelet service
	* container runtime
	* controller
	* schedulers
* API servers act as front end for kubernetes
* etcd
	* distributed reliable key-value store by kubernetes to store all data used to manage the cluster
	* responsibile for implementing locks within the cluster to ensure that there are not conflicts between the masters
* schedulers
	* responsibile for distributing work or containers across multiple nodes
* controller
	* brain behind orchestration
	* takes decisions to bring up new containers when any containers goes down
	* container runtime is underlying software that is used to run containers
* kubelet
	* agent that runs on each node in the cluster
	* responsibile for making sure containers are running on the node as expected
* kubectl
	* tool used to deploy and manage applications on kubernetes cluster