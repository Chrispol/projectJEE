package pl.dmcs.zai.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.zai.domain.Dictionary;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Usufructuary;

public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	


	public void setNotificationRepository(
			NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}



	public void addNotification(Notification notification) {
		notificationRepository.save(notification);
	}
	
	public List<Notification> allNotification() {
		
		return notificationRepository.selectAllNotifications();	
	}

	public List<Notification> selectNotificationsByUser( Usufructuary user) {
		return notificationRepository.selectNotificationsByUser(user);
	}

	
	
	public List<Notification> selectFilteredNotifications(Notification notification) {
		
		return notificationRepository.selectFilteredNotifications(notification);	
	}
	
	public Notification findById(Long id){
		return notificationRepository.findById(id);
	}
	

}
