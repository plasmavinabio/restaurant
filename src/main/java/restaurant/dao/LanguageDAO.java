package restaurant.dao;

import java.util.List;

import restaurant.dto.LanguageDTO;

public interface LanguageDAO {
	LanguageDTO getByID(Long id);
	LanguageDTO getByCode(String code);
	LanguageDTO getDefault();
	List<LanguageDTO> getAllLanguage();
	List<LanguageDTO> getActiveLanguage();
	boolean add(LanguageDTO language);
	boolean update(LanguageDTO language);
	boolean delete(LanguageDTO language);
	boolean languageCodeIsValidated(String code);
	boolean localeCodeIsValidated(String code);
}
