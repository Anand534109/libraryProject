package book.configuration;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitialization extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?> [] getRootConfigClasses() {
		
		return new Class[] {JpaConfiguration.class,SpringSecurityConfig.class};
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {webConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
