package pl.dmcs.zai.dictionary;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.dmcs.zai.domain.Dictionary;

public class DictionaryForm {

	private static final Logger LOG = LoggerFactory.getLogger(DictionaryForm.class);
	
	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	private Long id;

	@NotBlank(message = DictionaryForm.NOT_BLANK_MESSAGE)
	private String name;
    
    private EnumDictionaryType dictionaryType;


    private Long category;

    private Long subcategory;


	
	public Dictionary createDictionary() {
		LOG.debug("createDictionary in DictionaryForm - dictionaryType:"+dictionaryType);
			switch (dictionaryType) {
			  case SUBCATEGORY:
			    {
			    	return new Dictionary(getName(), getDictionaryType(), category);
			    	}
			  case TYPE:
			    {
			    	return new Dictionary(getName(), getDictionaryType(), subcategory);
			    	}

			  default:
					return new Dictionary(getName(), getDictionaryType());
			}			
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public EnumDictionaryType getDictionaryType() {
		return dictionaryType;
	}



	public void setDictionaryType(EnumDictionaryType dictionaryType) {
		this.dictionaryType = dictionaryType;
	}



	public Long getCategory() {
		return category;
	}



	public void setCategory(Long category) {
		this.category = category;
	}



	public Long getSubcategory() {
		return subcategory;
	}



	public void setSubcategory(Long subcategory) {
		this.subcategory = subcategory;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	
	
}
