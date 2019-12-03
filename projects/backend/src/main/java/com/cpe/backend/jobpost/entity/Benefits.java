package com.cpe.backend.jobpost.entity;

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
@Table(name="BENEFITS")
public class Benefits {
    @Id
    @SequenceGenerator(name="BENEFITS_SEQ",sequenceName="BENEFITS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BENEFITS_SEQ")
    @Column(name="BENEFITS_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String benefits;
    
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<JobPost> Post;
    
	public void setBenefits(String benefits) {
        this.benefits=benefits;
	}
}