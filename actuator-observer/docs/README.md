More info here https://www.baeldung.com/spring-boot-3-observability

run docker compose up
invoke curl http://localhost:8080/api/process
you should see in http://localhost:9090/ the metrics: 
visit_counter 
myservice

