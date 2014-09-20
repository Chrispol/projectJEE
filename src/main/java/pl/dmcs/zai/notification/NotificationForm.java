package pl.dmcs.zai.notification;

public class NotificationForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	private String shortDescription;
	private String name;
	private String category;
	private String subcategory;
	private String type;
	private String status;
	private String priority;
	
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	/*public Notification createNotification() {
    	
    	return new Notification();
    }*/
}
