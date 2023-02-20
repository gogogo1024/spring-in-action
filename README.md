# spring in action 6th

### cassandra  docker script

1. docker create cassandra
    - `docker network create cassandra-net`
    - ``docker run --name my-cassandra \
      --network cassandra-net \
      -p 9042:9042 \
      -d cassandra:latest``
2. start the CQL(Cassandra Query Language)) shell using Docker
    - ``docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra
      ``
3. execute the shell
    - ``create keyspace tacocloud``
    - `with replication={'class':'SimpleStrategy', 'replication_factor':1}`
    - ``and durable_writes=true;``