import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseReader {

	public static ArrayList<String> baseRead() {

		ArrayList<String> resultCities = new ArrayList<String>();
		ResultSet set;
		Connection con;
		Statement stmt;

		try {

			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/sun?"
					+ "user=root&password=03111985");
			stmt = con.createStatement();

			set = stmt.executeQuery("select name from cities");

			while (set.next()) {

				resultCities.add(set.getString("name"));

			}

			stmt.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultCities;

	}

}
