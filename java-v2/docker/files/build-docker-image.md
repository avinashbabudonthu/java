### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Building Docker Images
* In the previous post we discussed how to create a Dockerfile. The next step of the process is to build a Docker image using the Dockerfile.
* A Docker image is like a compiled file. It's built in layers, starting with the base layer that contains the fundamental setup. This is usually the layer we use the FROM directive. Each subsequent layer adds on top of the previous one, making small adjustments or additions. These layers are stacked on top of another, and each layer builds up the changes made in the layer before it.
* Once a Docker image is created, all its layers become read-only. However, when you start a Docker container from this image, Docker adds a new layer on top of them. This new layer is where any changes or updates made during the container's operation are stored. It acts like a thin, writable layer that captures all the modifications made to the container's filesystem.
* In essence, the Docker image provides a blueprint for creating a consistent environment, while the container allows you to work within that environment and make changes as needed, without affecting the original image.
* This image build process is initialized by the Docker CLI and executed by the Docker daemon. To generate a Docker image, the Docker daemon needs access to the Dockerfile, any source code, and files referenced inside that Dockerfile. These files are stored in a directory known as the build context. This context directory needs to be specified while executing the docker image build command.
* The docker image build command takes the following format:
```
docker image build <context>
```
* If we want to specify the current directory as the context, we can use the dot (.) as a directory:
```
docker image build .
```
* Let's create a simple Dockerfile to demonstrate the Docker image build process:
```
FROM ubuntu:latest
LABEL maintainer="ananalogguyinadigitalworld@example.com"
CMD ["echo", "Hello World"]
```
* This Dockerfile does the following. It begins with the FROM command, specifying that the image should be built on top of the latest version of Ubuntu available from the Docker Hub repository. This base image serves as the starting point for our custom image.
* The LABEL command is used to provide metadata about the image. In this case, it assigns the maintainer label, indicating who maintains or is responsible for this particular image. The email address provided (ananalogguyinadigitalworld@example.com) is used as the contact information.
* Lastly, the CMD command sets the default command to be executed when a container is started from this image. Here, it specifies that when a container starts, it should execute the command echo "Hello World". This command simply prints "Hello World" to the standard output of the container.
* Navigate to the directory where you created your Dockerfile, and use the following command:
```
docker image build .
```
* You will see an output similar to the following:
```
[+] Building 3.5s (6/6) FINISHED                                                                         docker:default
 => [internal] load build definition from Dockerfile                                                               0.0s
 => => transferring dockerfile: 143B                                                                               0.0s
 => [internal] load .dockerignore                                                                                  0.0s
 => => transferring context: 2B                                                                                    0.0s
 => [internal] load metadata for docker.io/library/ubuntu:latest                                                   3.4s
 => [auth] library/ubuntu:pull token for registry-1.docker.io                                                      0.0s
 => CACHED [1/1] FROM docker.io/library/ubuntu:latest@sha256:2e863c44b718727c860746568e1d54afd13b2fa71b160f5cd905  0.0s
 => => resolve docker.io/library/ubuntu:latest@sha256:2e863c44b718727c860746568e1d54afd13b2fa71b160f5cd9058fc4362  0.0s
 => exporting to image                                                                                             0.0s
 => => exporting layers                                                                                            0.0s
 => => writing image sha256:f14484d3185f92d2d7896904300502be4f3c6d0df4ebba61b127d630d74b6f0d                       0.0s
```
* Now, let's visit the locally available Docker images with the docker image list command:
```
docker image list
```
* The command should return the following output:
```
REPOSITORY                                      TAG       IMAGE ID       CREATED       SIZE
<none>                                          <none>    f14484d3185f   11 days ago   78.1MB
```
* Note that there was no name for our custom Docker image. This was because we did not specify any repository or tag during the build process. We can tag an existing image with the docker image tag command.
* Let's tag our image with IMAGE ID f14484d3185f as my-tagged-image:v1.0:
```
docker image tag f14484d3185f my-tagged-image:v1.0
```
* Now, if we list our images again, we can see the Docker image name and the tag under the REPOSITORY and TAG columns:
```
REPOSITORY                                      TAG       IMAGE ID       CREATED       SIZE
my-tagged-image                                 v1.0      f14484d3185f   11 days ago   78.1MB
```
* We can also tag an image during the build process by specifying the -t flag:
```
docker image build -t my-tagged-image:v2.0 .
```
* The preceding command will print the following output:
```
[+] Building 5.8s (6/6) FINISHED                                                                         docker:default
 => [internal] load .dockerignore                                                                                  0.0s
 => => transferring context: 2B                                                                                    0.0s
 => [internal] load build definition from Dockerfile                                                               0.0s
 => => transferring dockerfile: 143B                                                                               0.0s
 => [internal] load metadata for docker.io/library/ubuntu:latest                                                   5.6s
 => [auth] library/ubuntu:pull token for registry-1.docker.io                                                      0.0s
 => CACHED [1/1] FROM docker.io/library/ubuntu:latest@sha256:2e863c44b718727c860746568e1d54afd13b2fa71b160f5cd905  0.0s
 => => resolve docker.io/library/ubuntu:latest@sha256:2e863c44b718727c860746568e1d54afd13b2fa71b160f5cd9058fc4362  0.0s
 => exporting to image                                                                                             0.0s
 => => exporting layers                                                                                            0.0s
 => => writing image sha256:f14484d3185f92d2d7896904300502be4f3c6d0df4ebba61b127d630d74b6f0d                       0.0s
 => => naming to docker.io/library/my-tagged-image:v2.0                                                            0.0s
```
* This time, in addition to the writing image sha256:f14484d3185f92d2d7896904300502be4f3c6d0df4ebba61b127d630d74b6f0d line, we can see a naming to docker.io/library/my-tagged-image:v2.0 line, which indicates the tagging on our Docker image.
* Summary - In this post, we discussed how to build a Docker image from a Dockerfile. We also discussed the difference between a Dockerfile and a Docker image. Then, we discussed how a Docker image is made up of multiple layers. Finally, we tagged the Docker images.
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)