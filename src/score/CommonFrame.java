package score;

import java.sql.*;

public class CommonFrame {
    static Connection con = null;
    static Statement stmt = null;


    public static ResultSet getResult(String sql, Object... p) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/java_db?serverTimezone=UTC", "root", "1234");

            stmt = con.createStatement();
            stmt.execute("use `java_db`");

            PreparedStatement pst = con.prepareStatement(sql);
            for (int i = 0; i < p.length; i++) {
                pst.setObject(i+1, p[i]);
            }

            return pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
