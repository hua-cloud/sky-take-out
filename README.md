# sky-take-out


![Author](https://img.shields.io/badge/Author-hua-red.svg "Author")
![hexo](https://img.shields.io/badge/Java-1.8+-blue.svg)
![hexo](https://img.shields.io/badge/Maven-3.8.5-yellow.svg)
![hexo](https://img.shields.io/badge/Spring_Boot-2.7.3-green.svg)



## 项目介绍
`sky-take-out`项目是一套为商家定制的点餐外卖系统，包括前台商城系统及后台管理系统，基于SpringBoot+MyBatis实现，采用Docker容器化部署。前台商城系统包含首页门户、
商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块。后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、
财务管理、权限管理、设置等模块。
## 环境搭建
### 开发工具

| 工具            | 说明           | 官网                                                    |
|---------------|--------------|-------------------------------------------------------|
| IDEA          | 开发IDE        | https://www.jetbrains.com/idea/download               |
| RedisDesktop  | redis客户端连接工具 | https://github.com/qishibo/AnotherRedisDesktopManager |                          |
| Knife4J       | API接口调试工具    | https://www.postman.com/                              |
| Notion        | Markdown编辑器  | https://typora.io/                                    |

### 开发环境

| 工具            | 版本号    | 下载                                                                                   |
|---------------|--------|--------------------------------------------------------------------------------------|
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                                               |
| Redis         | 5.0    | https://redis.io/download                                                            |
| MongoDB       | 4.2.5  | https://www.mongodb.com/download-center                                              |
| RabbitMQ      | 3.7.14 | http://www.rabbitmq.com/download.html                                                |
| Nginx         | 1.10   | http://nginx.org/en/download.html                                                    |                                     |
## 技术选型
### 后端技术
| 技术                   | 说明            | 官网                                             |
|----------------------|---------------|------------------------------------------------|
| SpringBoot           | 容器+MVC框架      | https://spring.io/projects/spring-boot         |
| SpringSecurity       | 认证和授权框架       | https://spring.io/projects/spring-security     |
| MyBatis              | ORM框架         | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | 持久层代码生成       | http://www.mybatis.org/generator/index.html    |
| Elasticsearch        | 搜索引擎          | https://github.com/elastic/elasticsearch       |
| RabbitMQ             | 消息队列          | https://www.rabbitmq.com/                      |
| Redis                | 分布式缓存         | https://redis.io/                              |            |
| Kibana               | 日志可视化查看工具     | https://github.com/elastic/kibana              |
| Nginx                | 静态资源服务器       | https://www.nginx.com/                         |
| Docker               | 应用容器引擎        | https://www.docker.com                         |
| Jenkins              | 自动化部署工具       | https://github.com/jenkinsci/jenkins           |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid               |
| OSS                  | 对象存储          | https://github.com/aliyun/aliyun-oss-java-sdk  |
| MinIO                | 对象存储          | https://github.com/minio/minio                 |
| JWT                  | JWT登录支持       | https://github.com/jwtk/jjwt                   |
| Lombok               | 简化对象封装工具      | https://github.com/rzwitserloot/lombok         |
| Hutool               | Java工具类库      | https://github.com/looly/hutool                |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI           | 文档生成工具        | https://github.com/swagger-api/swagger-ui      |                 |
### 前端技术

| 技术         | 说明             | 官网                                     |
|------------|----------------|----------------------------------------|
| Vue        | 前端框架           | https://vuejs.org/                     |
| Vue-router | 路由框架           | https://router.vuejs.org/              |
| Vuex       | 全局状态管理框架       | https://vuex.vuejs.org/                |
| Element    | 前端UI框架         | https://element.eleme.io               |
| Axios      | 前端HTTP框架       | https://github.com/axios/axios         |
### 系统架构图
### 模块介绍
## 开发进度


## 1.[SQL文件](https://github.com/hua-cloud/sky-take-out/blob/master/sky-server/src/main/resources/sql/sky.sql)

## 2.[数据库设计文档](https://github.com/hua-cloud/sky-take-out/blob/master/sky-server/src/main/resources/sql/%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3.md)

## 3.已完成的功能