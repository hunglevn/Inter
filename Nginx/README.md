1. Update IP addresses in "nginx.conf" as your environment.
2. Build docker image and start container:
	a. sudo docker build --build-arg CONF_FILE=nginx.conf --tag=nginx .
	b. docker run --name nginx -p 80:80 -d nginx
3. check if Nginx proxy server is up and running:
	a. http://192.168.14.93/app1
	a. http://192.168.14.93/app2
	