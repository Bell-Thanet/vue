package com.cpe.backend.registercompany.entity;

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
@Table(name="Type")
public class Type {
	@Id
	@SequenceGenerator(name="Type_seq",sequenceName="Type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Type_seq")
	@Column(name="Type_ID",unique = true, nullable = true)
	private @NonNull Long id;

	private @NonNull String type;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	// mappedBy  = "type"
	private Collection<Company> register;

	public void setName(String name) {
		this.type = name;
	}


}
