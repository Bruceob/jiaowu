package com.jiaowu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * Score entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="score"
    ,catalog="ssh_score"
)

public class Score  implements java.io.Serializable {


    // Fields    

     private Integer scoreid;
     private  Subject subject;
     private String filepath;

	private User user;
     private Integer score;


    // Constructors

    /** default constructor */
    public Score() {
    }

    
    /** full constructor */
    public Score(Subject subject, User user, Integer score,String filepath) {
        this.subject = subject;
        this.user = user;
        this.score = score;
        this.filepath = filepath;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="scoreid", unique=true, nullable=false)

    public Integer getScoreid() {
        return this.scoreid;
    }
    
    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="subject")

    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="user")

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="score")

    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    @Column(name="filepath", length=32)
    public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}








}