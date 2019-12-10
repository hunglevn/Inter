1. Update properties in kafka.config
2. Run these commands:
	sudo docker build  --tag=kafka .
	sudo docker run --name kafka -d kafka --env-file ./kafka.config