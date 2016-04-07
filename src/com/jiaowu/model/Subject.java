package com.jiaowu.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * Subject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="subject"
    ,catalog="ssh_score"
)

public class Subject  implements java.io.Serializable {


    // Fields    

     private Integer subjectid;
     private String subject;
     private String teacher;
   
  
	private Set<Score> scores = new HashSet<Score>(0);
     private Set<Score> scores_1 = new HashSet<Score>(0);


    // Constructors

    /** default constructor */
    public Subject() {
    }

    
    /** full constructor */
    public Subject(String subject, String teacher, Set<Score> scores, Set<Score> scores_1) {
        this.subject = subject;
        this.teacher = teacher;
       
        this.scores = scores;
        this.scores_1 = scores_1;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="subjectid", unique=true, nullable=false)

    public Integer getSubjectid() {
        return this.subjectid;
    }
    
    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
    
    @Column(name="subject", length=32)

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Column(name="teacher", length=32)

    public String getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
 
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subject")

    public Set<Score> getScores() {
        return this.scores;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subject")

    public Set<Score> getScores_1() {
        return this.scores_1;
    }
    
    public void setScores_1(Set<Score> scores_1) {
        this.scores_1 = scores_1;
    }
   








}