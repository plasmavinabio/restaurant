package restaurant.dao;

import java.util.Locale;
import java.util.Map;

import restaurant.dto.MessageSourceDTO;
import restaurant.dto.MessageSourceLangDTO;

public interface MessageSourceDAO {
	MessageSourceDTO getMessageSourceByID(Long id);
	MessageSourceDTO getMessageSourceByCode(String code);
	MessageSourceLangDTO getMessageSourceLangByID(Long id);
	Map<String, String> getMessagesByCode(Locale code);//<String locale, String message>
	Map<String, String> getMessagesByLocale(Locale locale);//<String code, String message>
	String getMessageByCodeAndLocale(String code, Locale locale);
}
