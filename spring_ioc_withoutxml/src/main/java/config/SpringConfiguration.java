package config;

import org.springframework.context.annotation.*;


/**
 * 该类是一个配置类 相当于bean.xml
 * spring的新注解
 *      Configuration
 *              表明该类时一个配置类
 *      ComponentScan
 *              创建容器时要扫描的包
 *      属性:
 *          value: === basePackages 相当于
 *                                  <context:component-scan base-package="com"></context:component-scan>
 *      Bean:
 *          作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *          属性：
 *              name：用于指定bean 的id 不写时，默认时当前方法的名称
 */
@Configuration      // 该类作为参数传递时可以不写
@ComponentScan("com")  //扫描包
@Import(JdbcConfig.class)   //导入配置
@PropertySource("classpath:druid.properties")
public class SpringConfiguration {

}
