## Spring Cloud Kubernetes configuration management test project
   
In this repository you will find four cases of using Kubernetes and Spring Cloud Kubernetes Config to configure 
Spring Boot application:
 - Using environment property
 - Mounting application.properties into default Spring discovered location
 - Mounting *.properties file and using Spring Kubernetes to specify it's location 
 - Using `@ConfigurationProperty` classes with Spring Kubernetes Config reload 

### Automatic build and run
- You need to have Kubernetes cluster installed and running
- You need to install Ingress  Nginx controller https://kubernetes.github.io/ingress-nginx/deploy/
- Run an init script. It builds project and creates network and ConfigMap Kubernetes objects  
`./k8s/init.sh`
- Run a shell script for required configuration located in  
`k8s/deployment_scripts`

### Test configuration
Now you can test deployed configuration by making a GET request  
`curl localhost/get-properties`
