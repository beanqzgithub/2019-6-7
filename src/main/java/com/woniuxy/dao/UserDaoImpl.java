package com.woniuxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.bean.User;
import com.woniuxy.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		Connection conn = null;
		PreparedStatement ps= null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into user values(null,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(null, ps, conn);
		}

	}

	public void delete(Integer id) {
		Connection conn = null;
		PreparedStatement ps= null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from user where id =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(null, ps, conn);
		}

	}

	public void update(User user) {
		Connection conn = null;
		PreparedStatement ps= null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update user set name=?,birthday=?,money=? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(null, ps, conn);
		}

	}

	public User findOne(Integer id) {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user=null;
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMoney(rs.getDouble("money"));				
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	public List<User> find() {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMoney(rs.getDouble("money"));
				list.add(user);
			}
			
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	public int getRowCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "selet count(*) from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int rowCount = 0;
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
			return rowCount;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

	public List<User> find(int startLine, int size) {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startLine);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMoney(rs.getDouble("money"));
				list.add(user);
			}
			
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

}
