package pl.dmcs.zai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.dmcs.zai.dictionary.EnumDictionaryType;

@Entity
@Table(name = "dictionary")
@NamedQueries({
	@NamedQuery(name = Dictionary.SELECT_PRIORITY, query = "select a from Dictionary a where a.type = :priority"),
	@NamedQuery(name = Dictionary.SELECT_CATEGORY, query = "select a from Dictionary a where a.type = :category"),
	@NamedQuery(name = Dictionary.SELECT_STATUS, query = "select a from Dictionary a where a.type = :status")
	})
public class Dictionary {

	public static final String SELECT_PRIORITY = "Dictionary.selectPriority";
	public static final String SELECT_CATEGORY = "Dictionary.selectCategory";
	public static final String SELECT_STATUS = "Dictionary.selectStatus";
	private static final Logger LOG = LoggerFactory.getLogger(Dictionary.class);
	
	@Id
	@SequenceGenerator(name = "dictionary_SEQUENCE", sequenceName = "dictionary_seq")
	@GeneratedValue(generator = "dictionary_SEQUENCE")
	@Column(name = "dictionary_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumDictionaryType type;
	
	@Column(nullable = true)
	private Long parent;
	
	public Dictionary(String name, EnumDictionaryType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Dictionary(String name, EnumDictionaryType type, Long parent) {
		super();
		this.name = name;
		this.type = type;
		this.parent = parent;
	}

	protected Dictionary(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public EnumDictionaryType getType() {
		return type;
	}

	public void setType(EnumDictionaryType type) {
		this.type = type;
	}

	
}
