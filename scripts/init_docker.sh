# 9042 on host
docker run --name cassandra-1 -p 9042:9042 -d cassandra
INSTANCE1=$(docker inspect --format="{{ .NetworkSettings.IPAddress }}" cassandra-1)
echo "INSTANCE1: ${INSTANCE1}"

sleep 60

# 9043 on host
docker run --name cassandra-2 -p 9043:9042 -d -e CASSANDRA_SEEDS=$INSTANCE1 cassandra
INSTANCE2=$(docker inspect --format="{{ .NetworkSettings.IPAddress }}" cassandra-2)
echo "INSTANCE2: ${INSTANCE2}"

sleep 60

# 9044 on host
docker run --name cassandra-3 -p 9044:9042 -d -e CASSANDRA_SEEDS=$INSTANCE1,$INSTANCE2 cassandra
INSTANCE3=$(docker inspect --format="{{ .NetworkSettings.IPAddress }}" cassandra-3)
echo "INSTANCE3: ${INSTANCE3}"