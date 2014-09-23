package pl.dmcs.zai.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.domain.Dictionary;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Usufructuary;

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

public List<Notification> selectNotificationsByUser( Usufructuary user) {
	
	try {
		log.debug("selectAllNotifications");
		return entityManager.createNamedQuery(Notification.SELECT_NOTIFICATIONS_BY_USER, Notification.class)
				.setParameter("user", user)
				.getResultList();
	} catch (PersistenceException e) {
		return null;
	}	
}	


public Notification findById(Long id) {
	
	try {
		log.debug("select notufication by id:"+id);
		Notification result = entityManager.find(Notification.class, id);
		return result;
	} catch (PersistenceException e) {
		return null;
	}	
}

public List<Notification> selectFilteredNotifications(Notification notification) {
	
/*	String name,
	Dictionary category_id, Dictionary subcategory_id,
	Dictionary type_id, Dictionary status_id, Dictionary priority_id,
	Usufructuary user)
*/	
	try {
		
		String queryString="SELECT ntf FROM Notification ntf";
		List<Map> list = new ArrayList<Map>();
		Map map;
		if(notification.getCategory_id() != null && notification.getCategory_id().getId()!=null  && notification.getCategory_id().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.category_id = :category_id");
			map.put("param_name", "category_id");
			map.put("param", notification.getCategory_id());
			list.add(map);
		}
		if(notification.getSubcategory_id() != null && notification.getSubcategory_id().getId()!=null && notification.getSubcategory_id().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.subcategory_id = :subcategory_id");
			map.put("param_name", "subcategory_id");
			map.put("param", notification.getSubcategory_id());
			list.add(map);
		}

		if(notification.getType_id() != null && notification.getType_id().getId()!=null && notification.getType_id().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.type_id = :type_id");
			map.put("param_name", "type_id");
			map.put("param", notification.getType_id());
			list.add(map);
		}
		
		if(notification.getStatus_id() != null && notification.getStatus_id().getId()!=null && notification.getStatus_id().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.status_id = :status_id");
			map.put("param_name", "status_id");
			map.put("param", notification.getStatus_id());
			list.add(map);
		}

		if(notification.getPriority_id() != null && notification.getPriority_id().getId()!=null && notification.getPriority_id().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.priority_id = :priority_id");
			map.put("param_name", "priority_id");
			map.put("param", notification.getPriority_id());
			list.add(map);
		}

		if(notification.getUser() != null && notification.getUser().getId()!=null && notification.getUser().getId()!=-1)
		{
			map = new HashMap();
			map.put("sql","ntf.user = :user");
			map.put("param_name", "user");
			map.put("param", notification.getUser());
			list.add(map);
		}
		
		if(notification.getName() != null && !notification.getName().isEmpty())
		{
			map = new HashMap();
			map.put("sql","ntf.name like :name");
			map.put("param_name", "name");
			map.put("param", "%" + notification.getName() + "%");
			list.add(map);
		}

		
		log.info("list:"+list);
		if(list.size()>0){
			queryString+= " WHERE ";
			for(int i=0; i<(list.size()-1);i++){
				queryString+=list.get(i).get("sql")+" AND ";
			}
			queryString+=list.get(list.size()-1).get("sql");
		}
		
		log.info("queryString:"+queryString);

		Query query = entityManager.createQuery(queryString, Notification.class);
		
		if(list.size()>0){
			for(int i=0; i<(list.size());i++){
				query.setParameter(list.get(i).get("param_name").toString(), list.get(i).get("param"));
				}
		}
		log.info("query.getParameters():"+query.getParameters().size());
		
		return query.getResultList();
	} catch (PersistenceException e) {
		return null;
	}	
}	




	
}
