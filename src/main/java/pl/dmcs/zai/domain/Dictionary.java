package pl.dmcs.zai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Dictionary {

	@Id
	@SequenceGenerator(name = "Dictionary_SEQUENCE", sequenceName = "Dictionary_seq")
	@GeneratedValue(generator = "Dictionary_SEQUENCE")
	private Long id;
	
	private String name;
	
	@Column(nullable = true)
	private Long parent;
	
	protected Dictionary(){
		
	}
	
	public Dictionary(String name){
		
		this.name = name;	
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

}
