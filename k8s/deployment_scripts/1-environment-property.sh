#!/usr/bin/env bash

kubectl delete -f ../deployments
kubectl create -f ../deployments/1-environment-property.yaml
