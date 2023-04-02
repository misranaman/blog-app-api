package com.org.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.blog.payloads.ApiResponse;
import com.org.blog.payloads.UserDto;
import com.org.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	// POST- create user
	// PUT- update user

	@Autowired
	private UserService userService;

	@PostMapping("/")
	private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);

	}

	@PutMapping("/{userId}")
	private ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {

		UserDto updatedDto = this.userService.updateUser(userDto, userId);

		return new ResponseEntity<UserDto>(updatedDto, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	private ResponseEntity<?> deleteUser(@PathVariable Integer userId) {

		this.userService.deleteUser(userId);

		return ResponseEntity.ok(new ApiResponse("User deleted successfully", true));

	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId) {

		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
