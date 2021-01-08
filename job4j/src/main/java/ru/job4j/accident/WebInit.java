package ru.job4j.accident;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import ru.job4j.accident.config.DataConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class, DataConfig.class, SecurityConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));
        rootContext.refresh();
        DispatcherServlet servlet = new DispatcherServlet(rootContext);
        ServletRegistration.Dynamic registration = container.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        FilterRegistration.Dynamic filterRegistration = container.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forceEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");
    }
}
