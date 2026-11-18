# Day 2：HTTP 参数绑定与构造器注入

**用时：3 小时。目标：在你已经跑通的 `mall-demo` 中，手敲内存版品牌接口，从 HTTP 请求一路走到 Service，再返回 JSON。** 今天继续使用现有项目和 8082 端口；不新建 Maven 模块，不增加依赖，不连数据库。原来的 `/hello` 保留，作为排查时的对照。

核心知识：Controller 怎样把请求参数交给 Service。支撑知识：三个参数绑定注解、构造器注入、JSON 与 Java 对象转换、内存数据生命周期。

## 要建什么

下面的 Java 文件都放在练习项目的 `mall-demo/src/main/java/com/macro/mall/` 下。沿用你已有的包结构，使这些类可以被 `com.macro.mall.MallDemoApplication` 扫描。

| 文件 | 职责 |
|---|---|
| `model/Brand.java` | 保存并返回 `id`（Long）和 `name`（String） |
| `dto/CreateBrandRequest.java` | 接收新增请求，只有 `name`；ID 交给服务端分配 |
| `service/BrandService.java` | 声明列表查询、按 ID 查询、新增三个操作 |
| `service/impl/BrandServiceImpl.java` | 作为 Spring Bean；管理内存集合、按名称筛选、查 ID 和分配 ID。自己选 List 或 Map，先保证串行操作正确 |
| `controller/BrandController.java` | 定义 HTTP 方法和路径，绑定参数；通过构造器注入 `BrandService`，把数据操作交给它 |
| `doc/Day2-学习记录.md` | 项目根目录下的学习记录，保存请求结果、实验和报错 |

今天用 `@RestController` 巩固 Day 1 的响应体知识；不要为了让接口跑通在 Controller 里手动 `new BrandServiceImpl()`。如果用普通 Java 类做请求 DTO，可用无参构造器和 getter/setter，先排除对象反序列化的额外问题。

## 接口契约

| 请求 | 输入来自哪里 | 验收结果 |
|---|---|---|
| `GET /brand/listAll` | 可选查询参数 `keyword`；用 `@RequestParam` 绑定 | 200，返回 JSON 数组；不传时显示全部，传入时按名称包含关系筛选；无匹配返回空数组 |
| `GET /brand/{id}` | 路径上的数字 ID；用 `@PathVariable` 绑定 | 存在时返回 200 和品牌对象；数字 ID 不存在时返回 404 |
| `POST /brand/create` | JSON 请求体，如 `{"name":"Day2 品牌"}`；用 `@RequestBody` 绑定 | 本练习约定返回 200 和带新 ID 的品牌对象；随后可用两个 GET 接口查到 |

今天先返回对象或数组，复杂校验和统一异常响应放到 Day 5。区分两种失败：`/brand/abc` 匹配到带 ID 的路由后无法转换为 Long，预期 400；合法数字但没有该品牌，按契约返回 404。

## 按顺序手敲，每步运行一次

1. **15 分钟｜回顾 Day 1。** 启动自己的应用，确认 `/hello` 仍返回 200。分别请求同一端口的 `/not-a-route` 和确认没有服务监听的端口。记录哪条收到 HTTP 状态、哪条没有。连接失败先查监听，收到 404 再查路由。
2. **35 分钟｜写模型和 Service。** 新建 `Brand`、`BrandService` 和实现类。先让 Service 返回两条可区分的种子数据，例如 `Alpha` 和 `Beta`；先留出新增操作，别一次把所有逻辑做完。用 `mvn -pl mall-demo -am compile` 验证编译。
3. **40 分钟｜写列表接口，再加查询参数。** 新建 Controller，通过构造器接收 `BrandService`。先跑通不带参数的 GET，再加 `keyword` 过滤。验收：全部、只匹配一条、无匹配三种请求均得到预期结果。
4. **25 分钟｜按 ID 查询。** 加 `GET /brand/{id}`。分别测存在的 ID、未使用的数字 ID 和 `abc`。验收：能解释 200、404 和 400 分别在哪一步产生。
5. **45 分钟｜写新增接口。** 新建请求 DTO，补齐 Service 的新增实现和 Controller 的 POST。先发合法 JSON，再发一个语法损坏的 JSON。验收：合法请求返回新 ID，随后能查到；非法 JSON 返回 400，列表没有多出品牌。重启应用后，验证刚新增的记录消失、种子数据恢复。
6. **20 分钟｜记录与复述。** 保存关键请求和实际响应，记下碰到的第一个报错、如何定位以及改动。合上参考代码，复述一次新增链路：请求体 → DTO → Service → 内存集合 → 响应 JSON。

若超时，优先做通 **列表 → 新增 → 查回**，再补筛选和故障实验。不要开始接 MyBatis。

## 可用的验证请求

先在 IDE 启动自己的 `MallDemoApplication`，再按进度执行：

```bash
curl -i 'http://localhost:8082/brand/listAll'
curl -i 'http://localhost:8082/brand/listAll?keyword=Alpha'
curl -i -X POST 'http://localhost:8082/brand/create' \
  -H 'Content-Type: application/json' \
  -d '{"name":"Day2 品牌"}'
# 把下面的 3 换成 POST 实际返回的 ID
curl -i 'http://localhost:8082/brand/3'
curl -i 'http://localhost:8082/brand/abc'
curl -i -X POST 'http://localhost:8082/brand/create' \
  -H 'Content-Type: application/json' \
  -d '{"name":'
```

如果启动时提示找不到 `BrandService`，先核对实现类是否标为 Spring 组件、是否位于启动类的扫描范围内。若请求失败，先用 `/hello` 确定你打到的是正确服务，再看 HTTP 方法、路径、Content-Type 和请求体。

## 参考代码怎么读

- [DemoController.java：列表和新增](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/demo/controller/DemoController.java:31)：看 Controller 怎样把请求交给 Service。
- [DemoController.java：查询参数和路径参数](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/demo/controller/DemoController.java:84)：原项目这里做分页，今天只借鉴参数绑定。
- [DemoService.java](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/demo/service/DemoService.java:11) 和 [DemoServiceImpl.java](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/demo/service/impl/DemoServiceImpl.java:19)：看接口与实现的分工。原实现依赖 `PmsBrandMapper`、PageHelper 和生成模型；今天用内存集合替代，Mapper 留给 Day 3。

## 完成后怎么检验

把练习工程路径或提交链接、一次成功新增及查回的结果、至少一次失败响应发给我。你负责手敲，卡住时我先给定位提示。收到实现后，我会从你的参数绑定、构造器和实际报错中出两轮题：首轮约 8 道开放题，第二轮追问错点，再将原答案、标准回答和动手实验结论归档。
