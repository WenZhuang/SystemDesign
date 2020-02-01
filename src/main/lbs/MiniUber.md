# Mini Uber
实现一个迷你优步
1. 司机提供他们的位置
2. 用户请求，然后返回一个匹配的司机

实现下列函数
- report(driver_id, lat, lng)
    - 如果没有找到匹配的trip，返回null
    - 否则返回匹配trip信息
- request(rider_id, lat, lng)
    1. 建立一个trip
    2. 找到一个最近的司机，标记这个司机为不可用
    3. 将司机id填入trip
    4. 返回trip
    
Java中trip的定义

```java
public class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
}
```

https://www.lintcode.com/problem/mini-uber/
