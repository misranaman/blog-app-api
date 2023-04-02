package com.org.blog.services;

import java.util.List;

import com.org.blog.payloads.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto userDto);

	UserDto createUser(UserDto user);

	UserDto getUserById(Integer id);

	UserDto updateUser(UserDto user, Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}
