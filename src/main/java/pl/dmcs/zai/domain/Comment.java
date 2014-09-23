package pl.dmcs.zai.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name = "comment")
@NamedQueries({
	@NamedQuery(name = Comment.SELECT_BY_NOTIFICATION, query = "select c from Comment c where c.notification = :notification"),
	})
public class Comment {

	
	public static final String SELECT_BY_NOTIFICATION = "Comment.selectByNotification";
	
	@Id
	@SequenceGenerator(name = "comment_SEQUENCE", sequenceName = "comment_seq")
	@GeneratedValue(generator = "comment_SEQUENCE")
	@Column(name = "comment_id")
	private Long id;
	
	@Column(length = 150)
	private String content;
	
	/** Data wpływu/wyjścia interakcji */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "notification_id", nullable = false)
	private Notification notification;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	Usufructuary user;

	public Comment() { }

	public Comment(String content, Date date, Notification notification) {
		super();
		this.content = content;
		this.date = date;
		this.notification = notification;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Usufructuary getUser() {
		return user;
	}

	public void setUser(Usufructuary user) {
		this.user = user;
	}	
}
