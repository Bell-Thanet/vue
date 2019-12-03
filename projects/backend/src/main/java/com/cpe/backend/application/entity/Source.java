package com.cpe.backend.application.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import java.util.Collection;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
@Data
@Entity
@NoArgsConstructor
@Table(name="SOURCE")
public class Source {
    @Id
    @SequenceGenerator(name="SOURCE_SEQ",sequenceName="SOURCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SOURCE_SEQ")
    @Column(name = "SOURCE_ID", unique = true, nullable = true)
    private @NonNull Long id;
   
    private @NonNull String sourceType;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Application> application;

	public void setName(String name) {
        this.sourceType = name;
	}

}
