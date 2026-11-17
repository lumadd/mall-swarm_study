Day 1 日期 11月17日 / 实际用时：1小时
练习工程绝对路径：/Volumes/MyDisk/mall-swarm_study
JDK / Maven / IDE：
亲手创建的文件：查看git履历
编译结果：成功
启动日志的关键原文：
/Users/xiaozedemac/Library/Java/JavaVirtualMachines/ms-17.0.20/Contents/Home/bin/java -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dmanagement.endpoints.jmx.exposure.include=* -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=62659 -Dfile.encoding=UTF-8 -classpath /Volumes/MyDisk/mall-swarm_study/mall-demo/target/classes:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.5.14/spring-boot-starter-web-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter/3.5.14/spring-boot-starter-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot/3.5.14/spring-boot-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.5.14/spring-boot-autoconfigure-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.5.14/spring-boot-starter-logging-3.5.14.jar:/Users/xiaozedemac/.m2/repository/ch/qos/logback/logback-classic/1.5.32/logback-classic-1.5.32.jar:/Users/xiaozedemac/.m2/repository/ch/qos/logback/logback-core/1.5.32/logback-core-1.5.32.jar:/Users/xiaozedemac/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/Users/xiaozedemac/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/Users/xiaozedemac/.m2/repository/org/slf4j/jul-to-slf4j/2.0.17/jul-to-slf4j-2.0.17.jar:/Users/xiaozedemac/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/xiaozedemac/.m2/repository/org/yaml/snakeyaml/2.4/snakeyaml-2.4.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.5.14/spring-boot-starter-json-3.5.14.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.21.2/jackson-databind-2.21.2.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.21/jackson-annotations-2.21.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.21.2/jackson-core-2.21.2.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.21.2/jackson-datatype-jdk8-2.21.2.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.21.2/jackson-datatype-jsr310-2.21.2.jar:/Users/xiaozedemac/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.21.2/jackson-module-parameter-names-2.21.2.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.5.14/spring-boot-starter-tomcat-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.54/tomcat-embed-core-10.1.54.jar:/Users/xiaozedemac/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.54/tomcat-embed-el-10.1.54.jar:/Users/xiaozedemac/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.54/tomcat-embed-websocket-10.1.54.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-web/6.2.18/spring-web-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-beans/6.2.18/spring-beans-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-webmvc/6.2.18/spring-webmvc-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-context/6.2.18/spring-context-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-expression/6.2.18/spring-expression-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.5.14/spring-boot-starter-actuator-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.5.14/spring-boot-actuator-autoconfigure-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-actuator/3.5.14/spring-boot-actuator-3.5.14.jar:/Users/xiaozedemac/.m2/repository/io/micrometer/micrometer-observation/1.15.11/micrometer-observation-1.15.11.jar:/Users/xiaozedemac/.m2/repository/io/micrometer/micrometer-commons/1.15.11/micrometer-commons-1.15.11.jar:/Users/xiaozedemac/.m2/repository/io/micrometer/micrometer-jakarta9/1.15.11/micrometer-jakarta9-1.15.11.jar:/Users/xiaozedemac/.m2/repository/io/micrometer/micrometer-core/1.15.11/micrometer-core-1.15.11.jar:/Users/xiaozedemac/.m2/repository/org/hdrhistogram/HdrHistogram/2.2.2/HdrHistogram-2.2.2.jar:/Users/xiaozedemac/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-starter-aop/3.5.14/spring-boot-starter-aop-3.5.14.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-aop/6.2.18/spring-aop-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/aspectj/aspectjweaver/1.9.25.1/aspectjweaver-1.9.25.1.jar:/Users/xiaozedemac/.m2/repository/org/slf4j/slf4j-api/2.0.17/slf4j-api-2.0.17.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-core/6.2.18/spring-core-6.2.18.jar:/Users/xiaozedemac/.m2/repository/org/springframework/spring-jcl/6.2.18/spring-jcl-6.2.18.jar:/Users/xiaozedemac/.m2/repository/cn/hutool/hutool-all/5.8.40/hutool-all-5.8.40.jar:/Users/xiaozedemac/.m2/repository/org/projectlombok/lombok/1.18.46/lombok-1.18.46.jar:/Users/xiaozedemac/.m2/repository/org/springframework/boot/spring-boot-configuration-processor/3.5.14/spring-boot-configuration-processor-3.5.14.jar com.macro.mall.MallDemoApplication

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/

:: Spring Boot ::               (v3.5.14)

2026-11-17T19:58:01.376+08:00  INFO 31142 --- [mall-demo] [           main] com.macro.mall.MallDemoApplication       : Starting MallDemoApplication using Java 17.0.20 with PID 31142 (/Volumes/MyDisk/mall-swarm_study/mall-demo/target/classes started by xiaozedemac in /Volumes/MyDisk/mall-swarm_study)
2026-11-17T19:58:01.376+08:00  INFO 31142 --- [mall-demo] [           main] com.macro.mall.MallDemoApplication       : No active profile set, falling back to 1 default profile: "default"
2026-11-17T19:58:01.706+08:00  INFO 31142 --- [mall-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8082 (http)
2026-11-17T19:58:01.710+08:00  INFO 31142 --- [mall-demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-11-17T19:58:01.710+08:00  INFO 31142 --- [mall-demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.54]
2026-11-17T19:58:01.723+08:00  INFO 31142 --- [mall-demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-11-17T19:58:01.723+08:00  INFO 31142 --- [mall-demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 332 ms
2026-11-17T19:58:01.880+08:00  INFO 31142 --- [mall-demo] [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2026-11-17T19:58:01.898+08:00  INFO 31142 --- [mall-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8082 (http) with context path '/'
2026-11-17T19:58:01.904+08:00  INFO 31142 --- [mall-demo] [           main] com.macro.mall.MallDemoApplication       : Started MallDemoApplication in 0.653 seconds (process running for 0.839)
2026-11-17T19:58:02.010+08:00  INFO 31142 --- [mall-demo] [nio-8082-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-11-17T19:58:02.010+08:00  INFO 31142 --- [mall-demo] [nio-8082-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-11-17T19:58:02.010+08:00  INFO 31142 --- [mall-demo] [nio-8082-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms

/hello 请求、HTTP 状态、Content-Type、响应体：
摘要
URL: http://localhost:8082/hello
状态: 200
来源: 网络
地址: ::1:8082

请求
GET /hello HTTP/1.1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Encoding: gzip, deflate
Accept-Language: zh-CN,zh-Hans;q=0.9
Connection: keep-alive
Priority: u=0, i
Sec-Fetch-Dest: document
Sec-Fetch-Mode: navigate
Sec-Fetch-Site: none
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.3 Safari/605.1.15

响应
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Tue, 17 Nov 2026 12:00:40 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

实验一：预期 / 实际 / 我的解释：
预期 8082 不可以连接 只能连接 8083 接口
链接8082端口会出现服务不可用画面 ， 但不是受springboot管理的404画面
实验二：预期 / 实际 / 我的解释：
报错 404 服务器拒绝响应，因为 HelloController没有被Spring进行管理
移回原包后恢复
遇到的报错原文 / 排查过程 / 修复方式：
这个 没有实际执行 我知道问题所在 本质就是spring没有加载到HelloController
1.使用@ComponentScan注解，加入新的扫描路径 
2.对@SpringBootApplication 注解的参数进行赋值 scanBasePackages =
3.将HelloController 移动到 含有 @SpringBootApplication 的子包下
今天仍不明白的地方： 暂时没有