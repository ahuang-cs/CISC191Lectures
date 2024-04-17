package edu.sdccd.cisc191;

import org.h2.tools.Server;

import java.sql.*;

public class DB {
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost:9092/./DBDemo;DB_CLOSE_ON_EXIT=FALSE;";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "sa";

    private Server server;
    private Connection conn;
    private Statement stmt;

    public DB() throws SQLException {
        server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        stmt = conn.createStatement();
    }

    public void createTables() throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS students(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(64))");
    }

    public void create(Student student) throws SQLException {
        String sql = "INSERT INTO students(name) VALUES(?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, student.getName());
        int numRows = ps.executeUpdate();
        if (numRows == 0) {
            throw new SQLException("No rows affected");
        }
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            student.setId(rs.getInt(1));
        }
    }
}
