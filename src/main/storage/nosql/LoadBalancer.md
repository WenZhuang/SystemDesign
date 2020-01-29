为网站实现一个负载均衡器，提供如下的 3 个功能：

1. 添加一台新的服务器到整个集群中 => add(server_id)。
2. 从集群中删除一个服务器 => remove(server_id)。
3. 在集群中随机（等概率）选择一个有效的服务器 => pick()。

最开始时，集群中一台服务器都没有。每次 pick() 调用你需要在集群中随机返回一个 server_id。

https://www.lintcode.com/problem/load-balancer/description