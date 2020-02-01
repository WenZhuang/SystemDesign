实现一个速率限制器，提供一个方法:is_ratelimited(timestamp、event、rate、increment)。

- timestamp:当前时间戳，它是一个整数，单位为秒。
- event:不同事件的字符串。 例如“登录”或“注册”。
- rate:限额的比率。 1/s（每秒1次），2/m（每分钟2次），10/h（每小时10次），100/d（每天100次）。 格式为[integer]/[S/M/H/D]。
- increment:我们是否应该增加计数器。 （或将此请求视为给定事件的命中）
该方法应返回true或false以指示事件是否受限。

注意：登陆次数里不包含登陆失败的情况。

https://www.lintcode.com/problem/rate-limiter/