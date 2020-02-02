实现下列几个方法：
1. get(curtTime, key). 得到key的值，如果不存在返回2147483647
2. set(curtTime, key, value, ttl). 设置一个pair(key,value)，有效期从curtTime到curtTime + ttl -1 , 如果ttl为0，则一直存在
3. delete(curtTime, key). 删除这个key
4. incr(curtTime, key, delta). 给key的value加上delta，并且返回 如果不存在返回 2147483647。
5. decr(curtTime, key, delta). 给key的value减去delta，并且返回 如果不存在返回 2147483647。

https://www.lintcode.com/problem/memcache
