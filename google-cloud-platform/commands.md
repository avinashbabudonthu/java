# Gshell commands
* List of available commands
```
gcloud -h
gcloud --help
```
* Create project
```
gcloud projects create [PROJECT_ID]
```
* set project
```
gcloud config set project <project-id>
```
* See the list of regions
```
gcloud compute regions list
```
* See the list compute instances
```
gcloud compute instances list
```
* Connect to GCE VM instance via SSH
```
gcloud compute ssh <instance-name> --zone <zone-name>

gcloud compute ssh instance-1 --zone asia-south1-a
```
* Update the packages in linux VM
```
sudo apt-get update
```
* Install apache2
```
sudo apt-get install -y apache2
```
* Start apache2
```
sudo systemctl start apache2
```
* Login to GCP using Google cloud SDK shell
```
gcloud auth login
```
* Delete GKE cluster
```
gcloud container clusters delete <cluster-name> --zone=us-central1-b --project "<project-id>"
```
* Delete the image from GCR
```
gcloud -q container images delete gcr.io/<project-id>/<image-name>:latest
```
* Create pub sub topic
```
gcloud pubsub topics create <topic-name>
gcloud pubsub topics create cron-topic
```
* Create pub/sub subscription
```
gcloud pubsub subscriptions create <subscription-name> --topic <topic-name>
gcloud pubsub subscriptions create cron-sub --topic cron-topic
```
* Pull messages from pub/sub subscription
```
gcloud pubsub subscriptions pull <subscription-name> --limit <number-of-messages>
gcloud pubsub subscriptions pull cron-sub --limit 5
```