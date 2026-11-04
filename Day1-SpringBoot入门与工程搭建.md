# Day 1：搭好工程，亲手写出第一个 Spring Boot 接口

适用基础：Java 基础可以，Spring Boot 还不熟。

预计用时：3 小时。Day 1 表示学习进度，不绑定日期；完成验收后再进入 Day 2。

## 一、今天到底要干什么

今天只完成一件事：**从自己的空工程启动一个 Web 服务，访问自己写的 `/hello` 接口，得到 JSON 响应。**

完成后，你应该能回答：Java 的 main 方法怎样启动 Web 服务？HTTP 请求怎样找到 Controller？为什么类放错包会导致接口访问不到？

今天产出：

- 一个父 Maven 工程，两个子模块 `mall-common`、`mall-demo`。
- 一个启动类 `MallDemoApplication`。
- 一份配置文件 `application.yml`。
- 一个 `HelloController`，提供 `GET /hello`。
- 一份 `学习记录.md`，保留运行结果和实验现象。

MyBatis、数据库、Redis、Nacos、Feign、登录、统一返回类都在后续任务中加入。今天保留精简的依赖和配置。

学习方式：你负责手敲。先按任务尝试，卡住时我给提示；参考项目用于对照，不要求逐行照抄。

## 二、工程放哪里，要建哪些文件

保留现在的 `mall-swarm` 作为参考。建议在同级目录手动新建 `mall-swarm-practice`，作为自己的练习工程。本文只列任务，没有替你创建练习工程或写业务代码。

完成后目录应接近下面这样：

```text
mall-swarm-practice/
├── pom.xml
├── mall-common/
│   └── pom.xml
├── mall-demo/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/macro/mall/
│       │   ├── MallDemoApplication.java
│       │   └── demo/controller/
│       │       └── HelloController.java
│       └── resources/
│           └── application.yml
└── 学习记录.md
```

`mall-common` 今天可以只有 pom，是给后面公共代码预留的库模块。`mall-demo` 是今天唯一需要运行的服务。暂时不用创建 Service、Mapper 或测试目录。

## 三、要加入哪些依赖和配置

### 父工程的 pom.xml

亲手配置以下内容，边写边说明每项的用途：

| 项目 | 今天的要求 |
|---|---|
| 工程坐标 | 自己的 groupId、artifactId、version；后续子模块的 parent 与它一致 |
| packaging | `pom` |
| Spring Boot 父依赖 | `org.springframework.boot:spring-boot-starter-parent`；版本沿用参考仓库的 `3.5.14` |
| Java 版本 | `17` |
| modules | 先只声明 `mall-common`、`mall-demo` |

版本沿用本地参考仓库，依赖能否下载以你的实际构建结果为准。今天无需复制原根 pom 的全部 properties、dependencyManagement、Docker 插件和 Cloud 依赖。

### 两个子模块的 pom.xml

| 文件 | 要加入什么 | 为什么 |
|---|---|---|
| common 的 pom | 指向自己父工程的 parent；本模块 artifactId 为 `mall-common`；作为 jar 模块 | 后面放公共类，今天可以没有 Java 文件 |
| demo 的 pom | parent；artifactId 为 `mall-demo`；jar 模块 | 这是运行入口所在模块 |
| demo 的 dependencies | `org.springframework.boot:spring-boot-starter-web` | 引入 Web 应用需要的组件 |
| demo 的 build/plugins | `org.springframework.boot:spring-boot-maven-plugin` | 为后续 Spring Boot 运行、打包准备；今天先用 IDE 启动 |

使用 Spring Boot 父依赖管理时，Web starter 不用自己再填写版本。两个子模块都要能解析到你的父工程。demo 今天还没有使用 common 的类，暂时不必添加对 common 的依赖。

### application.yml

今天只配置两项，自己查清层级后手敲：

- `server.port`：`8082`，这是服务监听端口。
- `spring.application.name`：`mall-demo`，这是应用名称。

注意使用空格缩进，不能使用 Tab。今天不需要 `application-dev.yml`、数据源和 Nacos 导入配置。

## 四、按顺序做，每一步都检查

### 任务 1：确认环境（20 分钟）

在终端执行：

```bash
java -version
mvn -v
```

把输出记到 `学习记录.md`。确认终端与 IDE 项目 SDK、Maven 使用的 Java 都指向 JDK 17。如果 `mvn` 不存在，先确认是否配置了 Maven，或者 IDE 是否使用内置 Maven；不要把“找不到命令”当成 Java 代码错误。

**验收：** 知道自己实际使用的 JDK 和 Maven，IDE 能导入 Maven 项目。

### 任务 2：搭 Maven 工程（35 分钟）

1. 创建上面的目录和三个 pom。
2. 按第三节添加最小配置和依赖。
3. 在 IDE 中打开练习根目录，重新加载 Maven。
4. 在练习工程根目录运行：

```bash
mvn -pl mall-demo -am compile
```

此时还没有业务代码也可以验证模块和依赖配置。`-pl` 选择模块，`-am` 同时构建它需要的 reactor 项目；以后加入模块依赖时再观察效果。

**验收：** Maven 输出 `BUILD SUCCESS`。如果失败，保留第一个关键错误及其上下文，先检查坐标、父子关系、目录与依赖下载结果。

### 任务 3：写启动类并启动（35 分钟）

创建 `MallDemoApplication.java`，要求：

- 包名为 `com.macro.mall`。
- 有标准 Java main 方法。
- 使用 Spring Boot 的启动注解。
- 在 main 中通过 Spring Boot 的入口启动当前应用。

随后创建 `application.yml`，设置服务名和端口。在 IDE 中运行 main。

**验收：** 日志显示应用启动成功，Web 服务监听 8082，进程继续运行。此时还没有 `/hello`，访问该路径出现 404 是正常的。

请在记录里写出：启动类注解是什么？main 里调用的启动入口是什么？你是根据哪条日志判断启动成功的？

### 任务 4：写第一个 HTTP 接口（50 分钟）

创建 `HelloController.java`，包名为 `com.macro.mall.demo.controller`。

实现要求：

1. 让 Spring 能发现这个类，并将它作为返回响应体的 Controller。
2. 声明一个处理 `GET /hello` 的方法。
3. 先让它返回字符串 `hello mall`，运行并访问一次。
4. 再将返回值改为包含 `message`、`application` 两个字段的对象。今天可以用 Java 的 `Map`，不强制新建 DTO。
5. `message` 的值为 `hello mall`，`application` 的值为 `mall-demo`。
6. 修改后重新启动，确认看到的是新响应。

在浏览器访问，或执行：

```bash
curl -i http://localhost:8082/hello
```

最终响应体应包含以下内容，字段顺序不限：

```json
{"message":"hello mall","application":"mall-demo"}
```

**验收：** 请求返回 HTTP 200，最终响应为 JSON；记录字符串版与对象版的响应体、Content-Type 有什么不同。此处 HTTP 200 是实际响应状态，今天尚未引入自定义业务 code。

不要只记注解名字。尝试用自己的话解释：这个方法没有被 main 直接调用，为什么浏览器访问后它仍然能执行？

### 任务 5：做两次实验（25 分钟）

每次都先写预期，再修改，重启后观察。实验结束恢复到正常可访问状态。

| 实验 | 操作 | 要观察什么 |
|---|---|---|
| 改端口 | 将端口改为 8083，停止旧进程并重新启动；分别访问 8082、8083 | 哪个端口能连上？连接失败与 HTTP 404 有什么区别？ |
| 改扫描范围 | 保持启动类包名不变，临时把 Controller 移到 `com.example.outside` 并同步修改 package；重启访问 `/hello` | 应用是否还会启动？接口是什么结果？移回原包后能否恢复？ |

若旧端口仍能访问，先检查是不是旧进程没有停止。不要为了让实验“符合答案”而忽略实际现象。

**验收：** 两个实验都保存“修改前 → 预期 → 实际 → 原因”。最后恢复端口 8082 和 Controller 的原包位置，重新访问成功。

### 任务 6：记录与自述（15 分钟）

在练习工程根目录创建 `学习记录.md`，填写：

```text
Day 1 日期 / 实际用时：
练习工程绝对路径：
JDK / Maven / IDE：
亲手创建的文件：
编译结果：
启动日志的关键原文：
/hello 请求、HTTP 状态、Content-Type、响应体：
实验一：预期 / 实际 / 我的解释：
实验二：预期 / 实际 / 我的解释：
遇到的报错原文 / 排查过程 / 修复方式：
今天仍不明白的地方：
```

自述时关闭参考代码，用自己的话说出 main、`@SpringBootApplication`、`@RestController`、`@GetMapping` 分别负责什么。不会的部分如实记录，方便后续针对性检验。

## 五、遇到问题先看什么

| 现象 | 第一轮排查方向 |
|---|---|
| Maven 导入失败 | pom 语法、parent 坐标/相对路径、依赖下载错误 |
| 找不到或无法运行 main | 文件的源码目录、package、项目 SDK、模块是否导入成功 |
| 启动报端口占用 | 查看占用进程，确认是不是自己上次启动的应用；停止自己的旧应用或改端口 |
| 连接失败 | 服务是否仍在运行、实际监听端口、请求地址 |
| HTTP 404 | Controller 包位置、扫描范围、方法上的路径、请求是否打到了正确应用 |
| HTTP 405 | 实际请求方法与接口声明的 HTTP 方法是否一致 |
| 返回结果与修改前一样 | 是否重新启动、是否访问了旧进程、运行配置选的是否为练习模块 |

卡住时发给我：你做了什么、预期是什么、实际错误原文、相关文件路径。我先给排查提示，再由你修改和验证。

## 六、参考源码与知识主次

**核心：** Spring Boot 启动的应用怎样接收请求并调用 Controller。

**支撑：** Maven 父子工程、Web starter、组件扫描、响应体、端口配置。今天先知道模块各自的职责，不要求背完原项目依赖。

| 知识点 | 参考位置 | 今天怎么读 |
|---|---|---|
| 父工程与模块 | [pom.xml](/Volumes/MyDisk/mall-swarm/pom.xml:12) | 只看 packaging、modules、parent 和 Java 版本；原项目模块比今天多 |
| 启动入口 | [MallDemoApplication.java](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/MallDemoApplication.java:8) | 今天只学启动注解和 main；Feign、Discovery 后面再加 |
| Web 模块依赖 | [mall-demo/pom.xml](/Volumes/MyDisk/mall-swarm/mall-demo/pom.xml:24) | 找出 Web starter 和启动插件，不照搬全部依赖 |
| Controller 与响应体 | [DemoController.java](/Volumes/MyDisk/mall-swarm/mall-demo/src/main/java/com/macro/mall/demo/controller/DemoController.java:25) | 原项目使用 Controller + ResponseBody；今天先写 RestController，观察二者职责的联系 |

`HelloController` 是本次学习新增的练习，不是原仓库已有文件。今天的精简依赖设计，是为了逐项理解 Spring Boot；直接复制原 demo 的全部 pom 和 dev 配置，会提前引入数据库、Nacos 等启动要求。

## 七、完成后交什么，怎样检验

- [ ] 三个 pom 能被 Maven 正确识别，编译成功。
- [ ] 自己的应用在 8082 启动。
- [ ] `GET /hello` 返回 HTTP 200 和指定 JSON。
- [ ] 两次实验都做过，并恢复到正常状态。
- [ ] 练习根目录有学习记录，保留真实报错和实际观察。

完成后告诉我练习目录的绝对路径，并说“Day 1 写完了，帮我检验”。我会先读你写的代码，再进入两轮检验：一轮约 8 道开放题，二轮针对答错/半对的地方追问 3–4 题；排查题要求至少 3 个原因和验证手段。

检验后在你的练习工程根目录保存 `学习检验-Day1.md`，逐题保留题目、你的原答案、点评和标准回答，再布置 1–2 个验证实验；你做完后回填结论。Day 5 再做一次覆盖前五天内容的阶段检验。

今天不用一次写完全部文件再运行：**pom 能解析就检查一次，应用能启动就检查一次，接口能返回就检查一次。**
