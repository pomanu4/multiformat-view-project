package ua.com.company.resolvers;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import ua.com.company.formatter.PersonPDFformatter;

public class PDFviewResolver implements ViewResolver{

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		PersonPDFformatter personPDFformatter = new PersonPDFformatter();
		return personPDFformatter;
	}
	
}
