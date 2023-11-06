
Spring bean容器中有两种bean：普通bean和工厂bean。Spring直接使用前者，而后者可以自己生成对象，由框架管理。
  
我们可以通过实现org.springframework.beans.factory.FactoryBean接口来构建工厂 bean


要访问 FactoryBean ，您只需在 bean 名称前添加“&”即可。

