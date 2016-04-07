package com.jiaowu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jiaowu.dao.UserDao;
import com.jiaowu.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class UserAction extends ActionSupport {
	@Resource UserDao userDao;
	private User user;
	private String errMessage;
	
	public String geterrMessage(){
		return errMessage;
		
	}
	public void seterrMessage(String errMessage){
		this.errMessage=errMessage;
		
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	
	public String login() {
		User db_user = (User)userDao.QueryUserInfo(user.getUserid()).get(0);
		if(db_user == null) { 
			this.errMessage = " �˺Ų����� ";
			System.out.print(this.errMessage);
			return INPUT;
		} else if( !db_user.getPassword().equals(user.getPassword())) {
			this.errMessage = " ���벻��ȷ! ";
			System.out.print(this.errMessage);
			return INPUT;
		}
		return "main_view";
	}
	  /*��ʾĳһFood����ϸ��Ϣ*/
    public String showDetail() {
    	user = userDao.GetUserById(user.getUserid());
        return "detail_view";
    }
    public String deleteEdit() throws Exception {
    	userDao.DeleteUser(user.getUserid());
        return "delete_message";
    }
}