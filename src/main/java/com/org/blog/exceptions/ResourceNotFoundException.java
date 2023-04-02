package com.org.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldVlue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldVlue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldVlue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldVlue = fieldVlue;
	}

}
