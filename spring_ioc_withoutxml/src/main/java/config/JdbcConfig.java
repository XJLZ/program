package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@SuppressWarnings("all")
public class JdbcConfig {
    @Value("${driverClassName}")
    private String drive;

    @Value("${url}")
    private String url;

    @Value("${druid.username}")
    private String username;

    @Value("${druid.password}")
    private String password;


    /**
     * 创建JdbcTemplate对象
     * @param dataSource
     * @return
     */
    @Bean(name = "template")
    @Scope("prototype") // 多例 ，不写默认单例
    public JdbcTemplate createJdbcTemplate(@Qualifier("ds1") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "ds1")
    public DataSource createDataSource1(){
        try {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName(drive);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "ds2")
    public DataSource createDataSource2(){
        try {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName(drive);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
