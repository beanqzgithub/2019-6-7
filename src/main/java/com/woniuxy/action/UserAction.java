package com.woniuxy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniuxy.bean.Page;
import com.woniuxy.bean.User;
import com.woniuxy.service.IUserService;
import com.woniuxy.service.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	private int p;
	private int size;
	
	private IUserService service = new UserServiceImpl();
	public String save() {
//		System.out.println("ssss"+user);
		service.save(user);
		return "find";
	}
	public String find() {
		//通过数据库中元素找到所有User,并放入集合
//		List<User> list = service.find();
		Page page = service.findPageData(p, size);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "findUI";
	}
	public String update() {
		service.update(user);
		return "find";
	}
	public String delete() {
		service.delete(user.getId());
		return "find";
	}
	public String updateUI() {
		ServletActionContext.getRequest().setAttribute("user", service.findOne(user.getId()));
		return "updateUI";
	}
	
	public User getModel() {
		return user;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
