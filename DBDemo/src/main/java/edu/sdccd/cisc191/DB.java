package edu.sdccd.cisc191;

import edu.sdccd.cisc191.model.BaseEntity;
import edu.sdccd.cisc191.model.Enrollment;
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
        server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers", "-ifNotExists").start();
        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        stmt = conn.createStatement();
    }

    public void createTables() throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS students(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(64))");
        stmt.execute("CREATE TABLE IF NOT EXISTS courses(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(64))");
        stmt.execute("CREATE TABLE IF NOT EXISTS enrollments(courseId INT," +
                "studentId INT," +
                "date DATETIME," +
                "CONSTRAINT enrollment PRIMARY KEY(courseId,studentId)," +
                "FOREIGN KEY(courseId) REFERENCES courses(id)," +
                "FOREIGN KEY(studentId) REFERENCES students(id))");
    }

    public <T extends BaseEntity> void create(T obj, Class<T> clazz) throws SQLException {
        String sql = String.format("INSERT INTO %ss(name) VALUES(?)", clazz.getSimpleName());
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, obj.getName());
        int numRows = ps.executeUpdate();
        if (numRows == 0) {
            throw new SQLException("No rows affected");
        }
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            obj.setId(rs.getInt(1));
        }
    }

    public void create(Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO enrollments(courseId, studentId) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, enrollment.getCourse().getId());
        ps.setInt(2, enrollment.getStudent().getId());
        int numRows = ps.executeUpdate();
        if (numRows == 0) {
            throw new SQLException("No rows affected");
        }
        enrollment.setDate(getEnrollmentDate(enrollment));
    }

    private Time getEnrollmentDate(Enrollment enrollment) throws SQLException {
        String sql = "SELECT date FROM enrollments WHERE courseId=? AND studentId=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, enrollment.getCourse().getId());
        ps.setInt(2, enrollment.getStudent().getId());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            return rs.getTime("date");
        }
        return null;
    }
}
