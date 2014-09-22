package pl.dmcs.zai.dictionary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.domain.Dictionary;


@Repository
@Transactional(readOnly = true)
public class DictionaryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
private static final Logger LOG = LoggerFactory.getLogger(DictionaryRepository.class);
	
	@Transactional
	public Dictionary save(Dictionary dictionary) {
		entityManager.persist(dictionary);
		LOG.debug("Save dictionary value");
		return dictionary;
	}
	
	
	public List<Dictionary> selectPriority() {
		
		try {
			LOG.debug("selectpriority dictionary");
			LOG.debug("MyLOg:" + EnumDictionaryType.PRIORITY);
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_TYPE, Dictionary.class)
					.setParameter("dictionary", EnumDictionaryType.PRIORITY)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	public List<Dictionary> selectCategory() {
		
		try {
			LOG.debug("select all category dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_TYPE, Dictionary.class)
					.setParameter("dictionary", EnumDictionaryType.CATEGORY)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}

	public List<Dictionary> selectSubcategory() {
		
		try {
			LOG.debug("select all subcategory dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_TYPE, Dictionary.class)
					.setParameter("dictionary", EnumDictionaryType.SUBCATEGORY)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}

	public List<Dictionary> selectType() {
		
		try {
			LOG.debug("select all type dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_TYPE, Dictionary.class)
					.setParameter("dictionary", EnumDictionaryType.TYPE)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	
	public List<Dictionary> selectDictionaryByParent(Long dictionary) {
		
		try {
			LOG.debug("selectDictionaryByParent");
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_PARENT, Dictionary.class)
					.setParameter("paramParent", dictionary)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	
	public List<Dictionary> selectStatus() {
		
		try {
			LOG.debug("selectstatus dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_DICTIONARY_BY_TYPE, Dictionary.class)
					.setParameter("dictionary", EnumDictionaryType.STATUS)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}

	public Dictionary findById(Long id) {
		
		try {
			LOG.debug("select dictionary by id:"+id);
			return entityManager.find(Dictionary.class, id);
		} catch (PersistenceException e) {
			return null;
		}	
	}

	public Dictionary update(Dictionary dict, Long id) {
		
		try {
			LOG.debug("select dictionary by id:"+id);
			Dictionary d =  entityManager.find(Dictionary.class, id);
			d.setName(dict.getName());
			d.setType(dict.getType());
			d.setParent(dict.getParent());
			d= entityManager.merge(d);
			entityManager.flush();
			return d;
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	
}
