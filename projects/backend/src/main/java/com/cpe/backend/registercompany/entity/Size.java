package com.cpe.backend.registercompany.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Entity
@NoArgsConstructor
@Table(name="Size")
public class Size {
	@Id
	@SequenceGenerator(name="Size_seq",sequenceName="Size_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Size_seq")
	@Column(name="Size_ID",unique = true, nullable = true)
	private @NonNull Long id;

	private @NonNull String size;
    
 
	@OneToMany(fetch = FetchType.EAGER)
	//mappedBy  = "size"
	private Collection<Company> register;

	public void setName(String name) {
		this.size = name;
	}
}