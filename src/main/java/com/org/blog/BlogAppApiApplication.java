package com.org.blog;

import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.org.blog.config.AppConstants;
import com.org.blog.entities.Role;
import com.org.blog.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApiApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("abc"));

		Role role = new Role();
		role.setId(AppConstants.ADMIN_USER);
		role.setName("ADMIN_USER");

		Role role1 = new Role();
		role1.setId(AppConstants.ADMIN_USER);
		role1.setName("ADMIN_USER");

		List<Role> roles = List.of(role, role1);

		List<Role> result = this.roleRepo.saveAll(roles);

		result.forEach(r -> {
			System.out.println(r.getName());
		});
	}

}