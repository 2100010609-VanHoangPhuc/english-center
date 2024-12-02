package com.english_center.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "posts")
public class Posts extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	private String content;

	@Column(name = "author_id")
	private int authorId;

	@Column(name = "category_blog_id")
	private int categoryBlogId;

	private String banner;

	private BigDecimal point;

	@Column(name = "count_rating")
	private long countRating;

	private int status;
}
