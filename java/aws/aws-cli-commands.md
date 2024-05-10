# AWS CLI Commands
* Check aws cli version
```
aws --version
```
* set AWS access key id
```
set AWS_ACCESS_KEY_ID=[accessKey]
```
* set aws secret access key
```
set AWS_SECRET_ACCESS_KEY=[secretAccessKey]
```
* set aws default region
```
set AWS_DEFAULT_REGION=[region]
```
* List users
```
aws iam list-users
```
* Configure aws cli. Run below command which asks for AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY, AWS_DEFAULT_REGION, Default output format
```
aws configure
```
* Upload file from aws cli
```
aws s3 cp c:/my-folder/myfile.txt s3://mybucket/myfile.txt
```
* check bucket contents
```
aws s3 ls s3://mybucket
```