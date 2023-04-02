package com.org.blog.payloads;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;

	@Size(min = 10, max = 65)
	private String categoryTitle;

	private String categoryDescription;

}
