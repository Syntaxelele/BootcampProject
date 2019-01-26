package bootcamp.project.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min = 2, max = 30)//TODO change to 6
    private String password;
	@NotNull
	@Column(name="role")
	@Max(3)
	@Min(1)
    private int role;	
	@NotNull
	@Column(name="email")
    private String email;
	
	public User()
	{
		
	}
	
	public User( @NotNull @Size(min = 2, max = 30) String name,
			@NotNull @Size(min = 2, max = 30) String lastname, @NotNull @Size(min = 2, max = 30) String username,
			@NotNull @Size(min = 6, max = 30) String password, @NotNull @Size(min = 1, max = 1) int role,
			@NotNull String email) {
		super();
	
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
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