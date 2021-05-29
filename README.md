# READ ME

## 《Java Web 高级》课程实验

### shop项目简介

repo：https://github.com/Monster-c/shop

期末java web大作业，由于之前的经验积累，故对于SpringMVC上手较快，代码量不大，主要是锻炼一下工程能力，现将代码整理到该仓库中。

### 技术栈：

`Spring + SpringMVC + MyBatis`,后续计划通过Vue改写前端页面并通过`webpack`转编译

### shop 目前已实现功能：

- 后台(`/admin`)对商品的增删改查
- 支持查看商品库存
- 支持添加商品图片描述
- 支持添加商城公告
- 支持查找客户订单
- 支持商城客户端页面展示（访问地址`/before`)
- 支持用户注册
- 支持查看商品详情页面
- 支持商品下单购买

### 运行方式

启动Tomcat运行项目`/target/shop.war`包（将war包置于`/Tomcat/webapps/`即可，会自动解压），访问`localhost/8080/admin(后台管理)`或`localhost/8080/before(客户端界面)`。

### TO DO:

- 对异常处理界面进行优化
- 目前前端页面仅采用jsp实现，希望后续基于Vue进行重新编写（😁希望后面还有时间）
- ps:最近考试忒多了，什么时候能把模型搞完啊

如果有任何问题，欢迎和我取得联系:)

```
xianweicao@outlook.com
```

