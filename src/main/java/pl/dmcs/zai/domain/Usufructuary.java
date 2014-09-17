package pl.dmcs.zai.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@Entity
@Table(name = "usufructuary")
@NamedQuery(name = Usufructuary.FIND_BY_EMAIL, query = "select a from Usufructuary a where a.email = :email")
public class Usufructuary implements java.io.Serializable{

	public static final String FIND_BY_EMAIL = "Usufructuary.findByEmail";
	private static final Logger LOG = LoggerFactory.getLogger(Usufructuary.class);
	
	@Id
	@SequenceGenerator(name = "users_SEQUENCE", sequenceName = "users_id_seq" )
	@GeneratedValue(generator = "users_SEQUENCE" )
	@Column(name = "user_id")  
	private Long id;
	
	/*@Formula ("name||' '||surname")
	String Label;*/
	
	/*private boolean aktywny = true;
	
	private boolean admin = true;
*/
	@Column(length = 64, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(length = 128,nullable = false)
	private String password;
	
	@Column(length = 25, nullable = false)
	private String name;
	
	@Column(length = 25, nullable = false)
	private String surname;
	
	@Column(length = 15, nullable = false)
	private String phoneNumber;
	
	private String typeUser = "ROLE_USER";

    protected Usufructuary() {

	}
	
	public Usufructuary(String email, String password, String name,String surname,String phoneNumber,String typeUser) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.typeUser = typeUser;		
	}	

	/*public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}*/

/*	public boolean isAktywny() {
		return aktywny;
	}

	public void setAktywny(boolean aktywny) {
		this.aktywny = aktywny;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

*/	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "user")
	private List<Notification> notificationList = new ArrayList<Notification>();

	public List<Notification> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<Notification> notificationList) {
		this.notificationList = notificationList;
	}
	
	@OneToMany(mappedBy = "user")
	private List<Comment> commentList = new ArrayList<Comment>();

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
