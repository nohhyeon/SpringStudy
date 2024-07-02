package su.spring.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration.Dynamic;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { RootConfig.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { ServletConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }

   @Override
   protected Filter[] getServletFilters() {
      CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
      characterEncodingFilter.setEncoding("UTF-8");
      characterEncodingFilter.setForceEncoding(true);

      HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
      return new Filter[] { characterEncodingFilter, hiddenHttpMethodFilter };
   }

   @Override
   protected void customizeRegistration(Dynamic dynamic) {
      MultipartConfigElement multipartConfigElement = new MultipartConfigElement("", 2000000, 4000000, 0);
      dynamic.setMultipartConfig(multipartConfigElement);
      dynamic.setAsyncSupported(true);
   }

}
