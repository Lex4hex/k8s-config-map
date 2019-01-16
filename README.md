## Spring Cloud Kubernetes configuration management test project
Little project to test spring-cloud-kubernetes-config. 

### Build and run
- Build project with Maven:  
```mvn clean install```
- Build a Dockerfile:  
```dockerfile:build```
- Create a ConfigMap:  
```k create configmap configmap-test-app-config-map --from-file application.properties```
- Deploy:  
```k create -f deployment.yaml```

Now you can edit ConfigMap and see changes in application's log:  
```k edit configmap configmap-test-app-config-map```