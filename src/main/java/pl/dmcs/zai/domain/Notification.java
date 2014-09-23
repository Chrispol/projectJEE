package pl.dmcs.zai.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "notification")
@NamedQueries({
@NamedQuery(name = Notification.SELECT_NOTIFICATIONS, query = "select a from Notification a"),
@NamedQuery(name = Notification.SELECT_NOTIFICATIONS_BY_USER, query = "select a from Notification a where a.user=:user")
})
public class Notification {

	/*public static final String FIND_BY_EMAIL = "Notification.findByEmail";
	public static final String SELECT_ALL_USERS = "Notification.SelectAllUsers";*/

	public static final String SELECT_NOTIFICATIONS = "Notification.selectAllNotification";
	public static final String SELECT_NOTIFICATIONS_BY_USER = "Notification.selectNotificationByUser";
	private static final Logger LOG = LoggerFactory.getLogger(Notification.class);
		
	@Id
	@SequenceGenerator(name = "notification_SEQUENCE", sequenceName = "notification_seq")
	@GeneratedValue(generator = "notification_SEQUENCE")
	@Column(name = "notification_id")
	private Long id;
	
	@Column(length = 300)
	private String shortDescription;
	
	@Column(length = 120)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Dictionary category_id;
	
	@ManyToOne
	@JoinColumn(name = "subcategory_id", nullable = false)
	private Dictionary subcategory_id;
	
	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private Dictionary type_id;
	
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Dictionary status_id;
	
	@ManyToOne
	@JoinColumn(name = "priority_id", nullable = false)
	private Dictionary priority_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	Usufructuary user;
	
	protected Notification(){
		super();
	}

	
	public Notification(Long id){
		super();
		this.id=id;
	}

	
	public Notification(String shortDescription, String name,
			Dictionary category_id, Dictionary subcategory_id,
			Dictionary type_id, Dictionary status_id, Dictionary priority_id,
			Usufructuary user) {
		super();

		this.shortDescription = shortDescription;
		this.name = name;
		this.category_id = category_id;
		this.subcategory_id = subcategory_id;
		this.type_id = type_id;
		this.status_id = status_id;
		this.priority_id = priority_id;
		this.user = user;
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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "notification", fetch = FetchType.LAZY)
	private List<Comment> commentList = new ArrayList<Comment>();

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Dictionary getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Dictionary category_id) {
		this.category_id = category_id;
	}

	public Dictionary getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(Dictionary subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public Dictionary getType_id() {
		return type_id;
	}

	public void setType_id(Dictionary type_id) {
		this.type_id = type_id;
	}

	public Dictionary getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Dictionary status_id) {
		this.status_id = status_id;
	}

	public Dictionary getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(Dictionary priority_id) {
		this.priority_id = priority_id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
