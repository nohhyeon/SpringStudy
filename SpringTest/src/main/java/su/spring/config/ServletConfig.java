package su.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import su.spring.web.login.InterceptorLogin;
import java.util.Properties;

//스프링 설정 클래스를 선언하며 클래스가 스프링의 구성이나 설정 클래스임을 나타낸다.
@Configuration
// 스프링 프레임워크의 웹 MVC 설정을 지원한다.
@EnableWebMvc
//특정 패키지를 스캔하며 컴포넌트, 서비스, 리포지토리 등을 자동으로 찾아 스프링 빈으로 등록한다.
@ComponentScan(basePackages = { "su.spring.test", "su.spring.web", "su.spring.dept" })
public class ServletConfig implements WebMvcConfigurer {
//정적 리소스에 대한 요청 경로를 지정하고 실제 리소스 위치를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
		resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		resourceHandlerRegistry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
		resourceHandlerRegistry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
		resourceHandlerRegistry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
	}

//JSP 파일을 뷰로 사용할 때 필요한 ViewResolver를 구성한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		viewResolverRegistry.viewResolver(internalResourceViewResolver);
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(new InterceptorLogin()).addPathPatterns("/admin/**");
	}

	// 멀티파트 파일 업로드를 처리하기 위한 빈을 등록한다.
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

// 메일 발송을 위한 JavaMailSenderImpl 객체를 생성하고 구성한다.
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.naver.com");
		javaMailSenderImpl.setPort(465);
		javaMailSenderImpl.setUsername("아이디@naver.com");
		javaMailSenderImpl.setPassword("비번");
		Properties properties = javaMailSenderImpl.getJavaMailProperties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.naver.com");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		return javaMailSenderImpl;
	}
}