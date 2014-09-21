package pl.dmcs.zai.dictionary;

import java.util.Arrays;
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

import pl.dmcs.zai.support.web.MessageHelper;

@Controller
public class DictionaryController {

	private static final Logger log = LoggerFactory.getLogger(DictionaryController.class);
	
	@Autowired
	private DictionaryService dictionaryService;
	
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@RequestMapping(value = "addvalue")
	public DictionaryForm addvalue() {
		return new DictionaryForm();
	}
	
	@ModelAttribute("typeList")
    public List<EnumDictionaryType> typeList()
    {
		log.debug("modelatribute");
		log.debug("lista:" + Arrays.asList(EnumDictionaryType.values()));
        return Arrays.asList(EnumDictionaryType.values());
    }
	
	
	
	@RequestMapping(value = "addvalue", method = RequestMethod.POST)
	public String addvalue(@Valid @ModelAttribute DictionaryForm dictionaryForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return null;
		}
		
		dictionaryService.chooseParent(dictionaryForm.createDictionary());
	
        MessageHelper.addSuccessAttribute(ra, "Dodano wartośc słownikową.");
		
		return "redirect:/";
	}

}
