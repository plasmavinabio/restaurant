package restaurant.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import restaurant.annotation.Message;
import restaurant.annotation.TranslableMessage;

import restaurant.dao.MessageSourceDAO;

@Controller
@SuppressWarnings({"unused"})
@TranslableMessage(messages = {
	@Message(code="code.1", defaultMessage="default Message 1", description="Description 1"),
	@Message(code="code.2", defaultMessage="default Message 2", description="Description 2"),
})
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
    
    @RequestMapping(value = "/")
    // Debug message source
    public String msg() {
    	
    	String test = messageSourceDAO.getMessageByCodeAndLocale("label.password", Locale.ENGLISH);
    	
    	return "login";
    }
    //To test custom annotation
    @RequestMapping("my-annotation")
    public String Annotation() {
    	Class<ExController> myClass = ExController.class;
    	TranslableMessage abc = (TranslableMessage)myClass.getAnnotation(TranslableMessage.class);

    	for (Message msg : abc.messages()) {
    		System.out.println("BEGIN OF ONE------------------------");
    		System.out.println("Code: " + msg.code());
    		System.out.println("Default message: " + msg.defaultMessage());
    		System.out.println("Description: " + msg.description());
    		System.out.println("END OF ONE------------------------");
    	}
    	
    	return "login";
    }
    
}
