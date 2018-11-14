#注意事项
-   问题

    请求登陆的时候，浏览器出现无限重定向的问题
-   原因

    再出现无限重定向的过程中，是由于没有支持jsp配置，然后跳转到/error页面，然后继续被拦截到，所以出现了无限重定向
-   解决

    1.启动，使用Springboot的插件启动，
    2.确定yml当中配置了jsp的前缀和后缀
```
 mvc:
    view:
      prefix: /WEB-INF/jsp/
      suffix: .jsp
```
#使用拦截器的主要经验
-   声明拦截器
    ``` public class LoginInterceptor implements HandlerInterceptor {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {```
-   加入到框架中
    ```@Configuration
       public class SessionConfig extends WebMvcConfigurerAdapter {
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
           }
       }
```