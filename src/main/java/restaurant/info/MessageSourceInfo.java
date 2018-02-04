package restaurant.info;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Entity
public class MessageSourceInfo {
	@Id
	private String code;
	private String defaultMessage;
	private String translatedMessage;
	
	public MessageSourceInfo() {}
	
	public MessageSourceInfo(String code, String defaultMessage, String translatedMessage) {
		this.code = code;
		this.defaultMessage = defaultMessage;
		this.translatedMessage = translatedMessage;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDefaultMessage() {
		return defaultMessage;
	}
	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	public String getTranslatedMessage() {
		return translatedMessage;
	}
	public void setTranslatedMessage(String translatedMessage) {
		this.translatedMessage = translatedMessage;
	}
	public String getDisplayMessage() {
		if (this.translatedMessage != "") {
			return this.translatedMessage;
		}
		return this.defaultMessage;
	}
	
}
