package com.chinasofti.projectDigest;

import java.lang.annotation.Annotation;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;



//定义Spring Boot 扫描包路径
@SpringBootApplication (scanBasePackages = {"com.chinasofti.projectDigest"})
//定义扫描filter包
@ServletComponentScan
//定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages="com.chinasofti.projectDigest.dao")
//定义实体Bean扫描包路径
@EntityScan(basePackages="com.chinasofti.projectDigest.pojo")
@MapperScan(
    //指定扫描包
	basePackages = "com.chinasofti.projectDigest.*",
	//指定SqlSessionFactory,如果sqlSessionTemplate被指定， 则作废
	sqlSessionFactoryRef = "sqlSessionFactory",
	//指定SqlSessionTemplate, 将忽略sqlSessionFactory的配置
	sqlSessionTemplateRef = "sqlSessionTemplate",
	//markerInterface = Class.class,//限定扫描接口， 不常用
	annotationClass = Repository.class
	
)
public class ProjectDigestApplication extends SpringBootServletInitializer {

	@Autowired
	SqlSessionFactory sqlSessionFactory = null;
	
	//定义一个MyBatis的Mapper接口
	/**
	 * @return
	 */
	/*
	 * @Bean public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao(){
	 * MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
	 * bean.setMapperInterface(MyBatisUserDao.class);
	 * bean.setSqlSessionFactory(sqlSessionFactory); return bean; }
	 */
	
	/*
	 * @Bean public MapperScannerConfigurer mapperScannerConfig() { //定义扫描器实例
	 * MapperScannerConfigurer mapperScannerConfigurer = new
	 * MapperScannerConfigurer();
	 * 
	 * //加载SqlSessionFactory, Spring Boot 会自动产生，SqlSessionFactory实例
	 * mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	 * 
	 * mapperScannerConfigurer.setBasePackage("com.chinasofti.projectDigest.*");
	 * //定义扫描的包 mapperScannerConfigurer.setAnnotationClass(Repository.class); return
	 * mapperScannerConfigurer;
	 * 
	 * }
	 */
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 
		return builder.sources(ProjectDigestApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectDigestApplication.class, args);
	}

	
	 
	
	
}
