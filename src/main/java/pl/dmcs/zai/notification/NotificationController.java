package pl.dmcs.zai.notification;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.signup.SignupForm;
import pl.dmcs.zai.support.web.MessageHelper;

@Controller
public class NotificationController {

	@RequestMapping(value = "addnotification")
	public NotificationForm addnotification() {
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
