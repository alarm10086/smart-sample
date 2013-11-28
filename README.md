Smart Sample

运行环境

1. JDK 1.6
2. MySQL 5.5
3. Tomcat 7.0

使用方法

1. 打开 src/main/resources/config.properties 文件，配置数据库相关信息。
2. 在 MySQL 中创建数据库。
3. 执行 doc/sample.sql 脚本。
4. 将 smart-sample 应用部署到 Tomcat 中（可在 IDE 中部署或独立部署）。
5. 访问应用：http://[host]:[port]/smart-sample/

Smart 依赖包

1. Smart Framework:         http://git.oschina.net/huangyong/smart-framework
2. Smart Cache Plugin:      http://git.oschina.net/huangyong/smart-plugin-cache
3. Smart WebService Plugin: http://git.oschina.net/huangyong/smart-plugin-ws
3. Smart I18N Plugin:       http://git.oschina.net/huangyong/smart-plugin-i18n

请自行下载以上 Smart 依赖包源码，使用 Maven 命令“mvn install”将这些依赖包安装到 Maven 本地仓库中。

----------------------------------------------------------------------------------------------------

Smart Sample for Eclipse

导入 Eclipse，可直接运行！

[http://git.oschina.net/coxapp/smart-sample](http://git.oschina.net/coxapp/smart-sample)