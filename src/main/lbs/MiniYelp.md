设计一个小的Yelp系统支持下列操作
1. 添加一个新餐馆的名字和地址
2. 去除一个餐馆
3. 在给定地点找一个临近的餐馆, 临近餐馆是指距离小于 k km

Restaurant类已近建立好了并且有Restaurant.create() 和Helper.get_distance(location1, location2)两个函数可以使用.

GeoHash类也已经提供了GeoHash.encode(location)和GeoHash.decode(string)可以帮助转换地址