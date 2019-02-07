#!/usr/bin/env bash

kubectl delete -f ../deployments
kubectl create -f ../deployments/4-spring-cloud-kubernetes.yaml
