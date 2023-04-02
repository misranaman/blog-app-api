package com.org.blog.services;

import java.util.List;

import com.org.blog.payloads.PostDto;
import com.org.blog.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer postId, Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete post
	void deletePost(Integer postId);

	// get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get single post
	PostDto getPostById(Integer id);

	// get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);

	// get all post by users
	List<PostDto> getPostByUser(Integer userId);

	// get the search posts
	List<PostDto> searchPosts(String keyword);

}
