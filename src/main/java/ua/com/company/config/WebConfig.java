package ua.com.company.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import ua.com.company.formatter.JsonPersonFormatter;
import ua.com.company.resolvers.PDFviewResolver;
import ua.com.company.resolvers.RssResolver;
import ua.com.company.resolvers.XlsResolver;
import ua.com.company.resolvers.XmlResolver;

@Configuration
@EnableWebMvc
@ComponentScans({ @ComponentScan("ua.com.company.controller") })
@Import({ ThymeLeafConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	@Qualifier("thymeleafViewResolver")
	ViewResolver thymeleafViewResolver;

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.TEXT_HTML)
		.favorPathExtension(true)
		.favorParameter(false)
		.ignoreAcceptHeader(true);

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/stat/**").addResourceLocations("classpath:/static/");
	}

	@Bean
	public ContentNegotiatingViewResolver viewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		JsonPersonFormatter jsonPersonFormatter = new JsonPersonFormatter();
		PDFviewResolver pdFviewResolver = new PDFviewResolver();
		XlsResolver xlsResolver = new XlsResolver();
		XmlResolver xmlResolver = new XmlResolver();
		RssResolver rssResolver = new RssResolver();

		List<ViewResolver> resolvers = new ArrayList<>();
		resolvers.add(jsonPersonFormatter);
		resolvers.add(pdFviewResolver);
		resolvers.add(xlsResolver);
		resolvers.add(xmlResolver);
		resolvers.add(rssResolver);
		resolvers.add(thymeleafViewResolver);

		resolver.setViewResolvers(resolvers);
		return resolver;
	}

}
