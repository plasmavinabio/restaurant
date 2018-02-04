package restaurant.dto;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "message_source")
public class MessageSourceDTO {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "default_message")
	private String defaultMessage;
	
	@OneToMany(mappedBy="messageSource")
	@MapKeyColumn(name = "id_lang")
	private Map<Long, MessageSourceLangDTO> messageSourceLang;
	
	public MessageSourceDTO () {}
	
	public MessageSourceDTO (Long id, String code, String defaultMessage) {
		this.id = id;
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Map<Long, MessageSourceLangDTO> getMessageSourceLang() {
		return messageSourceLang;
	}

	public void setMessageSourceLang(Map<Long, MessageSourceLangDTO> messageSourceLang) {
		this.messageSourceLang = messageSourceLang;
	}
	
}
