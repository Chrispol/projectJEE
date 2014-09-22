package pl.dmcs.zai.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.dmcs.zai.domain.Notification;

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
	

}
