package pl.dmcs.zai.dictionary;

import org.hibernate.validator.constraints.NotBlank;

import pl.dmcs.zai.dictionary.DictionaryType.Type;
import pl.dmcs.zai.domain.Dictionary;

public class DictionaryForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = DictionaryForm.NOT_BLANK_MESSAGE)
	private String name;
    
    private Type type;
    
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Dictionary createDictionary() {
		
		return new Dictionary(getName(), getType());
	}
	
}
