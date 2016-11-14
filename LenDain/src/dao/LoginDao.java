package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.LoginPojo;

public class LoginDao {

	public boolean validate(LoginPojo lp) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = DAO.getConnection();
		Statement st = con.createStatement();
		String validate = "select * from profile where emailid='" + lp.getEmailId() + "' and password='"
				+ lp.getPassword() + "'";

		int n = st.executeUpdate(validate);

		if (n == 1) {
			return true;
		} else {
			return false;

		}

	}

}
