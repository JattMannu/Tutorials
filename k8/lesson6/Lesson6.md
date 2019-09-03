Each pod 1 IP all container same IP means they can commnicate via localhost and same file system.


## How to deploy a POD?

### Lifecycle
1. you define the pod in a yaml or json file 
2. Send the file to the apiserver
3. Pod goes into a PENDING state, While it download and fire, Stay here until fully done
4. Running State
5. Finished worked -> SUCCEEDED 

Once dead it cannot come back


## Demo

kubectl get nodes
NAME       STATUS   ROLES    AGE   VERSION
minikube   Ready    <none>   17m   v1.15.3

### pod.yml
apiVersion: v1
kind: Pod
metadata:
    name: hello-pod
spec:
    cont



### Commands

http://www.snowcrash.eu/kubectl-create-pod/

https://kubernetes.io/docs/reference/kubectl/cheatsheet/


#### Create POD
```
kubectl create -f pod.yml
```

#### Delete POD
```
kubectl delete pod hello-pod
```

#### Select pods
```
kubectl get pods
```

#### Update
```
kubectl apply -f pod.yml
```

#### Describe 
```
kubectl describe pod hello-pod
```

#### Jump To k8 docker repo , to use local repo

```
eval $(minikube docker-env)
```
The command minikube docker-env returns a set of Bash environment variable exports to 
configure your local environment to re-use the Docker daemon inside the Minikube instance.

Passing this output through eval causes bash to evaluate these exports and put them into effect.

You can review the specific commands which will be executed in your shell by 
omitting the evaluation step and running minikube docker-env directly. 
However, this will not perform the configuration – the output needs to be evaluated for that.


#### Print logs 
```
kubectl logs hello-pod
```


#### Get all system pods and user pods

```
kubectl get pods --all-namespaces
```


#### Look for open ports
docker run --rm -it instrumentisto/nmap 192.168.99.100

nmap 192.168.99.*

ip addr show VS ifconfig



#### All Resources

```
kubectl api-resources
```


#### View cron jobs
```
kubectl get cronjobs
```