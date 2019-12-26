sudo docker container stop nginx
sudo docker container rm nginx
sudo docker image rm nginx
sudo docker build --build-arg CONF_FILE=nginx.conf --tag=nginx .
sudo docker run --name nginx -p 80:80 -d nginx