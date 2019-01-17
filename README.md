## Spring Cloud Kubernetes configuration management test project
   
There are two cases of property source configuration: 
 - Using automatic ConfigMap discovery through k8s API and name provided in bootstap.yaml (default Spring profile) 
 - Using ConfigMap volume mount (volume-config-profile Spring profile) 
 
 Each of these configurations use `deployment.yaml` (`build-and-deploy.sh`) and `deployment-with-volume.yaml` 
 (`build-and-deploy-with-volume.sh`) respectively 

### Automatic build and run
- Run script  
```build-and-deploy.sh``` or  
`build-and-deploy-with-volume.sh`

### Manual build and run
- Build project with Maven:  
`mvn clean install`
- Build a Dockerfile:  
`dockerfile:build`
- Create a ConfigMap:  
`k create configmap configmap-test-app-config-map --from-file application.properties`
- Deploy:  
`k create -f deployment.yaml`

Now you can edit ConfigMap and see changes in application's log:  
`k edit configmap configmap-test-app-config-map`