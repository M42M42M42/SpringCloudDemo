### 端口号：
- Nacos Server (8848)

- cloud-provider (8081)

- cloud-consumer (8082)

- cloud-gateway (9000)

### 控制台地址：
- Nacos:  http://localhost:8848/nacos
- Sentinel:  http://localhost:8858

### 链路流程：
- 你的请求 (9000) -> 网关拦截判断 -> 转发给 cloud-consumer (8082) -> Consumer 通过 Feign 发现并调用 cloud-provider (8081)

### 运行步骤：
1. Docker 启动 Nacos：
```bash
docker compose up -d
```

2. Nacos 控制台 添加配置：**cloud-provider-dev.yml**
```yaml
user:
  info: "test_user_001"  # 可验证配置热更新
```
3. 手动启动三个微服务（provider、consumer、gateway）
4. 打开浏览器，访问网关的地址：
   http://localhost:9000/consumer/call