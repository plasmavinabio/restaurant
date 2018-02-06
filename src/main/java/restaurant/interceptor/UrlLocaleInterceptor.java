package restaurant.interceptor;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;
 
public class UrlLocaleInterceptor extends HandlerInterceptorAdapter {
 
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
           throws Exception {
 
       LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
 
       if (localeResolver == null) {
           throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
       }
 
       // Lấy ra thông tin Locale từ LocaleResolver
       Locale locale = localeResolver.resolveLocale(request);

       localeResolver.setLocale(request, response, locale);
 
       return true;
   }

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String value= (String) pathVariables.get("${lang.code}");
	}
}
