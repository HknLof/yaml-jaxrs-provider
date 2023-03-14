# yaml-jaxrs-provider

Small example showcasing the problem described in https://github.com/quarkusio/quarkus/issues/31818

Project skeleton created via:

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.4.Final:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=yaml-jaxrs-provider \
    -Dextensions='resteasy-reactive,resteasy-reactive-jackson'
```
Added the lines L43-L47 in `./pom.xml` and `application.properties` for registering jackson jaxrs yaml provider.

## Sample execution and output

```shell
./mvnw clean test
```


## Output of `RolesResourceTest`
```
[INFO] Running org.acme.RoleResourceTest
2023-03-14 18:39:50,954 WARN  [io.qua.run.uti.ContainerRuntimeUtil] (main) Command "podman" exited with error code 125. Rootless container runtime detection might not be reliable.
2023-03-14 18:39:53,580 INFO  [io.quarkus] (main) yaml-jaxrs-provider 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.16.4.Final) started in 4.094s. Listening on: http://localhost:8081
2023-03-14 18:39:53,581 INFO  [io.quarkus] (main) Profile test activated.
2023-03-14 18:39:53,582 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, vertx]
2023-03-14 18:39:55,257 INFO  [org.acm.Role] (vert.x-eventloop-thread-0) Serializing role with name := basic-json-role
2023-03-14 18:39:55,474 INFO  [org.acm.Role] (vert.x-eventloop-thread-1) Serializing role with name := basic-yaml-role
2023-03-14 18:39:55,506 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (vert.x-eventloop-thread-1) HTTP Request to /roles failed, error id: c36ba3d3-65e9-440b-a3d1-e21d18a227e2-1: java.lang.IllegalArgumentException: Class `org.acme.Role` not subtype of `io.smallrye.mutiny.Uni<org.acme.Role>`
        at com.fasterxml.jackson.databind.type.TypeFactory.constructSpecializedType(TypeFactory.java:464)
        at com.fasterxml.jackson.databind.type.TypeFactory.constructSpecializedType(TypeFactory.java:426)
        at com.fasterxml.jackson.jaxrs.base.ProviderBase.writeTo(ProviderBase.java:593)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:233)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:191)
        at org.jboss.resteasy.reactive.server.core.serialization.FixedEntityWriterArray.write(FixedEntityWriterArray.java:30)
        at org.jboss.resteasy.reactive.server.handlers.ResponseWriterHandler.handle(ResponseWriterHandler.java:34)
        at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:120)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
        at org.jboss.resteasy.reactive.server.vertx.VertxResteasyReactiveRequestContext$1$1.handle(VertxResteasyReactiveRequestContext.java:78)
        at org.jboss.resteasy.reactive.server.vertx.VertxResteasyReactiveRequestContext$1$1.handle(VertxResteasyReactiveRequestContext.java:75)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:264)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:246)
        at io.vertx.core.impl.EventLoopContext.lambda$runOnContext$0(EventLoopContext.java:43)
        at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:566)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:833)

2023-03-14 18:39:55,519 ERROR [org.jbo.res.rea.com.cor.AbstractResteasyReactiveContext] (vert.x-eventloop-thread-1) Request failed: java.lang.IllegalArgumentException: Class `org.acme.Role` not subtype of `io.smallrye.mutiny.Uni<org.acme.Role>`
        at com.fasterxml.jackson.databind.type.TypeFactory.constructSpecializedType(TypeFactory.java:464)
        at com.fasterxml.jackson.databind.type.TypeFactory.constructSpecializedType(TypeFactory.java:426)
        at com.fasterxml.jackson.jaxrs.base.ProviderBase.writeTo(ProviderBase.java:593)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:233)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:191)
        at org.jboss.resteasy.reactive.server.core.serialization.FixedEntityWriterArray.write(FixedEntityWriterArray.java:30)
        at org.jboss.resteasy.reactive.server.handlers.ResponseWriterHandler.handle(ResponseWriterHandler.java:34)
        at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:120)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
        at org.jboss.resteasy.reactive.server.vertx.VertxResteasyReactiveRequestContext$1$1.handle(VertxResteasyReactiveRequestContext.java:78)
        at org.jboss.resteasy.reactive.server.vertx.VertxResteasyReactiveRequestContext$1$1.handle(VertxResteasyReactiveRequestContext.java:75)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:264)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:246)
        at io.vertx.core.impl.EventLoopContext.lambda$runOnContext$0(EventLoopContext.java:43)
        at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:566)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:833)
```