package pl.dmcs.zai.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.zai.domain.Comment;
import pl.dmcs.zai.domain.Notification;

public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	
	public List<Comment> selectCommentByNotification(Notification notification){
		return commentRepository.selectCommentByNotification(notification);
		
	}

	public Comment saveComment(Comment comment){
		return commentRepository.save(comment);
		
	}
	
}
