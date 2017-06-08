package com.benai.mahjong.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = "com.benai.mahjong.dao.mapper")
public class DatabaseConfig implements EnvironmentAware {

   private Environment env;
     private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
        this.propertyResolver = new RelaxedPropertyResolver(env, "jdbc.");
    }
    
    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(H2).build();
         HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(propertyResolver.getProperty("dataSourceClassName"));
        hikariConfig.setJdbcUrl(propertyResolver.getProperty("url")); 
        hikariConfig.setUsername(propertyResolver.getProperty("username"));
        hikariConfig.setPassword(propertyResolver.getProperty("password"));

        hikariConfig.setPoolName("springHikariCP");
        //實驗結果是要把它關掉，不然事務控制會無效
        hikariConfig.setAutoCommit(false);
        
        hikariConfig.addDataSourceProperty("cachePrepStmts", propertyResolver.getProperty("cachePrepStmts"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", propertyResolver.getProperty("prepStmtCacheSize"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", propertyResolver.getProperty("prepStmtCacheSqlLimit"));
        hikariConfig.addDataSourceProperty("useServerPrepStmts", propertyResolver.getProperty("useServerPrepStmts"));
          
        hikariConfig.setMinimumIdle(Integer.parseInt(propertyResolver.getProperty("minimumIdle")));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(propertyResolver.getProperty("maximumPoolSize")));
//        hikariConfig.setConnectionInitSql("SELECT 1");
        
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));
        return sessionFactory.getObject();
    }

}
