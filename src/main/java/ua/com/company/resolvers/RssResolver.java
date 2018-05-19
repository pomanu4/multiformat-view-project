package ua.com.company.resolvers;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import ua.com.company.formatter.RssPersonFormatter;

public class RssResolver  implements ViewResolver{

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		RssPersonFormatter formatter = new RssPersonFormatter();
		return formatter;
	}
	

}
