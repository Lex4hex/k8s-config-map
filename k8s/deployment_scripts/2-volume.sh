#!/usr/bin/env bash

kubectl delete -f ../deployments
kubectl create -f ../deployments/2-volume.yaml