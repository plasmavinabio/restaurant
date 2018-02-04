package restaurant.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "message_source_lang")
public class MessageSourceLangDTO {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column (name = "message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "id_message_source")
	MessageSourceDTO messageSource;
	
	@ManyToOne
	@JoinColumn(name = "id_lang")
	LanguageDTO language;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageSourceDTO getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSourceDTO messageSource) {
		this.messageSource = messageSource;
	}

	public LanguageDTO getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDTO language) {
		this.language = language;
	}
	
}
