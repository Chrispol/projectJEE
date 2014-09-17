package pl.dmcs.zai.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dmcs.zai.domain.Usufructuary;

@Repository
@Transactional(readOnly = true)
public class UsufructuaryRepository  {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	private static final Logger log = LoggerFactory.getLogger(UsufructuaryRepository.class);
	
	@Transactional
	public Usufructuary save(Usufructuary usufructuary) {
		usufructuary.setPassword(passwordEncoder.encode(usufructuary.getPassword()));
		entityManager.persist(usufructuary);
		log.debug("Save usufructuary");
		return usufructuary;
	}
	
	public Usufructuary findByEmail(String email) {
		try {
			log.debug("findByEmail usufructuary");
			return entityManager.createNamedQuery(Usufructuary.FIND_BY_EMAIL, Usufructuary.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}	
}
