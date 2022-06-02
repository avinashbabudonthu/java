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
docker build . -t gcr.io/<project-id>/spanner-poller-converter-publisher
```
* check docker images
```
docker images
```
* push docker image to GCR - Google container registry
```
docker push gcr.io/<project-id>/spanner-poller-converter-publisher:latest
```
* Create kubernetes cluster
```
gcloud container clusters create "cluster-1" --scopes "https://www.googleapis.com/auth/cloud-platform" --num-nodes "1" --zone "us-central1-b" --project "<project-id>"
```
* Deploy and run our container
```
kubectl run spanner-poller-converter-publisher --image=gcr.io/<project-id>/spanner-poller-converter-publisher:latest --port 9000 --labels="app=spanner-poller-converter-publisher"
```
* Navigate to 
    * Kubernetes Engine
    * Workloads
    * our application
    * we can our application logs in `Logs` tab
* Following command to delete cluster
```
gcloud container clusters delete cluster-1 --zone=us-central1-b --project "<project-id>"
```