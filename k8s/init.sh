#!/usr/bin/env bash
cd ../

./mvnw clean install
./mvnw dockerfile:build

cd k8s

kubectl delete -f configmaps
kubectl create -f configmaps

kubectl delete -f network
kubectl create -f network

kubectl delete -f deployments