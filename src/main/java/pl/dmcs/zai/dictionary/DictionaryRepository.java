package pl.dmcs.zai.dictionary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Dictionary;


@Repository
@Transactional(readOnly = true)
public class DictionaryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
private static final Logger LOG = LoggerFactory.getLogger(UsufructuaryRepository.class);
	
	@Transactional
	public Dictionary save(Dictionary dictionary) {
		entityManager.persist(dictionary);
		LOG.debug("Save dictionary value");
		return dictionary;
	}
	
	
	
	
}
