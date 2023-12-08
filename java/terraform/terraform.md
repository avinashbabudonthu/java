# Materials
* Udemy - Learn DevOps: Infrastructure Automation With Terraform
* Udemy - Terraform on Azure
------
# Notes
* Terraform HCL by HCL - HashiCorp Configuration Language
------
# Windows Installation
* Go to https://www.terraform.io/
* Click Download button
* Download terraform as per OS and version
* Windows
	* Downloads zip file with terraform.exe
	* Unzip it
* Add exe file path with file name to sysem PATH
* Open cmd
* Execute below command
```
terraform -version
```
------
# Commands
* Initialize
```
terraform init
```
* Check version
```
terraform -version
```
* Plan
```
$ terraform plan
```
* shortcut for plan & apply - avoid this in production
```
$ terraform apply
```
* terraform plan and write the plan to out file
```
$ terraform plan -out out.terraform
```
* apply terraform plan using out file
```
$ terraform apply out.terraform
```
* show current state
```
$ terraform show
```
* show state in JSON format
```
$ cat terraform.tfstate
```

------
