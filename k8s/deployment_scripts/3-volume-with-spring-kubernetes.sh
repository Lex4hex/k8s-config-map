#!/usr/bin/env bash

kubectl delete -f ../deployments
kubectl create -f ../deployments/3-volume-with-spring-kubernetes.yaml