package com.jwelifyhub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

    @Entity
	@Data
	@Table(name = "role")
	public class Role {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Role_id")
		private Integer id;
		
		@NotEmpty
	    @Column(name = "Name", unique = true, nullable = false)
	    private String name;
		
		@ManyToMany(mappedBy = "roles")
		private List<User> users;
	}

