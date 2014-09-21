package pl.dmcs.zai.dictionary;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.zai.domain.Dictionary;

public class DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;
	
	public void chooseParent(Dictionary dictionary) {
		
		switch(dictionary.getType().toString()) {
		
		case "Podkategoria":
			dictionary.setParent(new Long(1));
			
		case "Typ":
			dictionary.setParent(new Long(2));
			
		default:
			dictionary.setParent(null);
		}
		
		dictionaryRepository.save(dictionary);
	}
	
}
