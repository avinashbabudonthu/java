### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring Security Important classes

* org.springframework.boot.autoconfigure.security.SecurityProperties
    * Configuration properties for Spring Security
* org.springframework.security.web.access.intercept.AuthorizationFilter
* org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter
------
* GenericFilter
* org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter extends GenericFilter
* org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter
* AuthorizationFilter extends GenericFilterBean
------
* UserDetails (I)
* User (c) extends UserDetails
* MutableUserDetails (I) extends UserDetails
* MutableUser (c) implements MutableUserDetails
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)