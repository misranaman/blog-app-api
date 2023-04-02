package com.org.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
