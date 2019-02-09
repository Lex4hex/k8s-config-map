#!/usr/bin/env bash

kubectl delete -f ../deployments
kubectl create -f ../deployments/5-secrets-volume.yaml