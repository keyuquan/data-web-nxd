package com.web.nxd.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by PrimaryKey on 17/2/4.
 */
@Configuration
@MapperScan(basePackages = "com.web.nxd.report.dao", sqlSessionFactoryRef = "dorisDBSqlSessionFactory")
public class DorisDBConfig {
    private Logger logger = LoggerFactory.getLogger(DorisDBConfig.class);
    @Value("${spring.datasource.dorisdb.url}")
    private String dbUrl;

    @Value("${spring.datasource.dorisdb.username}")
    private String username;

    @Value("${spring.datasource.dorisdb.password}")
    private String password;

    @Value("${spring.datasource.dorisdb.driverClassName}")
    private String driverClassName;


    @Bean(name = "dorisDBDataSource")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }

    @Bean(name = "dorisDBSqlSessionFactory")
    public SqlSessionFactory dorisDBSqlSessionFactory(@Qualifier("dorisDBDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/report/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dorisDBTransactionManager")
    public DataSourceTransactionManager dorisDBTransactionManager(@Qualifier("dorisDBDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dorisDBJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dorisDBDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

