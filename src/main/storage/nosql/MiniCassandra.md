# Cassandra
Cassandra是一个NoSQL数据库。Cassandra中的一个单独数据条目由3部分构成：

1. row_key 用于哈希，不支持范围查询。我们将其简化为字符串。
2. column_key 已排序并支持范围查询。我们将其简化为整数。
3. value 是一个字符串。你可以将任何数据序列化为字符串并将其存储在值中。

现在要实现下面两个方法：
- insert(row_key, column_key, value)
- query(row_key, column_start, column_end) 返回条目列表

http://www.lintcode.com/problem/mini-cassandra/description