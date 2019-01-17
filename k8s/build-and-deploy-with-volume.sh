#!/usr/bin/env bash

cd ../
mvn clean install
mvn dockerfile:build

cd k8s
kubectl delete configmap configmap-test-app-config-map
kubectl create configmap configmap-test-app-config-map --from-file hrdt.application.properties
kubectl delete deployment -n default configmap-test-app
kubectl create -f deployment-with-volume.yaml