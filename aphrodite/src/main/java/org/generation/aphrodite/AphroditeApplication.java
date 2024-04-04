package org.generation.aphrodite;
import org.generation.aphrodite.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AphroditeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AphroditeApplication.class, args);
	}//Main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/productos/*");
		registrationBean.addUrlPatterns("/api/usuarios/*");
		return registrationBean;
	}//jwtFilter
	
}//class aplication
