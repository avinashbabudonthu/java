# Dependency Inversion Notes
* When implementing application usually we start with low level software components such as classes, interfaces, methods and so on then we implement high level modules that rely on low level modules
* High level modules should not depend on low level modules. Both should be depend on abstractions
* Abstractions should not depend on details. Details (concrete implementation) should depend on abstractions