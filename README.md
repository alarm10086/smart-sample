# Smart Sample

## 运行环境

1. JDK 1.6+
2. MySQL 5.5+
3. Tomcat 7.0+

## 使用方法

1. 打开 src/main/resources/smart.properties 文件，修改数据库连接信息
2. 在 MySQL 中创建数据库，并执行 doc/sample.sql 脚本，初始化表结构及其数据
3. 修改 Tomcat 的 server.xml 文件，添加 URIEncoding="UTF-8" 配置，使 GET 请求中可带有中文字符
4. 使用 Maven 将 smart-sample 应用打包为 war 文件，并部署到 Tomcat 中，也可在 IDE 中部署并运行
5. 使用该 URL 访问应用：http://[host]:[port]/smart-sample/，用户名/密码：admin/admin

--

Smart Sample for Eclipse

导入 Eclipse，可直接运行！

[http://git.oschina.net/coxapp/smart-sample](http://git.oschina.net/coxapp/smart-sample)