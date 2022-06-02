# GCP Deployment Steps

* Login to GCP
* Open Cloud shell
* See if our repo already pulled to cloud shell
```
ls
```
* Pull latest changes if repo already present. cd to repo folder
```
git pull
```
* Clone repo
```
git clone <repo-url>
```
* cd to repo folder
* Package
```
mvn clean compile package
```
* build docker image
```
docker build . -t gcr.io/<project-id>/pub-sub-publisher
```
* check docker images
```
docker images
```
* push docker image to GCR - Google container registry
```
docker push gcr.io/<project-id>/pub-sub-publisher:latest
```
* Create kubernetes cluster
```
gcloud container clusters create "cluster-1" --scopes "https://www.googleapis.com/auth/cloud-platform" --num-nodes "1" --zone "us-central1-b" --project "<project-id>"
```
* Deploy
```
kubectl create deployment pub-sub-publisher --image=gcr.io/<project-id>/pub-sub-publisher:latest
```
* To view the deployment that you created, simply run the following command
```
kubectl get deployments
```
* To view the app instances created by the deployment, run the following command
```
kubectl get pods
```
* In Cloud Shell, you can expose the Pod to the public internet by creating a Kubernetes LoadBalancer service
```
kubectl create service loadbalancer pub-sub-publisher --tcp=8080:8080
```
* To find the publicly accessible IP address of the service, simply request `kubectl` to list all the cluster services
```
kubectl get services
```
* Following command to delete cluster
```
gcloud container clusters delete cluster-1 --zone=us-central1-b --project "<project-id>"
```
* Delete the image from GCR
```
gcloud -q container images delete gcr.io/<project-id>/pub-sub-publisher:latest
```
* Delete the created VM
```
gcloud -q compute instances delete proverb-vm --zone asia-east1-a
```
* Delete the firewall rule
```
gcloud -q compute firewall-rules delete allow-http
```