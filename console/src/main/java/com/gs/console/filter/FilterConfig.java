package com.gs.console.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @User远
 * @Date2022/4/26
 */
@Configuration
public class FilterConfig {

//    @Bean
//    public MyFilter getMyFilter(){
//        return new MyFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean getFilterRegistrationBean(MyFilter myFilter){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(myFilter); //设置过滤器
//        filterRegistrationBean.setOrder(1); //设置优先级
//        filterRegistrationBean.addUrlPatterns("/*");    //添加过滤的url
//        filterRegistrationBean.setName("myFilter"); //设置过滤器的名称
//        return filterRegistrationBean;
//    }
}
