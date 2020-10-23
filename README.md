# exchange-rate

#### create registry
```
docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

#### download base image 
```
docker pull openjdk:8u252-slim 
docker tag openjdk:8u252-slim localhost:5000/openjdk:8u252-slim 
docker push localhost:5000/openjdk:8u252-slim 
docker image remove openjdk:8u252-slim 
docker image remove localhost:5000/openjdk:8u252-slim
``` 

### build image
```
mvn compile jib:build
```

### run container
```
docker run -p 8001:8001 localhost:5000/bcp-exchange-rate-v2:2.0
```

### APIs
```
curl --location --request GET 'localhost:8002/api/exchange-rate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fromCurrencyType":"PEN",
    "toCurrencyType":"USD",
    "amount":234
}'
```
```
curl --location --request POST 'localhost:8002/api/exchange-rate/update' \
--header 'Content-Type: application/json' \
--data-raw '{    
    "fromCurrencyType":"PEN",
    "toCurrencyType":"USD",
    "price":3.49
}'
```
