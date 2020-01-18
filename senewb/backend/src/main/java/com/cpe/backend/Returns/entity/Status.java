package com.cpe.backend.Returns.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;
import java.util.Set;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="Status")
public class Status {
	@Id
	@SequenceGenerator(name="Status_seq",sequenceName="Status_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Status_seq")
	
	// private @NonNull Long status_id;
	// private @NonNull String statuss;
	
	// @OneToMany(fetch = FetchType.EAGER)
	// // mappedBy  = "Status"
	// private Set<Returns> status;

	// public void setName(String status){
	// 	this.statuss = status;
	// }
	@NotNull
    @Email
    private String Email;


}
