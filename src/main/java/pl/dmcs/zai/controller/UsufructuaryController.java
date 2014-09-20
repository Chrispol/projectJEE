package pl.dmcs.zai.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.dictionary.DictionaryForm;
import pl.dmcs.zai.domain.Usufructuary;


@Controller
@Secured("ROLE_USER")
public class UsufructuaryController {

	private static final Logger LOG = LoggerFactory.getLogger(UsufructuaryController.class);
	
	@Autowired
	private UsufructuaryRepository usufructuaryRepository;
	
	@RequestMapping(value = "usufructuary/current", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Usufructuary usufructuary(UserDetails userDetails) {
		LOG.info(userDetails.toString());
		return usufructuaryRepository.findByEmail(userDetails.getUsername());
	}
}
