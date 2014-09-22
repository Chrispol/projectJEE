package pl.dmcs.zai.dictionary;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Dictionary;
import pl.dmcs.zai.domain.Usufructuary;
import pl.dmcs.zai.service.UsufructuaryService;

public class DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;
	
	public void setDictionaryRepository(DictionaryRepository dictionaryRepository) {
		this.dictionaryRepository = dictionaryRepository;
	}
	
	@PostConstruct	
	protected void initialize() {
		dictionaryRepository.save(new Dictionary("wysoki", EnumDictionaryType.PRIORITY, null));
		dictionaryRepository.save(new Dictionary("niski",  EnumDictionaryType.PRIORITY, null));
		dictionaryRepository.save(new Dictionary("średni", EnumDictionaryType.PRIORITY, null));
		dictionaryRepository.save(new Dictionary("Serwis", EnumDictionaryType.CATEGORY, null));
		/*dictionaryRepository.save(new Dictionary(name, type, parent));
		dictionaryRepository.save(new Dictionary(name, type, parent));*/
		dictionaryRepository.save(new Dictionary("Screenpop", EnumDictionaryType.SUBCATEGORY , new Long(4)));
		dictionaryRepository.save(new Dictionary("Simplus", EnumDictionaryType.SUBCATEGORY , new Long(4)));
		dictionaryRepository.save(new Dictionary("MixPlus", EnumDictionaryType.SUBCATEGORY , new Long(4)));
		dictionaryRepository.save(new Dictionary("C1", EnumDictionaryType.TYPE, new Long(5)));
		dictionaryRepository.save(new Dictionary("C2", EnumDictionaryType.TYPE, new Long(6)));
		dictionaryRepository.save(new Dictionary("C3", EnumDictionaryType.TYPE, new Long(7)));
		dictionaryRepository.save(new Dictionary("Realizowane", EnumDictionaryType.STATUS, null));
		dictionaryRepository.save(new Dictionary("Zakończone", EnumDictionaryType.STATUS, null));
		dictionaryRepository.save(new Dictionary("Anulowane", EnumDictionaryType.STATUS, null));
	}

	public void addDictionaryValue(Dictionary dictionary) {
		dictionaryRepository.save(dictionary);
	}
	
	public List<Dictionary> searchAllCategories(){
		return dictionaryRepository.selectCategory();
	}
	
	public List<Dictionary> searchDictionariesByParent(Long dictionary){
		return dictionaryRepository.selectDictionaryByParent(dictionary);
	}
	
	public Dictionary findById(Long id){
		return dictionaryRepository.findById(id);
	}
	
}

