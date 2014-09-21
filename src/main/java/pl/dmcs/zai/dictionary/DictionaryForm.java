package pl.dmcs.zai.dictionary;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.dmcs.zai.domain.Dictionary;

public class DictionaryForm {

	private static final Logger LOG = LoggerFactory.getLogger(DictionaryForm.class);
	
	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = DictionaryForm.NOT_BLANK_MESSAGE)
	private String name;
    
    private EnumDictionaryType type;
    
	public EnumDictionaryType getType() {
		return type;
	}

	public void setType(EnumDictionaryType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Dictionary createDictionary() {
		LOG.debug("createDictionary in DictionaryForm");
		return new Dictionary(getName(), getType());
	}
	
}
