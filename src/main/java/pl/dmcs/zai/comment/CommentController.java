package pl.dmcs.zai.comment;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommentController {

	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@RequestMapping(value = "addcomment")
	public CommentForm addcomment() {
		return new CommentForm();
	}

	@RequestMapping(value = "addcomment", method = RequestMethod.POST)
	public String addcomment(@Valid @ModelAttribute CommentForm commentForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return null;
		}
	
        //MessageHelper.addSuccessAttribute(ra, "Dodano wartośc słownikową.");
		
		return "redirect:/";
	
	}
}
	

	
