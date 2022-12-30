# Terraform commands
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