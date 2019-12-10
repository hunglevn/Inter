1. Update properties in kafka.config
2. Run these commands:
	sudo docker build  --tag=kafka .
	sudo docker run --env-file ./kafka.config --name kafka -d kafka 