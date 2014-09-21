package pl.dmcs.zai.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
	@SequenceGenerator(name = "notification_SEQUENCE", sequenceName = "notification_seq")
	@GeneratedValue(generator = "notification_SEQUENCE")
	@Column(name = "notification_id")
	private Long id;
	
	@Column(length = 300)
	private String shortDescription;
	
	@Column(length = 120)
	private String name;
	
	@Column(nullable = false)
	@JoinColumn(name = "category_id")
	private Long category_id;
	
	@Column(nullable = false)
	@JoinColumn(name = "subcategory_id")
	private Long subcategory_id;
	
	@Column(nullable = false)
	@JoinColumn(name = "type_id")
	private Long type_id;
	
	@Column(nullable = false)
	@JoinColumn(name = "status_id")
	private Long status_id;
	
	@Column(nullable = false)
	@JoinColumn(name = "priority_id")
	private Long priority_id;
	
	@ManyToOne
	Usufructuary user;
	
	protected Notification(){
		
	}
	

	public Notification(String shortDescription, String name, Long category_id,
			Long subcategory_id, Long type_id, Long status_id,
			Long priority_id) {
		super();
		this.shortDescription = shortDescription;
		this.name = name;
		this.category_id = category_id;
		this.subcategory_id = subcategory_id;
		this.type_id = type_id;
		this.status_id = status_id;
		this.priority_id = priority_id;
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Long getId() {
		return id;
	}

	public Usufructuary getUser() {
		return user;
	}

	public void setUser(Usufructuary user) {
		this.user = user;
	}
	
	
	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Long getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(Long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public Long getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(Long priority_id) {
		this.priority_id = priority_id;
	}

	@OneToMany(mappedBy = "notification")
	private List<Comment> commentList = new ArrayList<Comment>();

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
}
