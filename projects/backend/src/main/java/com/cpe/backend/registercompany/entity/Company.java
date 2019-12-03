package com.cpe.backend.registercompany.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpe.backend.jobpost.entity.JobPost;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="Company")
public class Company {

    @Id
    @SequenceGenerator(name="Company_seq",sequenceName="Company_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Company_seq")
    @Column(name = "Company_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="TimeRegister")
    private @NonNull Date TimeRegister;

    @Column(name="Name")
    private @NonNull String name;

    @Column(name="Pass")
    private @NonNull String pass;
    
    @Column(name="Email")
    private @NonNull String email;


  

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID", insertable = true)
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Size.class)
    @JoinColumn(name = "Size_ID", insertable = true)
    private Size size;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "Type_ID", insertable = true)
    private Type type;


	public void setType(Type type2) {
        this.type = type2;
	}

	public void setSize(Size size2) {
        this.size = size2;
	}
	public void setProvince(Province province2) {
        this.province = province2;
    }
	public void setTimeRegister(Date date) {
        this.TimeRegister = date;
	}

	public void setCompany(String name) {
                this.name=name;
        }
        public void setName(String name) {
                this.name=name;
	}

	public void setEmail(String email2) {
                this.email=email2;
	}

		public void setPass(String pass2) {
                this.pass = pass2;
                }
                
}