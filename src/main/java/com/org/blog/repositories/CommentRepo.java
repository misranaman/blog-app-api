package com.org.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
