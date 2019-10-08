package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类
 */
@Configuration
@ComponentScan("com.xjl")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("druid.properties")
@EnableTransactionManagement
public class SpringConfiguration {

}
