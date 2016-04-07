package com.jiaowu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.jiaowu.model.Score;
import com.jiaowu.model.Subject;

@Service @Transactional
public class SubjectDao {
	@Resource SessionFactory factory;
	public void AddSubject(Subject subject) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(subject);
    }
	public void DeleteSubject (Integer subjectId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object Subject = s.load(Score.class, subjectId);
        s.delete(subjectId);
    }
	public void UpdateSubject(Subject subject) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(subject);
    }
	public ArrayList<Subject> QueryAllSubject() {
        Session s = factory.getCurrentSession();
        String hql = "From Subject";
        Query q = s.createQuery(hql);
        List subjectList = q.list();
        return (ArrayList<Subject>) subjectList;
    }
	public Subject GetSubjectById(Subject subjectid) {
        Session s = factory.getCurrentSession();
        Subject subject = (Subject)s.get(Subject.class, subjectid);
        return subject;
    }
	public ArrayList<Subject> QuerySubjectInfo(String subject) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Subject subject where 1=1";
    	if(!subject.equals("")) hql = hql + " and food.subject like '%" + subject + "%'";
    	Query q = s.createQuery(hql);
    	List subjectList = q.list();
    	return (ArrayList<Subject>) subjectList;
    }
}
