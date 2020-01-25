# 短网址系统设计

给出一个长网址，返回一个短网址。

你需要实现两个方法：
- longToShort(url) 把一个长网址转换成一个以http://tiny.url/开头的短网址
- shortToLong(url) 把一个短网址转换成一个长网址

你可以任意设计算法，评测只关心两件事：
1. 短网址的key的长度应该等于6 （不算域名和反斜杠）。 
2. 可以使用的字符只有 [a-zA-Z0-9]. 比如: abcD9E
任意两个长的url不会对应成同一个短url，反之亦然。

http://www.lintcode.com/problem/tiny-url/description
