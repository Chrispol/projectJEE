package pl.dmcs.zai.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@SequenceGenerator(name = "Comment_SEQUENCE", sequenceName = "Comment_seq")
	@GeneratedValue(generator = "Comment_SEQUENCE")
	private Long id;
	
	@Column(length = 150)
	private String content;
	private Date date;
	
	@ManyToOne
	private Notification notification;
	
	@ManyToOne
	Usufructuary user;

	public Comment() { }

	public Comment(String content, Date date) {
		super();
		this.content = content;
		this.date = date;
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
