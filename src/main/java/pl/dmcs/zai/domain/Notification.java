package pl.dmcs.zai.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
	@SequenceGenerator(name = "Notification_SEQUENCE", sequenceName = "Notification_seq")
	@GeneratedValue(generator = "Notification_SEQUENCE")
	private Long id;
	
	@Column(length = 300)
	private String shortDescription;
	
	@Column(length = 120)
	private String name;
	
	@ManyToOne
	Category category;
	
	@ManyToOne
	Priority priority;
	
	@ManyToOne
	Status status;
	
	@ManyToOne
	Subcategory subcategory;
	
	@ManyToOne
	Type type;
	
	@ManyToOne
	Usufructuary user;
	
	protected Notification(){
		
	}
	
	public Notification(String shortDescription, Category category,
			Priority priority, Status status, Subcategory subcategory, Type type) {
		super();
		this.shortDescription = shortDescription;
		this.category = category;
		this.priority = priority;
		this.status = status;
		this.subcategory = subcategory;
		this.type = type;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Usufructuary getUser() {
		return user;
	}

	public void setUser(Usufructuary user) {
		this.user = user;
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
