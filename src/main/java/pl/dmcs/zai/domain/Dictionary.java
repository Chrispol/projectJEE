package pl.dmcs.zai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.dmcs.zai.dictionary.DictionaryType.Type;

@Entity
@Table(name = "dictionary")
public class Dictionary {

	@Id
	@SequenceGenerator(name = "dictionary_SEQUENCE", sequenceName = "dictionary_seq")
	@GeneratedValue(generator = "dictionary_SEQUENCE")
	@Column(name = "dictionary_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Type type;
	
	@Column(nullable = true)
	private Long parent;
	
	public Dictionary(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
}
