# Materials
* Youtube - https://www.youtube.com/watch?v=tDuruX7XSac&ab_channel=edureka%21
* Youtube - https://www.youtube.com/watch?v=0bNFkI_0jhc&ab_channel=Intellipaat
* Youtube - https://www.youtube.com/watch?v=TQl9sN3qs3M&ab_channel=Intellipaat
* Udemy - Microsoft Azure: From Zero to Hero - The Complete Guide
------
# Cloud Compare
* [Cloud Compare](../aws/images/compare-cloud.pdf)
------
# Notes
* what is cloud? In simple terms - Storage, Computing, Networking, other services managed by third parties. We simply use
* using azure cli
* using azure cli powershell
* SLA (Service Level Agreement) 
	* calculator - https://uptime.is/
	* SLA - means anaul up time of any service
* pricing models: always check resource cost before provisioning
* per resource (ex: VM)
* per consumption (ex: Function Apps)
* reservations
* azure calculator - https://azure.microsoft.com/en-au/pricing/calculator/
* Management Groups -> Subscriptions -> Resource Groups -> Resources
* Virtual Machines
* App Services
* AKS
* Azure Functions
------
# Services
* Refer - https://azure.microsoft.com/en-in/products
------
# Cloud Shell
* Allows command line interface to run commands against azure
* Azure CLI - Create new resource group
```
az group create -l [region] -n [resource-group-name]
az group create -l southindia -n 001-rg
```
* Power Shell - Create new resource group
```
New-AzResourceGroup -Name 003-my-rg -Locaion southindia
```
------
# Naming Conventions
* ARM Template - Azure Resource Management Template