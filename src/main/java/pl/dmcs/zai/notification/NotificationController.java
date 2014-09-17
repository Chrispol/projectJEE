package pl.dmcs.zai.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotificationController {

	@RequestMapping(value = "addNotification")
	public void addNotification() {}
	
}
