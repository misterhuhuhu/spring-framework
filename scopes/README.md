Spring框架定义了6种类型的作用域：
-

- singleton
- prototype
- request
- session
- application
- websocket

自定义 Scope
- 
- 为了创建自定义Scope，我们必须实现Scope接口。我们还必须确保实现是线程安全的，因为作用域可以同时被多个 bean 工厂使用
  - 管理Scope对象和回调
  - 从Scope中检索对象
  - 注册销毁回调
  - 从Scope中删除对象
  - 获取会话ID
  - 解析上下文对象
