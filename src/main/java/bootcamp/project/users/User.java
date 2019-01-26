package bootcamp.project.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//test
@Entity
@Table(name="userTable")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_u")
	private long id_u;
	@NotNull
	@Column(name="name")
	@Size(min = 2, max = 30)
    private String name;
	@NotNull
	@Column(name="lastname")
	@Size(min = 2, max = 30)
    private String lastname;
	@NotNull
	@Column(name="username")
	@Size(min = 2, max = 30)
    private String username;
	@NotNull
	@Column(name="password")
	@Size(min = 6, max = 30)
    private char [] password;
	@NotNull
	@Column(name="role")
	@Size(min = 1, max = 1)
    private byte role;	
	@NotNull
	@Column(name="email")
    private String email;
	
	
	public long getId_u() {
		return id_u;
	}
	public void setId_u(long id_u) {
		this.id_u = id_u;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public byte getRole() {
		return role;
	}
	public void setRole(byte role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}