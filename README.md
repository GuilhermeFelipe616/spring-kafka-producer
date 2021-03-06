# spring-kafka-producer

A simple application showing how to publish JSON messages to kafka with Spring Boot.

### Requirements
- Java 11;
- Docker and Docker Compose;

### Docker

The project uses **docker-compose** to set up **zookeeper** and **kafka**.

### Running the project

#### Setting up the environment

1) Clone the project;
2) Open a bash window inside the project root folder;
3) Run ``docker-compose up`` command;
4) Start the spring application;

#### Publishing messages

Messages can be published by requesting the REST API like below:

```
[POST] http://localhost:8085/kafka-example/producers
Content-Type: application/json
Body: { "message": "Test message" }
```

The topic should be created automatically, but in case it doesn't, execute the command below:
```shell script
docker-compose exec kafka  kafka-topics --create --topic kafka-producer-example --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:32181
```

#### Consuming a Kafka Topic

To consult the published messages, execute the command below:
```shell script
docker-compose exec kafka kafka-console-consumer --bootstrap-server kafka:29092 --topic kafka-producer-example --from-beginning
```
