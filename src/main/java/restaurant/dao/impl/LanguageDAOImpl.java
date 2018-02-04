package restaurant.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restaurant.dao.LanguageDAO;
import restaurant.dto.LanguageDTO;

@Repository("languageDAO")
@Transactional
public class LanguageDAOImpl implements LanguageDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public LanguageDTO getByID(Long id) {
		return this.entityManager.find(LanguageDTO.class, id);
	}

	@Override
	public LanguageDTO getByCode(String code) {
		String sql = "SELECT l FROM " + LanguageDTO.class.getName() + " l WHERE l.code = :code";
		try {
			Object obj = entityManager.createQuery(sql).setParameter("code", code).getSingleResult();
			return (LanguageDTO)obj;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LanguageDTO getDefault() {
		String sql = "SELECT l FROM " + LanguageDTO.class.getName() + " l WHERE l.isDefault = 1";
		try {
			Object obj = entityManager.createQuery(sql).getSingleResult();
			return (LanguageDTO)obj;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<LanguageDTO> getAllLanguage() {
		List<LanguageDTO> languages = entityManager.createQuery("SELECT l FROM " + LanguageDTO.class.getName()).getResultList();
		return languages;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LanguageDTO> getActiveLanguage() {
		List<LanguageDTO> languages = entityManager.createQuery("SELECT l FROM " + LanguageDTO.class.getName() + " l WHERE l.active = 1").getResultList();
		return languages;
	}

	@Override
	public boolean add(LanguageDTO language) {
		try {
			entityManager.persist(language);
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(LanguageDTO language) {
		try {
			entityManager.persist(language);
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(LanguageDTO language) {
		try {
			entityManager.remove(language);
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean languageCodeIsValidated(String code) {
		LanguageDTO language = this.getByCode(code);
		return language != null && language.isActive();
	}

	@Override
	public boolean localeCodeIsValidated(String code) {
		String[] locales = Locale.getISOLanguages();
		return Arrays.asList(locales).contains(code);
	}

}
