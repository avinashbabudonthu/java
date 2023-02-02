# Installations
* AWS CLI. Check version `aws --version`
* AWS SAM CLI. Check version `sam --version`
* Java
* IntelliJ

# First Lambda Function
* Create new project using sam command. Select appropriate options during project creation
```
sam init
```
* Import created project to IntelliJ or any IDE
* Check main class `App` extends `com.amazonaws.services.lambda.runtime.RequestHandler`