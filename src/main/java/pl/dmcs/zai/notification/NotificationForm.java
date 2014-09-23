package pl.dmcs.zai.notification;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.dmcs.zai.domain.Dictionary;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Usufructuary;

public class NotificationForm {

	private static final Logger LOG = LoggerFactory.getLogger(NotificationForm.class);
	
	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	private Long id;
	private String shortDescription;
	private String name;
	private Long category;
	private Long subcategory;
	private Long type;
	private Long status;
	private Long priority;
	private Long user;

	
	private Long oldType;
	private Long oldSubcategory;

	private Notification notificationDetails;

	
	private List<Notification> searchNotifications = new ArrayList<Notification>();
	
	
	public Notification createNotification() {
		LOG.debug("createNotification in NotificationForm:");
    	return new Notification(getShortDescription(), getName(), new Dictionary(getCategory()),
    			new Dictionary(getSubcategory()), new Dictionary(getType()), new Dictionary(getStatus()),
    			new Dictionary(getPriority()), new Usufructuary(getUser()));
	}

	
	
	
    public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Long subcategory) {
		this.subcategory = subcategory;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	


	public List<Notification> getSearchNotifications() {
		return searchNotifications;
	}



	public void setSearchNotifications(List<Notification> searchNotifications) {
		this.searchNotifications = searchNotifications;
	}
	
	
	






	public Long getOldType() {
		return oldType;
	}



	public void setOldType(Long oldType) {
		this.oldType = oldType;
	}



	public Long getOldSubcategory() {
		return oldSubcategory;
	}



	public void setOldSubcategory(Long oldSubcategory) {
		this.oldSubcategory = oldSubcategory;
	}


	
	
	

	public Notification getNotificationDetails() {
		return notificationDetails;
	}




	public void setNotificationDetails(Notification notificationDetails) {
		this.notificationDetails = notificationDetails;
	}




	@Override
	public String toString() {
		return "NotificationForm [id=" + id + ", shortDescription="
				+ shortDescription + ", name=" + name + ", category="
				+ category + ", subcategory=" + subcategory + ", type=" + type
				+ ", status=" + status + ", priority=" + priority + ", user="
				+ user + ", oldType=" + oldType + ", oldSubcategory="
				+ oldSubcategory + ", notificationDetails="
				+ notificationDetails + ", searchNotifications="
				+ searchNotifications + "]";
	}




	
	
}
