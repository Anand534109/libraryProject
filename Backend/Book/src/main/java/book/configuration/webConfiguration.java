package book.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="book")
public class webConfiguration  implements WebMvcConfigurer{
	
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//		.allowedOrigins("http://localhost:5173")
//		.allowedMethods("GET","PUT","POST","DELETE")
//		.allowedHeaders("*");
//	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:5173")
		.allowedMethods("GET","POST","PUT","DELETE")	
		.allowedHeaders("*")
		.allowCredentials(true);
	}

}
