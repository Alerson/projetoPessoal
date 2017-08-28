package br.com.personalPrpject.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * AppInitializer.java
 * 
 * @author paulo.lopes
 *
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		
		WebApplicationContext context = getContext();
		
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(SecurityConfiguration.class);
		rootContext.register(AppConfiguration.class);
		rootContext.setServletContext(container);
		
		registerListener(container, rootContext);
//		registerOpenEntityManagerInViewFilter(container);
		
		// Configure facelets to use xhtml instead of jsp extension
//		container.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		registerDispatcherServlet(container, context);
		
	    // Filter.
	    FilterRegistration.Dynamic fr = container.addFilter("encodingFilter", CharacterEncodingFilter.class);
	
	    fr.setInitParameter("encoding", "UTF-8");
	    fr.setInitParameter("forceEncoding", "true");
	    fr.addMappingForUrlPatterns(null, true, "/*");
	}
	
	private void registerDispatcherServlet(ServletContext container, WebApplicationContext context) {
		ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	private void registerListener(ServletContext container, AnnotationConfigWebApplicationContext rootContext) {
		container.addListener((new ContextLoaderListener(rootContext)));
		container.addListener(new RequestContextListener());
	}
	
	/*private void registerOpenEntityManagerInViewFilter(ServletContext container) {
		container.addFilter("Spring OpenEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class).addMappingForUrlPatterns(null, false, "/*");
	}*/	
	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		return context;
	}	
}