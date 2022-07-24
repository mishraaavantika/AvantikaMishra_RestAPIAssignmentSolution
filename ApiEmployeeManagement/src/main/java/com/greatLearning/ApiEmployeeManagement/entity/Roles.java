package com.greatLearning.ApiEmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.greatLearning.ApiEmployeeManagement.entity.Roles;

import lombok.Data;

@Entity
@Table(name = "ROLES")
@Data
public class Roles {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

}
