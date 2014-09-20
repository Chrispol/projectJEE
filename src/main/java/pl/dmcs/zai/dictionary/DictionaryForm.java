package pl.dmcs.zai.dictionary;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import pl.dmcs.zai.dictionary.DictionaryType.Type;

public class DictionaryForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = DictionaryForm.NOT_BLANK_MESSAGE)
	private String name;
    //private List<Type> typeList = Arrays.asList(DictionaryType.Type.values());
    private Type type;
    
	/*public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}*/

	
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
	
}
