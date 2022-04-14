package com.gg.config;

import com.gg.interceptor.LoginInterceptor;
//import com.gg.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/*
 * 拦截器的使用:
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors方法）
 * 3.指定拦截器规则，【如果是拦截所有，静态资源也会别拦截】
 *
 * @EnableWebMvc:全面接管WebMvc   静态资源 ，视图解析器，欢迎页  全部失效。
 *
 * */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /*
     *Filter,Interceptor 几乎拥有相同的功能？  都是拦截器
     *1.Filter是Servlet定义的原生组件。  好处是 脱离spring应用也能使用
     *2.Interceptor 是spring定义的接口，可以使用spring的自动装配等功能
     * */

//    @Autowired
//    private RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //拦截所有，包括静态资源
                //  放行的请求
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/js/**", "/images/**");

//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/js/**", "/images/**");
//
    }


 /*   @Bean
    public WebMvcRegistrations webMvcRegistrations(){
        return new WebMvcRegistrations(){
            public RequestMappingHandlerMapping requestMappingHandlerMapping(){
                return  null;
            }
        };
    }*/


}
