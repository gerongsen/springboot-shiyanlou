package com.shiyanlou.springboot.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shiyanlou.springboot.dao.jpa.two.UserRepositoryTwo;
import com.shiyanlou.springboot.dao.mybatis.two.UserMapperTwo;
import com.shiyanlou.springboot.entity.jpa.UserTwo;

@Configuration
@EnableTransactionManagement
//配置JPA第二个数据源
@EnableJpaRepositories(
		//设置repository所在位置
		basePackageClasses = {UserRepositoryTwo.class},
		//设置entityManager工厂
		entityManagerFactoryRef = "entityManagerSecond",
		//配置事务管理器
		transactionManagerRef = "transactionmanagerSecond"
		)
//配置mybatis第二个数据源
@MapperScan(basePackageClasses= {UserMapperTwo.class},sqlSessionTemplateRef="sqlSessionTemplateSecond")
public class SecondDataSourceConfiguration {
	
	
	private DataSource seconDataSource;

	public SecondDataSourceConfiguration(@Qualifier("secondDatasource") DataSource seconDataSource) {
		this.seconDataSource = seconDataSource;
	}
	/**
	 * 配置entitymanager工厂
	 * @param builder
	 * @return
	 */
	@Bean(name = "entityManagerSecond")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanSecond(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(seconDataSource).packages(UserTwo.class).build();
	}
	
	@Bean(name = "transactionmanagerSecond")
	public PlatformTransactionManager transactionManagersecond(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryBeanSecond(builder).getObject());
	}
	
	
	@Bean("sqlSessionFactorySecond")
	public SqlSessionFactory sqlSessionFactorySecond() throws Exception {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(seconDataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath*:mapper/UserMapperTwo.xml"));
		
		return bean.getObject();
	}
	
	@Bean(name = "sqlSessionTemplateSecond")
	public SqlSessionTemplate sqlSessionTemplateSecond(@Qualifier("sqlSessionFactorySecond")SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
