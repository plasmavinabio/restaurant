package restaurant.dao.impl;

import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restaurant.dao.MessageSourceDAO;
import restaurant.dto.MessageSourceDTO;
import restaurant.dto.MessageSourceLangDTO;
import restaurant.info.MessageSourceInfo;

@Repository("messageSourceDAO")
@Transactional
public class MessageSourceDAOImpl implements MessageSourceDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public MessageSourceDTO getMessageSourceByID(Long id) {
		return this.entityManager.find(MessageSourceDTO.class, id);
	}
	public String getDefaultMessageByCode(String code) {
		String sql = "SELECT msg FROM MessageSourceDTO msg WHERE msg.code = :code ";
		Query query= entityManager.createQuery(sql, MessageSourceDTO.class);
		MessageSourceDTO msg = (MessageSourceDTO) query.setParameter("code", code).getSingleResult();
		return msg.getDefaultMessage();
		 
	}
	@Override
	public MessageSourceDTO getMessageSourceByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageSourceLangDTO getMessageSourceLangByID(Long id) {
		return this.entityManager.find(MessageSourceLangDTO.class, id);
	}

	@Override
	public Map<String, String> getMessagesByCode(Locale code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMessagesByLocale(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageByCodeAndLocale(String code, Locale locale) {
		String msg = "";
		
		String sql = "SELECT new MessageSourceInfo( msl.messageSource.code, msl.messageSource.defaultMessage, msl.message)  FROM  MessageSourceLangDTO msl ";
		sql += "WHERE msl.messageSource.code = :code AND msl.language.code = :langCode";
		Query query= entityManager.createQuery(sql);
		query.setParameter("code", code).setParameter("langCode", locale.getLanguage());
		
		try {
			MessageSourceInfo result = (MessageSourceInfo)query.getSingleResult();
			if (result != null) {
				msg = result.getDisplayMessage();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
