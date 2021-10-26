package zw.co.muno;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class CrudApplication {

	static final Logger logger = Logger.getLogger(String.valueOf(CrudApplication.class));

	public static void main(String[] args) throws SQLException, Exception {
		String url = "jdbc:mysql://localhost:3306/crud_application";
		String userName = "root";
		String psw = "Muno@123";
		String query = "SELECT * FROM user";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, psw);
		Statement st = con.createStatement();
		while (true) {

			logger.info("Select options from the menu below:");
			logger.info("Select\n1 to read\n2 to create\n3 to update\n4 to delete");
			Scanner sc = new Scanner(System.in);
			int DataInput = sc.nextInt();
			switch (DataInput) {
			case 1:

				try {
					String selectSql = "SELECT * from user";

				ResultSet	resultSet = st.executeQuery(selectSql);
				//	st.executeQuery(query);

					while (resultSet.next()) {
						logger.info(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
								+ " " + resultSet.getString(4) + " " + resultSet.getString(5) + " "
								+ resultSet.getString(6) + " " + resultSet.getString(7) + " " + resultSet.getString(8));
					}
				} catch (SQLException e) {
					e.printStackTrace();
					logger.severe("Exception");
				}

				break;
			case 2:

				try {

					Scanner sc2 = new Scanner(System.in);
					logger.info("Enter Username: ");
					String Username = sc2.nextLine();
					logger.info("Enter Firstname: ");
					String Firstname = sc2.nextLine();
					logger.info("Enter Surname: ");
					String Surname = sc2.nextLine();
					logger.info("Enter Email: ");
					String Email = sc2.nextLine();
					logger.info("Enter Date of Birth: ");
					String DOB = sc2.nextLine();
					logger.info("Enter Phone Number: ");
					String phone_number = sc2.nextLine();
					logger.info("Enter Address: ");
					String Address = sc2.nextLine();
					logger.info("Enter Password: ");
					String Password = sc2.nextLine();

					query = "INSERT INTO user(Username,Firstname,Surname,Email,dateOfBirth,PhoneNumber,Address,Password)"
							+ "VALUES(?,?,?,?,?,?,?,?)";

					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1, Username);
					stmt.setString(2, Firstname);
					stmt.setString(3, Surname);
					stmt.setString(4, Email);
					stmt.setString(5, DOB);
					stmt.setString(6, phone_number);
					stmt.setString(7, Address);
					stmt.setString(8, Password);
					stmt.execute();

					logger.info("Data Entered Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
					logger.severe("Exception");
				}
				break;
			case 3:

				try {

					Scanner sc3 = new Scanner(System.in);
					logger.info("Enter username ");
					String Username = sc3.nextLine();
					logger.info("Enter phoneNumber ");
					String phoneNumber = sc3.nextLine();
					String UPDATE_USERS_SQL = "update user SET PhoneNumber=? WHERE Username = ? ";
					PreparedStatement stmt = con.prepareStatement(UPDATE_USERS_SQL);
					stmt.setString(1, phoneNumber);
					stmt.setString(2, Username);
					stmt.execute();

					logger.info("Data updated successfully");
				} catch (SQLException e) {
					e.printStackTrace();
					logger.severe("Exception");
				}
				break;

			case 4:

				try

				{

					Scanner sc3 = new Scanner(System.in);
					logger.info("Enter Username you want to delete");
					String Username = sc3.nextLine();
					String sql = ("delete from user where Username= ?");
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, Username);
					stmt.execute();

					logger.info("Data deleted successfully");
				} catch (SQLException e) {
					e.printStackTrace();
					logger.severe("Exception");
				}
				break;

			}
			{
			}

		}
	}
}