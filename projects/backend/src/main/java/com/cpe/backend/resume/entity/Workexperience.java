package com.cpe.backend.resume.entity;
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
@Table(name="WORKEXPERIENCE")
public class Workexperience {
    @Id
    @SequenceGenerator(name="WORKEXPERIENCE_SEQ",sequenceName="WORKEXPERIENCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="WORKEXPERIENCE_SEQ")
    @Column(name="WORKEXPERIENCE_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String timework;
	

    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "workexperience"
    private Collection<Resume> re;

    public void setName(String name) {
        this.timework = name;
    }
    
}