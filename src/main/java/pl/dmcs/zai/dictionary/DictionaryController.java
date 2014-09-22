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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dmcs.zai.domain.Dictionary;
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

	
	@RequestMapping(value = "categoriesList")	
	public DictionaryForm categoriesList() {
		return new DictionaryForm();
	}

	@RequestMapping(value = "subcategoriesList")	
	public DictionaryForm subcategoriesList() {
		return new DictionaryForm();
	}

	@RequestMapping(value = "typesList")	
	public DictionaryForm typesList() {
		return new DictionaryForm();
	}

	@RequestMapping(value = "prioritiesList")	
	public DictionaryForm prioritiesList() {
		return new DictionaryForm();
	}

	@RequestMapping(value = "statusesList")	
	public DictionaryForm statusesList() {
		return new DictionaryForm();
	}

	
	@ModelAttribute("dictionaryType")
    public List<EnumDictionaryType> dictionaryType()
    {
		log.debug("modelatribute");
		log.debug("lista:" + Arrays.asList(EnumDictionaryType.values()));
        return Arrays.asList(EnumDictionaryType.values());
    }

	@ModelAttribute("categoryList")
    public List<Dictionary> categoryList()
    {
		return dictionaryService.searchAllCategories();
    }

	@ModelAttribute("subcategoryList")
    public List<Dictionary> subcategoryList()
    {
		return dictionaryService.searchAllSubcategories();
    }
	
	@ModelAttribute("typeList")
    public List<Dictionary> typeList()
    {
		return dictionaryService.searchAllTypes();
    }

	@ModelAttribute("priorityList")
    public List<Dictionary> priorityList()
    {
		return dictionaryService.searchAllPriorities();
    }

	@ModelAttribute("statusList")
    public List<Dictionary> statusList()
    {
		return dictionaryService.searchAllStatuses();
    }

	
/*	@ModelAttribute("subcategories")
    public List<Dictionary> subcategoryList()
    {
		log.debug("subcategoryList - category:");
        return dictionaryService.searchDictionariesByParent(0l);
    }
	
*/	
	
	
	@RequestMapping(value = "addvalue", method = RequestMethod.POST)
	public String addvalue(@Valid @ModelAttribute DictionaryForm dictionaryForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			log.info(errors.toString());
			return null;
		}
		log.info("dictionaryForm.getType().name():"+dictionaryForm.getDictionaryType().name());
		dictionaryService.addDictionaryValue(dictionaryForm.createDictionary());
        MessageHelper.addSuccessAttribute(ra, "Dodano wartośc słownikową.");
		return "redirect:/";
	}


	@RequestMapping(value = "editvalue", method = RequestMethod.POST)
	public String editvalue(@Valid @ModelAttribute DictionaryForm dictionaryForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			log.info(errors.toString());
			return null;
		}
		log.info("editvalue - dictionaryForm:"+dictionaryForm);		
		if(dictionaryForm.getDictionaryType() == null && dictionaryForm.getDictionaryTypeString() != null){
			dictionaryForm.setDictionaryType(EnumDictionaryType.valueOf(dictionaryForm.getDictionaryTypeString()));
		}
		log.info("editvalue - dictionaryForm - aft:"+dictionaryForm);		
		Dictionary toSave = dictionaryForm.createDictionary();
		dictionaryService.updateDictionaryValue(toSave, dictionaryForm.getId());
        MessageHelper.addSuccessAttribute(ra, "Zaktualizowano wartośc słownikową o id:"+dictionaryForm.getId());
		return "redirect:/"+dictionaryForm.getDictionaryType().getListContext();
	}
	
	
	@RequestMapping(value = "/delvalue", method = RequestMethod.POST)
	public	String delValue(@RequestParam(value = "categoryId", required = true) Long categoryId) {
		log.info("del category for categoryId" + categoryId);
		return "redirect:/categoriesList";
	}


	@RequestMapping(value = "/editvalue", method = RequestMethod.GET)
	public 	DictionaryForm editvalue(@RequestParam(value = "id", required = true) Long id) {
		log.info("editvalue for category " + id);
		Dictionary dict = dictionaryService.findById(id);
		log.info("editvalue- get - dict:"+dict);
		DictionaryForm dictForm = new DictionaryForm();
		dictForm.setId(dict.getId());
		dictForm.setName(dict.getName());
		dictForm.setDictionaryType(dict.getType());
		dictForm.setDictionaryTypeString(dict.getType().name());		
		dictForm.setParentId(dict.getParent());
		if(EnumDictionaryType.SUBCATEGORY.equals(dict.getType())){
			dictForm.setOldCategory(dictionaryService.findById(dict.getParent()).getId());
		}
		if(EnumDictionaryType.TYPE.equals(dict.getType())){
			Dictionary subcategory = dictionaryService.findById(dict.getParent());
			dictForm.setOldSubcategory(subcategory.getId());
			dictForm.setOldCategory(dictionaryService.findById(subcategory.getParent()).getId());
		}

		log.info("editvalue- get - dictForm:"+dictForm);

		return dictForm;
		
	}
	

	
	
	@RequestMapping(value = "/subcategories", method = RequestMethod.GET)
	public @ResponseBody
	List<Dictionary> subcategoriesList(
			@RequestParam(value = "categoryName", required = true) Long category) {
		log.info("finding subcategories for category " + category);
		return dictionaryService.searchDictionariesByParent(category);
	}


	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody
	List<Dictionary> categories() {
		log.info("finding all categories");
		return dictionaryService.searchAllCategories();
	}
	
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public @ResponseBody
	List<Dictionary> types(
			@RequestParam(value = "subcategoryId", required = true) Long id) {
		log.info("finding types for subcategory " + id);
		return dictionaryService.searchDictionariesByParent(id);
	}
	
	

}
