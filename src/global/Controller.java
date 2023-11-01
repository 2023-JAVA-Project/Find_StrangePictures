package global;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Controller {
    Connection conn = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    Statement st = null;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String pw= "1234";

    public Controller() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버 문제 발생: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL, user,pw);
            System.out.println("연결 완료!");
        } catch (SQLException e) {
            System.err.println("연결 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertRank(Model model) {
        try {
            String sql = "INSERT INTO java_db.rank (name,score) VALUES (?,0)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, model.name.getText());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Model> readData() {
        ArrayList<Model> arr = new ArrayList<Model>();

        try {
            String sql = "SELECT name, score FROM java_db.rank ORDER BY score ASC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                JTextField str=new JTextField(name);
                arr.add(new Model(str, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arr;
    }





}
