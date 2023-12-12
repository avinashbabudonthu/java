terraform {
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "3.83.0"
    }
  }
}

# azure configurations
provider "azurerm" {
  subscription_id = "xxxxxxxxxxx"
  tenant_id = "xxxxxxxxxxx"
  client_id = "xxxxxxxxxxx"
  client_secret = "xxxxxxxxxxx"
  features {}
}

resource "azurerm_resource_group" "myRg001" {
  name = "001-my-rg"
  location = "southindia"
}