package pl.dmcs.zai.comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Comment;

@Repository
@Transactional(readOnly = true)
public class CommentRepository {

	private static final Logger LOG = LoggerFactory.getLogger(UsufructuaryRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Comment save(Comment comment) {
		entityManager.persist(comment);
		LOG.debug("Save comment");
		return comment;
	}
}

	
	
	
	