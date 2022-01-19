package com.fzjk.guanwang.config;

import com.fzjk.guanwang.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //上传的绝对路径
    @Value("${spring.servlet.multipart.location}")
    private String staticImgPath;


    /**
     * 虚拟路径
     * 1.如果图片存放的目录是在target/classes/static/upload/imgs下面,@value里面不用"/**"直接"/"
     * 2.如果图片存放在项目外的本地盘符中,需要加"/**",否则无法浏览器无法获取静态资源
     */
    @Value("/upload/imgs/**")
    private String imgPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //浏览器访问的虚拟路径（浏览器默认无法访问工程项目外的本地文件）
        registry.addResourceHandler(imgPath).
                addResourceLocations("file:/"+staticImgPath);//必须是file:绝对路径名
    }

    //配置视图控制器:视图控制器作用是将前台路径不经controller直接forward到view。
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/list/1").setViewName("/list/about_1");
////        registry.addViewController("/index.html").setViewName("index");
//    }


    //配置管理员系统拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*配置LoginInterceptor拦截器的拦截路径*/
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")   //拦截admin下面的所有页面
                .excludePathPatterns("/admin")  //不拦截admin登录页面
                .excludePathPatterns("/admin/login"); //不拦截登录时的post请求页面，否则被拦截无法登录
    }
}