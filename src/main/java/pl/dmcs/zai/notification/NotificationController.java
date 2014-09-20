package pl.dmcs.zai.notification;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Usufructuary;
import pl.dmcs.zai.support.web.MessageHelper;

@Controller
public class NotificationController {

	private static final Logger log = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private UsufructuaryRepository usufructuaryRepository;
	
	@ModelAttribute("selectallusers")
	public List<Usufructuary> selectallusers() {
		return usufructuaryRepository.selectAllUsers();
	}
	
	@RequestMapping(value = "addnotification")
	public NotificationForm addnotification() {
		log.debug("addnotification");
		return new NotificationForm();
		
	}
	
	@RequestMapping(value = "addnotification", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute NotificationForm notificationForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return null;
		}
		

        MessageHelper.addSuccessAttribute(ra, "Gratulujemy! Konto zostało założone pomyślnie.");
		
		return "redirect:/";
	}

	
}
