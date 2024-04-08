

```
docker compose -f debezium.yml up -d


# SSH inside postgres container
docker exec -it debezium-postgres-1 /bin/sh
# connect to DB:
psql -U docker -d exampledb
# password if asked: docker

create table student (id int, name varchar(256));
alter table student replica identity full;

# in another terminal open the folder containing debezium-config.json and run the follwing curl
# it tells the debezium to read the config file and create a connect based on the config
curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" localhost:8083/connectors --data "@debezium-config.json"
# now the connector is created

# now go to schema-registry and listen to messages to the changes in the table
docker exec -it debezium-schema-registry-1 bash

kafka-avro-console-consumer \
  --topic postgres.public.student \
  --bootstrap-server kafka:9092 \
  --property schema.registry.url=http://localhost:8081


# open postgres's terminal and insert, update some rows
insert into student values(1, 'akshit');
insert into student values(2, 'sachin');

update student set name='deepak' where id = 2;


# check schema-registry terminal, you must be getting the changes

```

    

