package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddFriend {

	public boolean validate(String friend, String email) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DAO.getConnection();
		Statement st = con.createStatement();
		String validate = "select * from profile where emailid='" + friend + "'";

		int n = st.executeUpdate(validate);

		if (n == 1) {
			String insert = "insert into friends values('" + email + "','" + friend + "')";
			int n1 = st.executeUpdate(insert);
			if (n1 == 1) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}

	}

	public ArrayList<String> getnames(String email) throws SQLException {
		Connection con = DAO.getConnection();
		Statement st = con.createStatement();
		ArrayList<String> names = new ArrayList<String>();

		String validate = "select name2 from friends where name1='" + email + "'";
		ResultSet rs = st.executeQuery(validate);
		while (rs.next()) {
			names.add(rs.getString(1));

		}
		return names;

	}
}