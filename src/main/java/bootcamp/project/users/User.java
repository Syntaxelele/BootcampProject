package bootcamp.project.users;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@Table(name = "userTable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_u", unique = true, nullable = false)
	protected long id_u;
	@NotNull
	@Column(name = "name")
	@Size(min = 2, max = 30)
	private String name;
	@NotNull
	@Column(name = "lastname")
	@Size(min = 2, max = 30)
	private String lastname;
	@NotNull
	@Column(name = "username", unique = true)
	@Size(min = 2, max = 30)
	private String username;
	@NotNull
	@Column(name = "password")
	@Size(min = 6, max = 30)
	private String password;
	@NotNull
	@Column(name = "role")
	@Max(3)
	@Min(1)
	private int role;
	@NotNull
	@Email
	@Column(name = "email", unique = true)
	private String email;

	public User() {
	}

	public User(@NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 2, max = 30) String lastname,
			@NotNull @Size(min = 2, max = 30) String username, @NotNull @Size(min = 6, max = 30) String password,
			@NotNull @Max(3) @Min(1) int role, @NotNull @Email String email) {
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
		String tempName = name;
		if (tempName.matches("[a-zA-Z]+")) {
			this.name = tempName;
		} else {
			this.name = "";
			System.out.println("Wrong input1");
		}
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		String tempLastname = lastname;
		if (tempLastname.matches("[a-zA-Z]+")) {
			this.lastname = tempLastname;
		} else {
			this.lastname = "";
			System.out.println("Wrong input2");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		String tempUsername = username;
		if (tempUsername.matches("[a-zA-Z0-9]+")) {
			this.username = tempUsername;
		} else {
			this.username = "";
			System.out.println("Wrong input3");
		}
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

	public void setRole(int role) {
		int tempRole = role;
		if (tempRole >= 1 && tempRole < 4) {
			this.role = tempRole;
		} else {
			this.role = 2;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}