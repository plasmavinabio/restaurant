package restaurant.message.source;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;

import restaurant.dao.MessageSourceDAO;

public class DatabaseMessageSource extends AbstractMessageSource {
	@Autowired
	private MessageSourceDAO messageSourceDAO;
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		String msg = messageSourceDAO.getMessageByCodeAndLocale(code, locale);
		return createMessageFormat(msg, locale);
	}

	

}
