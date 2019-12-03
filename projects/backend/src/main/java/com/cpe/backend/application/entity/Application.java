package com.cpe.backend.application.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.cpe.backend.registeruser.entity.User;
import com.cpe.backend.jobpost.entity.JobPost;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
@Data
@Entity
@NoArgsConstructor
@Table(name="APPLICATION")
public class Application {
    @Id
    @SequenceGenerator(name="APPLICATION_SEQ",sequenceName="APPLICATION_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPLICATION_SEQ")
    @Column(name="APPLICATION_ID",unique = true, nullable = true)
    private @NonNull Long id;
    @Column(name="CARDID")
    private @NonNull long cardId;
    @Column(name="INTRODUCTION")
    private @NonNull String introduction;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "User_ID", insertable = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = JobPost.class)
    @JoinColumn(name = "JOBPOST_ID", insertable = true)
    private JobPost post;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Source.class)
    @JoinColumn(name = "SOURCE_ID", insertable = true)
    private Source sourceType;

	public void setUser(User user) {
        this.user = user;
	}

        public void setJobPost(JobPost post) {
        this.post = post;
	}

	public void setSource(Source source) {
        this.sourceType = source;
	}

	public void setCardId(long cardId) {
        this.cardId = cardId;
	}

	public void setIntroduction(String introduction) {
        this.introduction = introduction;
	}

        

	
	
}