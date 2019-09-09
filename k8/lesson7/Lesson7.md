# Service

## What is a service?

```kubectl get pods ```

How do u access a service?
Access from outside or inside. Service helps to give access to pods.
Services are a Rest Object. Is a abstraction
Client -> Service -> RepicaSet -> Pods

Service = IP + Port + DNS  , These NEVER change
DNS =  the service name

Pods are unreliable, always changing.
Everytime u make a SERVICE , you are also making a EndPoint object.
EndPoint to every pod.

Service is tied to the pods via labels

How to discovery Service?
via DNS based or Enviroment Variables

```kubectl expose rc hello-rc --name=hello-svc --target-port=8080 --type=NodePort```


```
kubectl describe svc hello-svc
Name:                     hello-svc
Namespace:                default
Labels:                   app=hello-world
                          version=v1
                          zone=dev
Annotations:              <none>
Selector:                 app=hello-world
Type:                     NodePort
IP:                       10.99.220.178
Port:                     <unset>  8080/TCP
TargetPort:               8080/TCP
NodePort:                 <unset>  30167/TCP
Endpoints:                172.17.0.4:8080,172.17.0.5:8080,172.17.0.6:8080 + 1 more...
Session Affinity:         None
External Traffic Policy:  Cluster
Events:                   <none>
```


If your service has a nodeport, you can access it from the host like:

```curl http://$(minikube ip):$NODEPORT```


### Getting access to the nodes
```minikube ssh```

```alias k=kubectl```

```k exec -it hello-rc-5tt82 -- sh```

Once inside the docker image, 

```netstat  -nltp ```
    
what is ??

```minikube service hello-svc```

### Hot edit

 ```KUBE_EDITOR="nano" kubectl edit svc/docker-registry```


### Commmands

 https://github.com/fabric8io/kansible/tree/master/vendor/k8s.io/kubernetes/docs/user-guide/kubectl



 ```k apply -f  deployment.yml  --record```

```k rollout history deployment hello-deploy```

```k rollout undo deployment hello-deploy --to-revision=1```

``` k rollout status deployment hello-deploy```

### Get Linked to the folder.
``` minikube mount /home/manpreet/mounter:/logs ```



