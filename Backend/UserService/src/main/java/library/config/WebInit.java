package library.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {JpaConfiguration.class
				,SpringSecurityConfig.class
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	
//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] {new DelegatingFilterProxy("springSecurityFilterChain")};
//	}

}
