package pl.bialek.infrastructure.configuration;

import jakarta.servlet.Filter;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletDispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { 
        return null; 
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { 
        return new Class[]{AppConfiguration.class};
    }

    @NonNull
    @Override
    protected String[] getServletMappings() { 
        return new String[]{"/"}; 
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        
        return new Filter[]{new HiddenHttpMethodFilter(), characterEncodingFilter};
    }
}