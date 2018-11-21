package com.shiyanlou.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shiyanlou.springboot.dao.jpa.one.UserRepository;
import com.shiyanlou.springboot.dao.jpa.one.UserRepositoryOne;
import com.shiyanlou.springboot.dao.mybatis.one.UserMapperOne;
import com.shiyanlou.springboot.entity.jpa.User;
import com.shiyanlou.springboot.entity.jpa.UserOne;

@Configuration
@EnableTransactionManagement
//配置JPA第一个数据源
@EnableJpaRepositories(
		//设置repository所在位置
		basePackageClasses = {UserRepository.class,UserRepositoryOne.class},
		//设置entityManager工厂
		entityManagerFactoryRef = "entityManagerFactoryFirst",
		//设置事务管理器
		transactionManagerRef = "transactionManagerFirst"
		)
//mybatis配置第一个数据源
@MapperScan(basePackageClasses= {UserMapperOne.class},sqlSessionTemplateRef="sqlSessionTemplateFirst")
public class FirstDataSourceConfiguration {
	
	/*
	 * 数据源一
	 */
	private DataSource firstDataSource;
	
	/**
	 * 构造方式注入数据源
	 * @param firstDataSource
	 */
	public FirstDataSourceConfiguration(@Qualifier("firstDataSource") DataSource firstDataSource) {
		this.firstDataSource = firstDataSource;
	}
	
	
	/**
	 * 配置entityManager工厂
	 */
	@Primary
	@Bean(name = "entityManagerFactoryFirst")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanFirst(EntityManagerFactoryBuilder builder) {
		//repository 对应的entity类或者是package
		return builder.dataSource(firstDataSource).packages(User.class,UserOne.class).build();
	}
	
	/**
	 * 配置事务管理器
	 */
	@Primary
	@Bean(name = "transactionManagerFirst")
	public PlatformTransactionManager transactionManagerFirst(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryBeanFirst(builder).getObject());
	}
	
	@Primary
	@Bean(name = "sqlSessionFactoryFirst")
	public SqlSessionFactory sqlSessionFactoryFirst() throws Exception {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(firstDataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath*:mapper/UserMapperOne.xml"));
		
		return bean.getObject();
	}
	@Primary
	@Bean(name = "sqlSessionTemplateFirst")
	public SqlSessionTemplate sqlSessionTemplateFirst(@Qualifier("sqlSessionFactoryFirst") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
