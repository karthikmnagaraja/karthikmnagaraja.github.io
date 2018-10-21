

# **Load Balancing**


## **Reverse Proxy**

 What is reverse proxy?
 . A reverse proxy server is a type of proxy server that typically sits behind the firewall in a private network and directs client requests to the appropriate backend server. A reverse proxy provides an additional level of abstraction and control to ensure the smooth flow of network traffic between clients and servers.

**Why Use RP?**

 - Hide Origin Server for Security Purposes.
 - Application Firewall.
 - SSL Termination.
 - Load Balancing.
 - Caching.
 - Compression.

## **NGINX**

*Why NGINX?* 
nginx  as it provides the key features necessary to *conveniently offload concurrency, latency processing, SSL (secure sockets layer), static content, compression and caching, connections and requests throttling,* and even HTTP media streaming from the application layer to a much more efficient edge web server layer. It also allows integrating directly with memcached/Redis or other "NoSQL" solutions, to boost performance when serving a large number of concurrent users.


**NGINX ARCHITECTURE:**
*HIGH LEVEL:*
![High Level](https://www.nginx.com/wp-content/uploads/2015/06/infographic-Inside-NGINX_process-model.png)

*MORE DETAILED:*
![enter image description here](http://www.aosabook.org/images/nginx/architecture.png)

**SSL Termination**: *HTTPS->HTTP->HTTPS*

SSL termination means that Reverse Proxy acts as the server-side SSL endpoint for connections with clients: it performs the decryption of requests and encryption of responses that backend servers would otherwise have to do. The operation is called termination because Reverse Proxy closes the client connection and forwards the client data over a newly created, unencrypted connection to the servers in an upstream group. 
The server certificate is a public entity. It is sent to every client that connects to the NGINX. The private key is a secure entity and should be stored in a file with restricted access. 
*Note that although the certificate and the key are stored in one file in this case, only the certificate is sent to clients.*

*HTTPS Server Optimization*
SSL operations consume extra CPU resources. The most CPU-intensive operation is the SSL handshake. There are two ways to minimize the number of these operations per client:

 - Enabling keepalive connections to send several requests via one connection.
 - Reusing SSL session parameters to avoid SSL handshakes for parallel and subsequent connections

**Load Balancing** 

*The following load balancing mechanisms (or methods) are supported in nginx:*

 - **round-robin** — requests to the application servers are distributed in a round-robin fashion
 - **least-connected** — next request is assigned to the server with the least number of active connections.
 - **ip-hash** — a hash-function is used to determine what server should be selected for the next request (based on the client’s IP address).

**Caching:**
*Caching Basic Principles*
![image](https://www.nginx.com/wp-content/uploads/2016/08/Garrett-Content_Caching-4_Basic-Principles-2-35.jpg)

*How Caching is works?*
![enter image description here](https://www.nginx.com/wp-content/uploads/2016/08/Garrett-Content_Caching-9_Caching-Process-11-14.jpg)

*Benefits of Caching?*

 1. Performance Improvement 
 2. Protecting the  backend server from repetitive requests.

*What is should not be cached?*

 1. HTTP PUT, POST and DELETE request. 
 2. Honor "no-cache", "no-store", "private" 
 3. Set Cookie Header 
 4. TTL(time to live)<=0

**Compression**
Compressing responses often significantly reduces the size of transmitted data. However, since compression happens at runtime it can also add considerable processing overhead which can negatively affect performance. NGINX performs compression before sending responses to clients, but does not “double compress” responses that are already compressed (for example, by a proxied server).
*directive: gzip* 

*Decompression:*
Some clients do not support responses with the gzip encoding method. At the same time, it might be desirable to store compressed data, or compress responses on the fly and store them in the cache. To successfully serve both clients that do and do not accept compressed data, NGINX can decompress data on the fly when sending it to the latter type of client.

*directive: gunzip.*

Source: 

 1. http://nginx.org/en/docs/http/load_balancing.html
 2. https://docs.nginx.com/nginx/admin-guide
 3. https://www.igvita.com/2008/02/11/nginx-and-memcached-a-400-boost/
 4. http://aosabook.org/en/nginx.html

**C10K Problem**:
The C10k problem is the problem of optimising network sockets to handle a large number of clients at the same time.[1] The name C10k is a numeronym for concurrently handling ten thousand connections.[2] Note that concurrent connections are not the same as requests per second, though they are similar: handling many requests per second requires high throughput (processing them quickly), while high number of concurrent connections requires efficient scheduling of connections.

**C10M Problem**:
The C10M problem relates to the classic C10K Internet scalability problem, which originally occurred in the context of Web servers. It consists of successfully supporting 10,000 concurrent connections on a single machine, and while C10K is currently solved by certain Web servers, C10M remains a challenging problem not only for Web servers, but for any Internet server in general.

Orginal Article:http://www.kegel.com/c10k.html#top


Avoid SPOF
http://www.tenereillo.com/GSLBPageOfShame.htm

