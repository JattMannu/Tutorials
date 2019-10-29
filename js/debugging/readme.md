node inspect simple.js

Start chrome and go to URL : chrome://inspect

You should see ur simple.js and we can inspect it




Command-line options
The following table lists the impact of various runtime flags on debugging:

Flag	Meaning
--inspect	
Enable inspector agent
Listen on default address and port (127.0.0.1:9229)
--inspect=[host:port]	
Enable inspector agent
Bind to address or hostname host (default: 127.0.0.1)
Listen on port port (default: 9229)
--inspect-brk	
Enable inspector agent
Listen on default address and port (127.0.0.1:9229)
Break before user code starts
--inspect-brk=[host:port]	
Enable inspector agent
Bind to address or hostname host (default: 127.0.0.1)
Listen on port port (default: 9229)
Break before user code starts
node inspect script.js	
Spawn child process to run user's script under --inspect flag; and use main process to run CLI debugger.
node inspect --port=xxxx script.js	
Spawn child process to run user's script under --inspect flag; and use main process to run CLI debugger.
Listen on port port (default: 9229)








Enabling remote debugging scenarios
We recommend that you never have the debugger listen on a public IP address. If you need to allow remote debugging connections we recommend the use of ssh tunnels instead. We provide the following example for illustrative purposes only. Please understand the security risk of allowing remote access to a privileged service before proceeding.

Let's say you are running Node on remote machine, remote.example.com, that you want to be able to debug. On that machine, you should start the node process with the inspector listening only to localhost (the default).

node --inspect server.js
Now, on your local machine from where you want to initiate a debug client connection, you can setup an ssh tunnel:

ssh -L 9221:localhost:9229 user@remote.example.com
This starts a ssh tunnel session where a connection to port 9221 on your local machine will be forwarded to port 9229 on remote.example.com. You can now attach a debugger such as Chrome DevTools or Visual Studio Code to localhost:9221, which should be able to debug as if the Node.js application was running locally.

