
I. Introduction:
	1. Develop a very simple Spring Boot App. Name this app as "InterApp". 
		1.1. This "InterApp" is configured with these services:
			a. MySQL (Running on Docker container).
			b. Listen on a Kafka queue.
			c. Elastic search.
		1.2. "InterApp" works as below:
			a. Provide a REST API for sending "feeding back" message. Name this as "FeedingBack" API.
			b. Provide a REST API for managing "feeding back" messages. These API are secured and need to authenticate when calling.
			c. "FeedingBack" API put message to Kafka topic. Use "FeedingBackTopic" as name of Kafka topic
			d. Kafka consumer read messages from "FeedingBackTopic" Kafka topic and write content to MySQL DB.
			e. Provide a REST API for searching stored messages. Name this as "Searching" API
	2. Create Docker image for running "InterApp".
	3. Start two containers of "InterApp" docker Image. These two containers listen on 8080 and 8081 ports.
	4. Configure "Nginx" as a proxy server to pass request to two instances of InterApp (8080 and 8081 ports) 
	5. Create Docker image for "Nginx" proxy server. Run instance of "Nginx" proxy server, listen on port#80
	
II. Checkout source of "Inter" project.
	git clone https://github.com/hunglevn/Inter.git

III. Deploy services:
	1. Deploy two instances of "InterApp" on Docker containers:
		a. Package and run application:
			mvn package && java -jar target/Inter-0.0.1.jar
		b. Build docker image:
			sudo docker build --build-arg JAR_FILE=target/Inter-0.0.1.jar --tag=interapp .
		c. Running two instances of "inter" app on two docker and listens on two ports 8080, 8081
			sudo docker run --name=InterApp1 -p 8080:8080 -d interapp
			sudo docker run --name=InterApp2 -p 8081:8080 -d interapp
	2. Deploy "Nginx" proxy server as Docker container:
		a. Follow steps in "/Nginx/README.md" to build/deploy "Nginx" proxy server as Docker container.
		b. check if Nginx proxy server is up and running:
			+ http://192.168.14.93/app1
			+ http://192.168.14.93/app2
			
IV. Inter API:
	1. Send feedback message:
		curl -i -X GET http://localhost:8080/api/feedback/send?message=hello
	2. Authentication:
		curl -i -X POST http://localhost:8080/login -d username=kevin -d password=123456 -c D:/Temp/cookies.txt
	2. Search messages:
		curl -i -X GET http://localhost:8080/api/admin/feedback/search?keyword=hello -b D:/Temp/cookies.txt
