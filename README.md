# spring-rmi-compress
Java spring rmi with compression
refer to question http://stackoverflow.com/questions/2374374/java-rmi-ssl-compression-impossible

This project is a demo of use gzip to compress the java rmi with spring.

The reason we need such compression is rmi send to much characters via net.
One of our client-server program need 6s to open a tab with 1Ms/s bandwith which is not acceptable.

Since rmi use the name of classes which is mostly text, we believe compression will dramatically reduce the size of network cost.

In this demo we use compression class found in
http://javatechniques.com/blog/compressing-data-sent-over-a-socket/

It basiclly buffer the charaters to be sent, compress and then send via socket.

The block size can be change, larger size of block increase the compression rate but need more memory.
After compression, we achieve arount 90% compression rate(which means now the data is only 1/10 of orginal).
The tab is now opened very fast.
