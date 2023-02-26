package me.jdickel.articleexplorer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends AbstractBaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

}
