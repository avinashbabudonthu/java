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
  subscription_id = "3deb56dc-759b-48fc-99e4-236f7b158829"
  tenant_id = "c9711627-cc03-474b-849c-c90908abcd26"
  client_id = "e61e576d-0c96-4204-8090-856eaf6c65c2"
  client_secret = "y218Q~KetdbAPAfwv_Ok_MT5h7FRTEvbPnROka7p"
  features {}
}

resource "azurerm_resource_group" "myRg001" {
  name = "001-my-rg"
  location = "South India"
}