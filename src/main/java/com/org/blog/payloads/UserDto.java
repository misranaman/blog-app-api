package com.org.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.org.blog.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	@NotNull
	@Size(min = 4, message = "username must be minimum four characters")
	private String name;

	@Email(message = "Email address is not valid")
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be between 3 to 10 chars")
	private String password;

	@NotNull
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
