package pl.dmcs.zai.service;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.dmcs.zai.dao.UsufructuaryRepository;
import pl.dmcs.zai.domain.Usufructuary;

public class UsufructuaryService implements UserDetailsService {

	@Autowired
	private UsufructuaryRepository usufructuaryRepository;
	
	private static final Logger log = LoggerFactory.getLogger(UsufructuaryService.class);
	
	@PostConstruct	
	protected void initialize() {
		Usufructuary user = new Usufructuary("KrzysztofTumicki27@gmail.com", "admin","Krzysztof","Tumicki","603325711", "ROLE_ADMIN");
		usufructuaryRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usufructuary usufructuary = usufructuaryRepository.findByEmail(username);
		if(usufructuary == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(usufructuary);
	}
	
	public void signin(Usufructuary usufructuary) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(usufructuary));
	}
	
	private Authentication authenticate(Usufructuary usufructuary) {
		return new UsernamePasswordAuthenticationToken(createUser(usufructuary), null, Collections.singleton(createAuthority(usufructuary)));		
	}
	
	private User createUser(Usufructuary usufructuary) {
		return new User(usufructuary.getEmail(), usufructuary.getPassword(), Collections.singleton(createAuthority(usufructuary)));
	}

	private GrantedAuthority createAuthority(Usufructuary usufructuary) {
		return new SimpleGrantedAuthority(usufructuary.getTypeUser());
	}
}
