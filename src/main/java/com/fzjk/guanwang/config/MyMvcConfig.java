package com.fzjk.guanwang.config;

import com.fzjk.guanwang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    //ViewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器
//    @Bean
//    public ViewResolver myViewResolver() {
//        return new MyViewResolver();
//    }
//
//    //自定义了一个自己的视图解析器myViewResolver
//    public static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*配置LoginInterceptor拦截器的拦截路径*/
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")   //拦截admin下面的所有页面
                .excludePathPatterns("/admin")  //不拦截admin登录页面
                .excludePathPatterns("/admin/login"); //不拦截登录时的post请求页面，否则被拦截无法登录
    }
}