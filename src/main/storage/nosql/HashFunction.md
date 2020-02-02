# 哈希函数
在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。一个好的哈希函数可以尽可能少地产生冲突。一种广泛使用的哈希函数算法是使用数值33，假设任何字符串都是基于33的一个大整数，比如：
```
hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d)) % HASH_SIZE 
                 = (97* 33^3 + 98 * 33^2 + 99 * 33 +100) % HASH_SIZE
                 = 3595978 % HASH_SIZE
```

其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。

给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值。

https://www.lintcode.com/problem/hash-function/description

## 两个小技巧
    
1. 如何计算 a * 33^3 + b * 33^2 + c * 33 + d:
    1. sum = a
    2. sum = a * 33 + b
    3. sum = (a * 33 + b) * 33 + c
    4. sum = (a * 33^2 + b * 33 + c) * 33 + d
    5. sum = sum * 33 + char

2. 取模运算法则：
    1. (a + b) % p = (a % p + b % p) % p
    2. (a - b) % p = (a % p - b % p) % p
    3. (a * b) % p = (a % p * b % p) % p
    4. a ^ b % p = ((a % p)^b) % p