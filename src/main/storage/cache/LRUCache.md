# LRUCache

为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据和写入数据。

- get(key) 获取数据：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
- set(key, value) 写入数据：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。

最终, 你需要返回每次 get 的数据.

https://www.lintcode.com/problem/lru-cache/description