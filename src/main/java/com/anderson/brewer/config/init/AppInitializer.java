package com.anderson.brewer.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.anderson.brewer.config.JPAConfig;
import com.anderson.brewer.config.ServiceConfig;
import com.anderson.brewer.config.WebConfig;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{JPAConfig.class, ServiceConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class}; /*Configura o spring web para encontrar os controllers*/
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] { "/" }; /* Padrão de URL/Requisições web --> Front Controller*/
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}





