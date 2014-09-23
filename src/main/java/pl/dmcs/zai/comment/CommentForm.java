package pl.dmcs.zai.comment;

import java.util.Date;

import pl.dmcs.zai.domain.Comment;
import pl.dmcs.zai.domain.Notification;

public class CommentForm {
	
	private String content;
	private Date date;
	private Long notificationId;
		
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
	
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public Comment createComment() {
		
		return new Comment(getContent(), new Date(), new Notification(notificationId));
	}
}
