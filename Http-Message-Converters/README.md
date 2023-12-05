## 默认消息转换器

- ByteArrayHttpMessageConverter – 转换字节数组
- StringHttpMessageConverter – 转换字符串
- ResourceHttpMessageConverter – 将org.springframework.core.io.Resource转换为任何类型的八位字节流
- SourceHttpMessageConverter – 转换 javax.xml.transform.Source
- FormHttpMessageConverter – 将表单数据转换为MultiValueMap<String， String>
- Jaxb2RootElementHttpMessageConverter – 将 Java 对象转换为 XML 或从 XML 转换（仅当类路径上存在 JAXB2 时才添加）
- MappingJackson2HttpMessageConverter – 转换 JSON（仅当类路径上存在 Jackson 2 时才添加）
- MappingJacksonHttpMessageConverter – 转换 JSON（仅当 Jackson 存在于类路径中时才添加）
- AtomFeedHttpMessageConverter – 转换 Atom 提要（仅当类路径上存在 Rome 时才添加）
- RssChannelHttpMessageConverter – 转换 RSS 源（仅当类路径上存在 Rome 时才添加）


### 自定义转换器配置
实现 WebMvcConfigurer 接口并重写 configureMessageConverters 方法来自定义消息转换器

```
@EnableWebMvc
@Configuration
@ComponentScan({ "com.baeldung.web" })
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        messageConverters.add(createXmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);

        return xmlConverter;
    } 
}
```


### Spring Boot 支持
```
@Bean
public HttpMessageConverter<Object> createXmlHttpMessageConverter() {
    MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();

    // ...

    return xmlConverter;
}
```