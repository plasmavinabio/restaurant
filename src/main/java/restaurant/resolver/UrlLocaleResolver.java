package restaurant.resolver;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;

import restaurant.dto.LanguageDTO;
import restaurant.dao.LanguageDAO;
 
public class UrlLocaleResolver implements LocaleResolver {
 
    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";
	@Autowired
	private LanguageDAO languageDao;
 
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
    	
        String uri = request.getRequestURI();
        Locale locale = null;
        //Get locale from url
        String servletPath = uri.substring(request.getContextPath().length() + 1);
        String[] args = servletPath.split("/");
        if (args.length > 0) {
        	LanguageDTO language = languageDao.getByCode(args[0]);
        	if (language != null && language.isActive()) {
        		locale = language.getLocale();
        	}
        }
        //Get locale from Session or default language
        if (locale == null) {
        	locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
        	if (locale == null) {
                LanguageDTO defaultLanguage = languageDao.getDefault();
                if (defaultLanguage != null && defaultLanguage.isActive()) {
                	locale = defaultLanguage.getLocale();
                }
                else {
                	List<LanguageDTO> activeLanguages = languageDao.getActiveLanguage();
                	if (activeLanguages.size() > 0) {
                		LanguageDTO activeLanguage = activeLanguages.get(0);
                		locale = activeLanguage.getLocale();
                	}
                	else {
                		locale = Locale.ENGLISH;
                	}
                }
        	}
        }
        //Set current locale to session
        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        
        return locale;
    }
 
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Nothing
    }
 
}
