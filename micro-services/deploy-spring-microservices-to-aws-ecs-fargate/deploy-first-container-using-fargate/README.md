# Deploy First Container usign Fargate

## Steps
* Search for `ECS` service
* If we are running first time click on `Get started` button
* Create Container and Task
	* In the `Container definition` select `sample-app`
	* In the `Task definition`
		* click Edit button
		* Give `Task definition name` as `sample-app-task-definition` (giving container name in task definition is good idea)
		* Keep others as default
		* click `Save` button
* click `Next`
* Service
	* If we are running multiple instances then create load balancer. As this is sample-app we are running 1 instance, so load balancer is not needed
	* click `Next` button
* Cluster
	* Give any generic cluster name. Same cluster we can use for multiple deployments
	* Keep others as default
	* click `Next` button
* Review
	* Review all sections
* click `Create` button
* This will take some time. Go get a coffee meanwhile..
* click `View service` button
* Go to `Tasks` tab
* click link in `Task` column. We can see the details like status etc in this screen
* copy `Public IP` and paste in another tab
* Sample app output is as follows\
![picture](pictures/sample-app-output.jpg)