0. Checkout source:
	git clone https://github.com/hunglevn/Inter.git
1. Package and run application:
	mvn package && java -jar target/Inter-0.0.1.jar
2. Build docker image:
	sudo docker build --build-arg JAR_FILE=target/Inter-0.0.1.jar --tag=interapp .
3. Running two instances of "inter" app on two docker and listens on two ports 8080, 8081
		sudo docker run --name=InterApp1 -p 8080:8080 -d interapp
		sudo docker run --name=InterApp2 -p 8081:8080 -d interapp
	
