package pl.dmcs.zai.comment;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Comment;
import pl.dmcs.zai.domain.Notification;
import pl.dmcs.zai.domain.Usufructuary;
import pl.dmcs.zai.notification.NotificationForm;
import pl.dmcs.zai.support.web.MessageHelper;

@Controller
public class CommentController {

	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	
	@Autowired
	CommentService commentService;

	@Autowired
	UsufructuaryRepository usufructuaryRepository;
	

	@RequestMapping(value = "addcomment", method = RequestMethod.POST)
	public String addcomment(@Valid @ModelAttribute CommentForm commentForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return null;
		}
		Usufructuary user;
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails){
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			user = usufructuaryRepository.findByEmail(userDetails.getUsername());
		}else{
			user = new Usufructuary(-1l);
		}
		
		log.info("userDetails:"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		MessageHelper.addSuccessAttribute(ra, "Dodano komentarz do zgloszenia o id:"+ commentForm.getNotificationId());
		Comment comment = commentForm.createComment();
		comment.setUser(user);
		commentService.saveComment(comment);
		return null;
	}
	
	@RequestMapping(value = "/addcomment", method = RequestMethod.GET)
	public 	CommentForm addcomment(@RequestParam(value = "id", required = true) Long id) {
		log.info("Add comment to notification with id:" + id);
		CommentForm commentForm = new CommentForm();
		commentForm.setNotificationId(id);;
		log.info("addcomment- get - commentForm:"+commentForm);

		return commentForm;
		
	}
	
}
	

	
