package pl.dmcs.zai.notification;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.domain.Notification;

public class NotificationRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger log = LoggerFactory.getLogger(NotificationRepository.class);
	
	
	@Transactional
	public Notification save(Notification notification) {
		entityManager.persist(notification);
		log.debug("Save dictionary value");
		return notification;
	}
	
public List<Notification> selectAllNotifications() {
		
		try {
			log.debug("selectAllNotifications");
			return entityManager.createNamedQuery(Notification.SELECT_NOTIFICATIONS, Notification.class)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}	

	
}
