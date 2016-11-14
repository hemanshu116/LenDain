package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.LoginPojo;

public class SignUp {

	public boolean validate(LoginPojo lp) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DAO.getConnection();
		Statement st = con.createStatement();
		String insert = "insert into profile values('" + lp.getEmailId() + "','" + lp.getPassword() + "','"
				+ lp.getName() + "','" + lp.getLastName() + "')";

		int n = st.executeUpdate(insert);

		if (n == 1) {
			return true;
		} else {
			return false;

		}

	}

}
