# Create resource group
* To use azure in terraform we need to copy `use provider` script in tf file
* Go link - https://registry.terraform.io/providers/hashicorp/azurerm/latest
* Click `USE PROVIDER` button
* Copy script and paste to tf file
* Refer - [create-resource-group.tf](create-resource-group.tf)

# Execute
* terraform init
* terraform plan -out main.tfplan
* terraform apply