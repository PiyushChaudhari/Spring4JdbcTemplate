package com.web.application.config;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.web.application")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:${spring.profiles.active}-application.properties")
public class WebAppConfig {

	private static final Logger LOGGER = Logger.getLogger(WebAppConfig.class.getName());

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		LOGGER.info("***********************************");
		LOGGER.info("Application Environment " + env.getRequiredProperty("application.environment"));
		LOGGER.info("***********************************");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

//	@Bean
//	public UrlBasedViewResolver setupViewResolver() {
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		return resolver;
//	}
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
	}

}
