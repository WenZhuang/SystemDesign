# GFS Client

为GFS(Google文件系统)实现一个简单的客户端，提供一下功能：
1. read(文件名)，通过文件名从GFS中读取文件。
2. write(文件名，内容)，通过文件名和内容写入GFS中。

现在有两种已经在基础类中实现的方法：
1. readChunk(文件名，块索引)，从GFS中读取一个块。
2. writeChunk(文件名，块索引，块数据)，向GFS中写入一个块。

为了简化这个问题，我们可以假设块大小为 chunkSize 位的(在真实的文件系统中，是64M)，GFS客户端的任务是将一个文件分为若干块(如果需要的话)并且保存在远端的GFS服务器上，chunkSize会在构造函数中给出，你需要的是实现read和write这两个private方法。

https://www.lintcode.com/problem/gfs-client/description

# Heart Beat

在Master-Slave结构模式中，slave端会每隔k秒向master端发送ping请求表示自己还在运行。如果master端在 2 * k 秒内没有接收到任何来自slave的ping请求，那么master端会向管理员发送一个警告(比如发送一个电子邮件)。

现在让我们来模拟master端，你需要实现以下三个功能：
1. initialize(slaves_ip_list, k)，slaves_ip_list是所有slaves的ip地址列表，k为一个定值。
2. ping(timestamp, slave_ip)，这个方法在master端从slave端收到ping请求时执行，timestamp指当前的时间戳，slave_ip代表当前发送请求的slave端的ip地址
3. getDiedSlaves(timestamp)，这个方法会定期的(两次执行之间的时间间隔不确定)执行，timestamp代表当前的时间戳，此方法需要返回不再运行的slave端的所有ip地址列表，如果没有发现则返回空集合。

你可以假设当master端开始运行的时候时间戳为0，所有的方法都会根据全局的增长的时间戳来运行。

https://www.lintcode.com/problem/heart-beat/description