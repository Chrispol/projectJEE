package pl.dmcs.zai.home;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.comment.CommentForm;
import pl.dmcs.zai.comment.CommentService;
import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.dictionary.DictionaryForm;
import pl.dmcs.zai.dictionary.DictionaryRepository;
import pl.dmcs.zai.dictionary.DictionaryService;
import pl.dmcs.zai.dictionary.EnumDictionaryType;
import pl.dmcs.zai.domain.Dictionary;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Usufructuary;
import pl.dmcs.zai.notification.NotificationController;
import pl.dmcs.zai.notification.NotificationForm;
import pl.dmcs.zai.notification.NotificationService;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UsufructuaryRepository usufructuaryRepository;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal != null ? "redirect:/homeSignedIn" : "redirect:/homeNotSignedIn";
	}

	@RequestMapping(value = "/homeNotSignedIn", method = RequestMethod.GET)
	public NotificationForm homeNotSignedIn() {
		List<Notification> searchNotifications = notificationService.allNotification();
		NotificationForm form = new NotificationForm();
		form.setSearchNotifications(searchNotifications);
		log.info("size:"+form.getSearchNotifications().size());
		return form;
	}

	@RequestMapping(value = "/homeSignedIn", method = RequestMethod.GET)
	public NotificationForm homeSignedIn() {
		Usufructuary user;
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails){
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			user = usufructuaryRepository.findByEmail(userDetails.getUsername());
		}else{
			user = new Usufructuary(-1l);
		}

		List<Notification> searchNotifications = notificationService.selectNotificationsByUser(user);
		NotificationForm form = new NotificationForm();
		form.setSearchNotifications(searchNotifications);
		log.info("size:"+form.getSearchNotifications().size());
		return form;
	}
	

	@RequestMapping(value = "/homeNotSignedIn", method = RequestMethod.POST)
	public NotificationForm homeNotSignedInPost(@Valid @ModelAttribute NotificationForm notificationForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			log.info(errors.toString());
			return null;
		}
		log.info("homeNotSignedInPost:"+notificationForm);
		List<Notification> searchNotifications = notificationService.selectFilteredNotifications(notificationForm.createNotification());
		NotificationForm form = new NotificationForm();
		form.setSearchNotifications(searchNotifications);
		form.setName(notificationForm.getName());
		form.setCategory(notificationForm.getCategory());
		form.setSubcategory(notificationForm.getSubcategory());
		form.setType(notificationForm.getType());
		form.setPriority(notificationForm.getPriority());
		form.setStatus(notificationForm.getStatus());
		form.setOldType(notificationForm.getType());
		form.setOldSubcategory(notificationForm.getSubcategory());
		log.info("size:"+form.getSearchNotifications().size());
		return form;
	}
	
	
	@ModelAttribute("notificationList")
    public List<Notification> notificationList()
    {
		log.debug("notificationList HomeController");
		log.debug("lista:" + notificationService.allNotification().size());
        return notificationService.allNotification();
    }
	
	@ModelAttribute("selectcategory")
	public List<Dictionary> selectcategry() {
		return dictionaryService.searchAllCategories();
		
	}

	@ModelAttribute("selectallusers")
	public List<Usufructuary> selectallusers() {
		return usufructuaryRepository.selectAllUsers();
	}
	
	@ModelAttribute("selectpriority")
	public List<Dictionary> selectpriority() {
		return dictionaryService.searchAllPriorities();
		
	}
	
	@ModelAttribute("selectstatus")
	public List<Dictionary> selectstatus() {
		return dictionaryService.searchAllStatuses();		
	}
	
	
	@RequestMapping(value = "/shownotification", method = RequestMethod.GET)
	public 	NotificationForm shownotification(@RequestParam(value = "id", required = true) Long id) {
		log.info("editvalue for category " + id);
		Notification notyf = notificationService.findById(id);
//		notyf.setCommentList(commentService.selectCommentByNotification(new Notification(notyf.getId())));
		log.info("editvalue- get - notyf:"+notyf);
		NotificationForm dictForm = new NotificationForm();
/*		dictForm.setId(notyf.getId());
		dictForm.setName(notyf.getName());
		dictForm.setShortDescription(notyf.getShortDescription());
		dictForm.setCategory(notyf.getCategory_id());
		dictForm.setShortDescription(notyf.getShortDescription());
		dictForm.setShortDescription(notyf.getShortDescription());
		dictForm.setShortDescription(notyf.getShortDescription());
		dictForm.setShortDescription(notyf.getShortDescription());
		dictForm.setShortDescription(notyf.getShortDescription());
*/
		dictForm.setNotificationDetails(notyf);
		dictForm.setCommentList(commentService.selectCommentByNotification(new Notification(notyf.getId())));
		
		log.info("editvalue- get - dictForm:"+dictForm);

		return dictForm;
		
	}
	
}
