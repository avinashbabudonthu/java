# Materials
* Udemy - Serverless using AWS Lambda for Java Developers
* Udemy - AWS Lambda - A Practical Guide
* Udemy - Master AWS Lambda: Go Serverless with AWS
* Others - https://github.com/in28minutes/go-serverless
* Documentation - https://docs.aws.amazon.com/lambda/latest/dg/welcome.html
------
# Installations
* AWS CLI. Check version `aws --version`
* AWS SAM CLI. Check version `sam --version`
* Java
* IntelliJ
------
# First Lambda Function
* Create new project using sam command. Select appropriate options during project creation
```
sam init
```
* Import created project to IntelliJ or any IDE
* Check main class `App` extends `com.amazonaws.services.lambda.runtime.RequestHandler`