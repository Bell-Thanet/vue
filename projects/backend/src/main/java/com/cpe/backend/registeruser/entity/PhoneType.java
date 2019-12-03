package com.cpe.backend.registeruser.entity;
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
@Table(name="PhoneType")
public class PhoneType {
	@Id
	@SequenceGenerator(name="PhoneType_seq",sequenceName="PhoneType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PhoneType_seq")
	@Column(name="PhoneType_ID",unique = true, nullable = true)
	private @NonNull Long id;

	private @NonNull String phonetype;
    
 
	@OneToMany(fetch = FetchType.EAGER)
	//mappedBy  = "phonetype"
	private Collection<User> register;

	public void setName(String name) {
		this.phonetype = name;
	}
}