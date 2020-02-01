# 发布/订阅模式
发布/订阅模式是系统设计中广泛使用的模式。 在此问题中，您需要实现发布/订阅模式以支持特定频道上的用户订阅，并从订阅的频道获取通知消息。

您需要实现3种方法：

- subscribe（channel，user_id）：将给定用户订阅到给定频道。
- unsubscribe（channel，user_id）：取消订阅给定用户的给定用户。
- publish（channel，message）：您需要将消息发布到频道，以便在频道上订阅的每个人都会收到此消息。 调用PushNotification.notify（user_id，message）将消息推送给用户。