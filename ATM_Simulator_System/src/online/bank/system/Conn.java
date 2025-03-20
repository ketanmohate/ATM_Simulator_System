
package online.bank.system;

import java.sql.*;

public class Conn {

	Connection c;
	Statement s;

	public Conn() {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// c
			// =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","ketan@9595");

			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "ketan@9595");

			// c =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem",
			// "root", "NishuPawar@123");
			s = c.createStatement();
		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
