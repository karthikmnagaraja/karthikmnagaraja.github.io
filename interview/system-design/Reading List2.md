
###### **Topics**

#### **DNS**

 - Avoid SPOF 
 - Create seperate urls for each region
 - Different Load balancing techinique
 - Monitoring

#### **Load Balancing**
 - L7 Haproxy vs Nginx
 - L3/L4 Envoy/Linkered/Consul/etcd
	 - Service Discovery 
	 - Authentication 
	 - Circuit Breaker 
	 - Retries 
	 - TimeOut Handling 
	 - Rate Limiter 
	 - Http2 handling 
	 - Monitoring 
	 - rpc call support
	 - Autoscaling
   - SPOF
   - Different Load balancing techinique like latency based, geographic location based, round robin, weighted etc


#### **Services**

 - Sync vs Async 
 - Http2 handling 
 - FastBuffer vs Protocol Buffer vs thrift vs avro vs json 
 - RPC calls for internal microservice call  using grpc/finagle/thrift and advantages 
 - Business Logic 
 - HTTP Methods 
 - Http Error codes 429,501,403,401,400
 - Http Success codes 201,200,203 CORS

#### **DataStorage**

 - ACID vs Base
 - SQL vs NoSQL 
 - In Memory Datastore 
 - Consistent Hashing Hybrid Locks vs Global locks  
 - Replication 
	 - Sync Vs Async 
	 - Master-Slave
	 - Master-Master  
	 - Cross DC replication Vitess vs DynomiteDb vs Casandra vs Apache Ignite 
	 - Geo graphical replication
	 - File Storage system or File System
	 - Sharding vs Partioning

#### **Caching**

 - Redis VS Memcache 
 - Replication 
 - Redis protocol and data structure
 - support Caching for files or images

#### **Queue**

 - Kafka 
 - Distributed Ledger / Apache Bookkeeper
 - Pub/Sub Redis

#### **CDN**

Cloud Security
Cloud Flare

#### **Notifications**

 - Push Notification APNS, GNS , twilio 
 - Build Your own notification infrastructure for android and idevices using mqtt

 

#### **Logging Infrastructure**

 - Monitoring the services, db, L7 load balancer, L3/L4 load balancer, dns
 - Distributed Tracing

#### **Service Interruption/Outage**

 - Page Out Oncall Using pager duty or alternative alert manager
 - Determination of problem using logs and monitors for trouble shooting

#### **Consesus**

 - Quorum 
 - Local 
 - Raft vs Paxos 
 - Gossip Protocol

#### **Special Topics**

 - UUID generation using snowflake 64 bits or openflake 128 bits
 - RateLimter service using redis 
 - Hashing i.e, consistent hashing
 - Schemaless RDBMS Architecture using postgress and herb replictor service (Uber) 
 - Write Ahead Logs (Kafka)

#### **Containers**

 - Docker
<<<<<<< HEAD
 - Kubernetes
=======
 - Kubernetes
>>>>>>> origin/master
