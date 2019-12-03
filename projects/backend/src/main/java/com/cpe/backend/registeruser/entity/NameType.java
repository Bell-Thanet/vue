package com.cpe.backend.registeruser.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="NameType")
public class NameType {
	@Id
	@SequenceGenerator(name="NameType_seq",sequenceName="NameType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="NameType_seq")
	@Column(name="NameType_ID",unique = true, nullable = true)
	private @NonNull Long id;

	private @NonNull String nametype;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	// mappedBy  = "nametype"
	private Collection<User> register;

	public void setName(String name) {
		this.nametype = name;
	}


}
