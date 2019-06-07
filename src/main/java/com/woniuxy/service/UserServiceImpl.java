package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.Page;
import com.woniuxy.bean.User;
import com.woniuxy.dao.IUserDao;
import com.woniuxy.dao.UserDaoImpl;

public class UserServiceImpl implements IUserService {
	private IUserDao dao = new UserDaoImpl();
	public void save(User user) {
		dao.save(user);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public void update(User user) {
		dao.update(user);
	}

	public User findOne(Integer id) {
		return dao.findOne(id);
	}

	public List<User> find() {
		return dao.find();
	}

	public Page findPageData(int p, int size) {
		int rowCount = dao.getRowCount();
		Page page = new Page(p,rowCount,size);
		List<User> list = dao.find(page.getStartline(),page.getSize());
		page.setList(list);
		return page;
	}

}
