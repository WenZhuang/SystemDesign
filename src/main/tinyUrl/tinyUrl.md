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

# 短网址系统设计II
实现一个顾客短网址，使得顾客可以创立他们自己的短网址. 也就是说, 你需要在 232. 短网址 的基础上再实现一个 createCustom.

你需要实现三个方法：

- longToShort(url) 把一个长网址转换成一个以http://tiny.url/开头的短网址
- shortToLong(url) 把一个短网址转换成一个长网址
- createCustom(url, key) 设定一个长网址的短网址为 http://tiny.url/ + key

你可以任意设计算法，评测只关心：
1. longToShort 生成的短网址的key的长度应该等于6 （不算域名和反斜杠）。 可以使用的字符只有 [a-zA-Z0-9]. 比如: abcD9E
2. 任意两个长的url不会对应成同一个短url，反之亦然。
3. 如果 createCustom 不能完成用户期望的设定, 那么应该返回 "error", 反之如果成功将长网址与短网址对应, 应该返回这个短网址.
