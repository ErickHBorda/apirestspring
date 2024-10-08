package com.iis.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import lombok.Setter;

@Entity
@Table(name = "tuser1")
@Getter
@Setter
public class TUser implements Serializable {
	@Id
	@Column(name = "idUser")
	private String idUser;

	@Column(name = "nameUser")
	private String nameUser;

	@Column(name = "password")
	private String password;

    @Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "updatedAt")
	private Date updatedAt;
}
