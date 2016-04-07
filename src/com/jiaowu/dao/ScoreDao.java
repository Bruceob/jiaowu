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

@Service @Transactional
public class ScoreDao {
	@Resource SessionFactory factory;
	public void AddScore(Score score) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(score);
    }
	public void DeleteScore (Integer scoreId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object food = s.load(Score.class, scoreId);
        s.delete(scoreId);
    }
	public void UpdateScore(Score score) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(score);
    }
	public ArrayList<Score> QueryAllScore() {
        Session s = factory.getCurrentSession();
        String hql = "From Score";
        Query q = s.createQuery(hql);
        List scoreList = q.list();
        return (ArrayList<Score>) scoreList;
    }
	public Score GetScoreById(Integer scoreid) {
        Session s = factory.getCurrentSession();
        Score score = (Score)s.get(Score.class, scoreid);
        return score;
    }
	public ArrayList<Score> QueryScoreInfo(String subject) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Score score where 1=1";
    	if(!subject.equals("")) hql = hql + " and food.subject like '%" + subject + "%'";
    	Query q = s.createQuery(hql);
    	List scoreList = q.list();
    	return (ArrayList<Score>) scoreList;
    }
}
