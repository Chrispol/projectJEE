package pl.dmcs.zai.home;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.notification.NotificationController;
import pl.dmcs.zai.notification.NotificationService;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "homeSignedIn" : "homeNotSignedIn";
	}
	
	@ModelAttribute("notificationList")
    public List<Notification> notificationList()
    {
		log.debug("notificationList HomeController");
		log.debug("lista:" + notificationService.allNotification().size());
        return notificationService.allNotification();
    }
}
