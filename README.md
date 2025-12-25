# CSITS Backend - 校园二手商品交易平台

基于 Spring Boot 3.2.5 开发的校园二手商品交易平台后端系统，提供完整的用户管理、商品管理、订单处理和支付功能。

## 项目概述

CSITS Backend 是一个功能完整的电商平台后端服务，专为校园二手商品交易场景设计。系统支持多角色（买家、卖家、管理员）协作，提供从商品发布、浏览、下单到支付的完整交易流程。

## 技术栈

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA** - ORM 框架
- **Spring Security** - 安全认证
- **PostgreSQL** - 关系型数据库
- **Argon2** - 密码哈希加密
- **Lombok** - 代码简化工具
- **Maven** - 项目构建管理

## 核心功能

### 用户系统
- 用户注册与登录认证
- 买家/卖家双重角色支持
- 用户信息管理（真实姓名、学号、联系方式等）
- 用户评分系统

### 管理员系统
- 独立的管理员认证体系
- 管理员账户管理
- 系统管理功能

### 商品管理
- 商品发布、编辑、删除
- 商品分类管理（商品类型）
- 商品状态跟踪
- 商品图片上传
- 新旧程度标记

### 订单系统
- 订单创建与管理
- 买家/卖家订单查询
- 订单状态流转
- 订单编号生成

### 支付系统
- 支付记录管理
- 多种支付方式支持
- 用户支付历史查询

## 项目结构

```
CSITSbackend/
├── src/main/java/com/trallkong/csitsbackend/
│   ├── controller/          # REST API 控制器
│   │   ├── UserController.java
│   │   ├── AdminController.java
│   │   ├── GoodsController.java
│   │   ├── OrderController.java
│   │   ├── PaymentController.java
│   │   ├── GtypeController.java
│   │   └── GstateController.java
│   ├── service/             # 业务逻辑层
│   │   ├── UserService.java
│   │   ├── AdminService.java
│   │   ├── GoodsService.java
│   │   ├── OrderService.java
│   │   ├── PaymentService.java
│   │   ├── GtypeService.java
│   │   └── GstateService.java
│   ├── repository/          # 数据访问层
│   │   ├── UserRepository.java
│   │   ├── AdminRepository.java
│   │   ├── GoodsRepository.java
│   │   ├── OrderRepository.java
│   │   ├── PaymentRepository.java
│   │   ├── GtypeRepository.java
│   │   └── GstateRepository.java
│   ├── entity/              # 数据实体模型
│   │   ├── BaseEntity.java
│   │   ├── User.java
│   │   ├── Admin.java
│   │   ├── Goods.java
│   │   ├── Order.java
│   │   ├── Payment.java
│   │   ├── Gtype.java
│   │   ├── Gstate.java
│   │   └── ErrorResponse.java
│   ├── security/            # 安全配置
│   │   ├── Security.java
│   │   └── CryptoUtils.java
│   └── debug/               # 调试工具
│       └── GlobalExceptionHandler.java
└── src/main/resources/
    ├── application.properties
    └── application-dev.properties
```

## 数据模型

### 核心实体

#### User（用户）
- userId - 用户 ID
- username - 用户名
- passwordHash - 密码哈希
- realname - 真实姓名
- phone - 手机号
- schoolId - 学号
- address - 地址
- rating - 用户评分
- idCardHash - 身份证哈希

#### Goods（商品）
- gid - 商品 ID
- gname - 商品名称
- gtypeId - 商品类型
- don - 新旧程度
- price - 价格
- imagePath - 图片路径
- sellerId - 卖家 ID

#### Order（订单）
- orderId - 订单 ID
- buyerId - 买家 ID
- sellerId - 卖家 ID
- gid - 商品 ID
- state - 订单状态
- amount - 订单金额
- orderNo - 订单编号

#### Payment（支付）
- paymentId - 支付 ID
- orderId - 订单 ID
- amount - 支付金额
- userId - 用户 ID
- payMethod - 支付方式

## API 接口

### 用户接口
- `POST /user/{username}/{passwordHash}` - 用户登录

### 管理员接口
- `POST /admin/login/{username}/{passwordHash}` - 管理员登录

### 商品接口
- `GET /goods/{id}` - 获取商品详情
- `POST /goods` - 创建商品
- `PUT /goods/{id}` - 更新商品
- `DELETE /goods/{id}` - 删除商品

### 商品类型接口
- `GET /gtype/{id}` - 获取商品类型
- `GET /gtype/{name}` - 按名称获取商品类型
- `POST /gtype` - 创建商品类型

### 商品状态接口
- `GET /gstate/{id}` - 获取商品状态
- `POST /gstate` - 创建商品状态
- `PUT /gstate/{id}` - 更新商品状态
- `DELETE /gstate/{id}` - 删除商品状态

### 订单接口
- `GET /orders/{buyerId}` - 获取买家订单列表
- `GET /orders/{sellerId}` - 获取卖家订单列表
- `GET /orders/{id}` - 获取订单详情
- `POST /orders` - 创建订单
- `PUT /orders/{id}` - 更新订单
- `DELETE /orders/{id}` - 删除订单

### 支付接口
- `GET /payment/{userId}` - 获取用户支付记录

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- PostgreSQL 12+

### 数据库配置

1. 创建 PostgreSQL 数据库：
```sql
CREATE DATABASE CSITS;
```

2. 修改 `src/main/resources/application-dev.properties` 配置文件：
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/CSITS
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 运行项目

1. 克隆项目：
```bash
git clone <repository-url>
cd CSITSbackend
```

2. 使用 Maven 构建：
```bash
./mvnw clean install
```

3. 运行应用：
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

应用将在 `http://localhost:8080` 启动。

## 安全特性

- **密码加密**：使用 Argon2id 算法进行密码哈希，符合现代安全标准
- **身份认证**：Spring Security + HTTP Basic Auth
- **敏感数据保护**：身份证号等敏感信息使用哈希存储
- **异常处理**：全局异常处理机制，统一错误响应格式

## 配置说明

### 开发环境配置（application-dev.properties）
- 数据库连接配置
- Hibernate DDL 策略：update（自动创建/更新表结构）
- SQL 日志输出：启用
- 服务端口：8080

### 生产环境配置（application.properties）
- 应用名称：CSITSbackend
- 其他生产环境专用配置

## 开发计划

- [ ] 实现图片上传功能
- [ ] 添加商品搜索功能
- [ ] 实现消息通知系统
- [ ] 集成第三方支付接口
- [ ] 添加数据统计分析功能
- [ ] 完善单元测试和集成测试

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进项目。

## 许可证

本项目采用 MIT 许可证。

## 联系方式

如有问题或建议，请通过 Issue 与我们联系。
