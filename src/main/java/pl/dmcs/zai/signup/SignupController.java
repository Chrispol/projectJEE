package pl.dmcs.zai.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Usufructuary;
import pl.dmcs.zai.service.UsufructuaryService;
import pl.dmcs.zai.support.web.MessageHelper;

@Controller
public class SignupController {
	
	@Autowired
	private UsufructuaryRepository usufructuaryRepository;
	
	@Autowired
	private UsufructuaryService usufructuaryService;
	
	@RequestMapping(value = "signup")
	public SignupForm signup() {
		return new SignupForm();
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return null;
		}
		
		Usufructuary usufructuary = usufructuaryRepository.save(signupForm.createUsufructuary());
		usufructuaryService.signin(usufructuary);

        MessageHelper.addSuccessAttribute(ra, "Gratulujemy! Konto zostało założone pomyślnie.");
		
		return "redirect:/";
	}
}
