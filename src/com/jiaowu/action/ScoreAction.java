package com.jiaowu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.jiaowu.dao.ScoreDao;
import com.jiaowu.model.Score;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class ScoreAction extends ActionSupport{
	@Resource ScoreDao scoreDao;
	private Score score;
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	private List<Score> scoreList;
	public List<Score> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}

	
private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
public String addScore() throws Exception{
		
		System.out.println(score.getScoreid());
		scoreDao.AddScore(score);
		return "message";
		
	}
public String showScore() {
    
    scoreList = scoreDao.QueryAllScore();
    return "show_view";
}
public String showDetail() {
	score = scoreDao.GetScoreById(score.getScoreid());
    return "detail_view";
}

public String queryScores() throws Exception {
	scoreList = scoreDao.QueryScoreInfo(keyWords);
    return "show_view";
}
public String showEdit() throws Exception {
	score = scoreDao.GetScoreById(score.getScoreid());
    return "edit_view";
}
public String editScore() throws Exception {
	scoreDao.UpdateScore(score);
    return "edit_message";
}
}
