package com.gg.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {

    //默认的自动配置是判断容器中没有才会配置@ConditionalOnMissingBean(DataSource.class)
//    @ConfigurationProperties("spring.datasource")
//    @Bean
    //配置数据源一般到yml文件配置
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriverClassName();

        //加入druid监控功能     wall： 开启防火墙

//        druidDataSource.setFilters("stat,wall");

        return druidDataSource;
    }


    //配置druid 的监控页功能
//    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //druid 的监控页功能  的登录账号和密码...
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123");


        return registrationBean;
    }

    //WebStatFilter用于采集web-jdbc 关联监控的数据
//    @Bean
    public FilterRegistrationBean WebStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean =
                new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.css,*.gif,*.png,*.ico,*.gif,/druid/*,");

        return filterRegistrationBean;
    }

}
