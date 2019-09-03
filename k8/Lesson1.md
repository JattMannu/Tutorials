## Masters
Cluster control plane. Does not do any user load. Only manage the cluster

### apiserver
kube-apiserver  inputs are deployment's yaml files.
Only component we can interact with. port 443
No other component expose any way to commuincate.

kubectl -> command.json -> apiserver -> nodes

### cluster store
cluster store = etcd, What is etcd? It is a Open Source Distributed key-value database. Should be backup regularly.

### Controller
Many types, NodeController , EndPointContoller , Namespace Controller....

### Scheduler
Watches for a new pods and assign them to workers.

## Nodes / Minions
Does the actual work and reports back to masters

### Kublet
main K8 agent on the node. Watches apiserver and also inilize the pods
Only reports states back to master. 

Expose port 10255 on node, allow  /spec /healthz /pods 

### Container Runtime
Docker's api

### Proxy
Network brains, Each pod gets its own IP

## Deployment
This is a yaml file, What the cluster should look like.

## Pod
Container must be inside a pod.
Scale is always increase or decrease pods only.
a pod can only be on a node. a pod cannot be shared across 2 nodes.

## Declarative Model and Delcative model
Manifest file is declare , and the K8 try to make that.
Manifest is describe what we want, k8 will find its own way to do that.

Desire State vs Actual State

## Services 
Hides the IPs of the pods,so that when ip of the pods changes it manages it.
Provides a stable IP and DNS Name. 
Higer level abstraction.

Only send traffic to healty pods

## Labels
Everything on k8 can get labels
 




