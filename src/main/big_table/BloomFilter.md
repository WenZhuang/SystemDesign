# 标准型布隆过滤器
实现一个标准型布隆过滤器, 支持一下方法:
1. StandardBloomFilter(k) 构造方法, 你需要创建k个hash方法
2. add(string) 往布隆过滤器中加入一个字符串.
3. contains(string) 检查字符串是否在过滤器中

https://www.lintcode.com/problem/standard-bloom-filter/

# 计数型布隆过滤器
实现一个计数型布隆过滤器, 支持以下方法:
1. add(string). 往布隆过滤器中加入一个字符串.
2. contains(string). 检查一个字符串是否在布隆过滤器中.
3. remove(string). 从布隆计数器中删除一个字符串.

https://www.lintcode.com/problem/counting-bloom-filter/