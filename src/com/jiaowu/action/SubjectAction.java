package com.jiaowu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.jiaowu.dao.ScoreDao;
import com.jiaowu.dao.SubjectDao;
import com.jiaowu.model.Score;
import com.jiaowu.model.Subject;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class SubjectAction extends ActionSupport{
	@Resource SubjectDao subjectDao;
	private Subject subject;
	public Subject getScore() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	private List<Subject> subjectList;
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	
private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
public String addSubject() throws Exception{
		
		System.out.println(subject.getSubjectid());
		subjectDao.AddSubject(subject);
		return "message";
		
	}
public String showSubject() {
    
    subjectList = subjectDao.QueryAllSubject();
    return "show_view";
}

public String deleteSubject() throws Exception {
	subjectDao.DeleteSubject(subject.getSubjectid());
    return "delete_message";
}
public String querySubjects() throws Exception {
	subjectList = subjectDao.QuerySubjectInfo(keyWords);
    return "show_view";
}

}
