### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Add userid to the docker users group in Windows
* Run this command from an administrator command window to add your user id to the docker-users group and log back into your user account for it to take effect
```
net localgroup docker-users "your-user-id" /ADD
```
* `your-user-id` is your local Windows user name. You can determine this by looking at the folder name under `C:\Users\`
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)