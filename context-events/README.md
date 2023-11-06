Spring 中有多种内置事件
- 
- 上下文刷新事件 ContextRefreshedEvent
- 上下文启动事件 ContextStartedEvent
- 上下文停止事件 ContextStoppedEvent
- 上下文关闭事件 ContextClosedEvent

自定义事件
-
1. 实现自定义Event extends ApplicationEvent
2. 使用ApplicationEventPublisher 发布时间
3. 实现Listener implements ApplicationListener

异步
-
1. 自定义ApplicationEventMulticaster,new SimpleApplicationEventMulticaster的setTaskExecutor设置线程池
