sudo docker build --build-arg CONF_FILE=nginx.conf --tag=nginx .
docker run --name nginx -p 80:80 -d nginx