package org.cap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({ "org.cap" })
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver getViewresolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factorybean = new LocalEntityManagerFactoryBean();
		factorybean.setPersistenceUnitName("jpademo");
		return factorybean;
	}

	@Bean
	public JpaTransactionManager getTransactionManager() {
		JpaTransactionManager transactionmanager = new JpaTransactionManager();
		transactionmanager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return transactionmanager;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	

}
