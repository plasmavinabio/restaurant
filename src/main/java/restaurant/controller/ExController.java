package restaurant.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import restaurant.dao.MessageSourceDAO;

@Controller
@SuppressWarnings({"unused"})
public class ExController {
	@Autowired
	private LocaleResolver localeResolver;
	@Autowired 
	private MessageSourceDAO messageSourceDAO;
	//Language in URL Example
    @RequestMapping(value={"/login", "/{langCode}/login"})
    public String login(Model model) {
        return "login";
    }
    
    
    // Debug message source
    @RequestMapping(value = "/")
    public String msg() {
    	
    	String test = messageSourceDAO.getMessageByCodeAndLocale("label.password", Locale.ENGLISH);
    	
    	return "login";
    }
}
