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
			return entityManager.createNamedQuery(Dictionary.SELECT_PRIORITY, Dictionary.class)
					.setParameter("priority", EnumDictionaryType.PRIORITY)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	public List<Dictionary> selectCategory() {
		
		try {
			LOG.debug("selectcategory dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_CATEGORY, Dictionary.class)
					.setParameter("category", EnumDictionaryType.CATEGORY)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
	public List<Dictionary> selectStatus() {
		
		try {
			LOG.debug("selectstatus dictionary");
			return entityManager.createNamedQuery(Dictionary.SELECT_STATUS, Dictionary.class)
					.setParameter("status", EnumDictionaryType.STATUS)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}	
	}
	
}
