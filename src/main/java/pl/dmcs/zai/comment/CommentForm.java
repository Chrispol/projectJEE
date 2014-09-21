package pl.dmcs.zai.comment;

import java.util.Date;

import pl.dmcs.zai.domain.Comment;

public class CommentForm {
	
	private String content;
	private Date date;
	
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
		this.date = new Date();
	}
	
	public Comment createComment() {
		
		return new Comment(getContent(), getDate());
	}
}
