#!/usr/bin/env bash
cd ../

mvn clean install
mvn dockerfile:build

cd k8s

kubectl delete -f configmaps
kubectl create -f configmaps

kubectl delete -f network
kubectl create -f network