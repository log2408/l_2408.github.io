package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.JDBCUtil;
import SignInAndSignUp.account;
public class DAOAccount implements DAOInterface<account>{
	public static DAOAccount getInstance() {
		return new DAOAccount();
	}
	@Override
	public int Them(account t) {
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String sql = "insert into player(user, password, maxPoint) values ('" + t.getUser() + "','" + t.getPassword() + "'," + t.getMaxPoint() + ")";
			int kq = st.executeUpdate(sql);
			if(kq > 0) {
				System.out.println("Đã thực thi");
			} else {
				System.out.println("Chưa thực thi");
			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public int Sua(account t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int Xoa(account t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean check(account t) {
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String sql = "SELECT * FROM player WHERE user = '" + t.getUser() + "'";
			ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return true; 
            }
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
