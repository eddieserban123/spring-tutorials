a simple spring app that keeps sessions in redis

some problems with docker-compose: 
 if i boot up spring app and redis node in the same docker network somehow spring cannot connect to redis
so i leave it only the redis in the docker compose 

redis-cli -h localhost -p 6379 

KEYS *
HGETALL <>

pay attention to tests too !



