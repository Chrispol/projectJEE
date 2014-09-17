package pl.dmcs.zai.notification;

import org.hibernate.validator.constraints.NotBlank;

import pl.dmcs.zai.domain.Category;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Priority;
import pl.dmcs.zai.domain.Status;
import pl.dmcs.zai.domain.Subcategory;
import pl.dmcs.zai.domain.Type;

public class NotificationForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

	private String shortDescription;

    @NotBlank(message = NotificationForm.NOT_BLANK_MESSAGE)
	private Category category;
    
    @NotBlank(message = NotificationForm.NOT_BLANK_MESSAGE)
    private Priority priority;
    
    @NotBlank(message = NotificationForm.NOT_BLANK_MESSAGE)
    private Status status;
    
    @NotBlank(message = NotificationForm.NOT_BLANK_MESSAGE)
    private Subcategory subcategory;
    
    @NotBlank(message = NotificationForm.NOT_BLANK_MESSAGE)
    private Type type;
	
    public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Notification createNotification() {
    	
    	return new Notification(getShortDescription(), getCategory(), getPriority(), getStatus(), getSubcategory(), getType());
    }
}
