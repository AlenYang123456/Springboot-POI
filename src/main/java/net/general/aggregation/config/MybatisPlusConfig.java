package net.general.aggregation.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dreamer Q
 * @Date: 2019/11/6 23:23
 * @Version 1.0
 * @Discription myabtisplus配置
 */
@Configuration
public class MybatisPlusConfig {

    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        //设置分页方言
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
