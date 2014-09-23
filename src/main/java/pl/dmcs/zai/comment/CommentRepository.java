package pl.dmcs.zai.comment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.domain.Comment;
import pl.dmcs.zai.domain.Notification;

@Repository
@Transactional(readOnly = true)
public class CommentRepository {

	private static final Logger LOG = LoggerFactory.getLogger(CommentRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Comment save(Comment comment) {
		entityManager.persist(comment);
		LOG.debug("Save comment");
		return comment;
	}
	
	public List<Comment> selectCommentByNotification(Notification notification) {
		
		try {
			LOG.debug("selectDictionaryByParent");
			return entityManager.createNamedQuery(Comment.SELECT_BY_NOTIFICATION, Comment.class)
					.setParameter("notification", notification)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	
}

	
	
	
	