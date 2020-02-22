# Google Suggestion
使用map reduce 框架查找输入中的所有前缀及其所属单词和出现次数。
- mapper的key为单词, value 为单词出现的次数，文档中的内容由空格分割
- reducer应该所有的前缀，每个前缀包含最多为10个的key-value对（单词以及对应出现的次数）。
如果小于10个则输出全部结果，大于10个则输出字典序前10个结果

https://www.lintcode.com/problem/google-suggestion-map-reduce/